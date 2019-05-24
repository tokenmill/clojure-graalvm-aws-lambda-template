build-native-image:
	docker build --target builder -t graalvm-compiler .
	docker rm build || true
	docker create --name build graalvm-compiler
	docker cp build:/usr/src/app/target/app server
	docker cp build:/usr/src/app/libsunec.so libsunec.so

build-lambda-zip:
	docker build --target archiver -t lambda-runtime-archiver .
	docker rm build || true
	docker create --name build lambda-runtime-archiver
	docker cp build:/usr/src/app/function.zip function.zip

stack=lambda-custom-runtime-{{lambda-name}}

deploy-custom-runtime-lambda: build-lambda-zip
	aws cloudformation package \
        --template-file lambda.yml \
        --s3-bucket bucket-name \
        --s3-prefix folder-name \
        --output-template-file /tmp/lambda-packaged.yml
	aws cloudformation deploy \
        --template-file /tmp/lambda-packaged.yml \
        --stack-name $(stack) \
        --capabilities CAPABILITY_IAM \
        --no-fail-on-empty-changeset
	rm function.zip

deploy-lambda-via-container:
	docker build --target deployer \
	--build-arg AWS_DEFAULT_REGION=${MY_AWS_DEFAULT_REGION} \
	--build-arg AWS_ACCESS_KEY_ID=${MY_AWS_ACCESS_KEY_ID} \
	--build-arg AWS_SECRET_ACCESS_KEY=${MY_AWS_SECRET_ACCESS_KEY} \
	--build-arg S3_BUCKET=$(or ${MY_S3_BUCKET}, "bucket-name") \
	--build-arg S3_FOLDER=$(or ${MY_S3_FOLDER}, "folder-name") \
	--build-arg STACK_NAME="lambda-custom-runtime-{{lambda-name}}" \
	-t lambda-deployer .

invoke-function:
	aws lambda invoke --function-name {{lambda-name}} --payload '{"text":"Hello"}' /dev/stdout
