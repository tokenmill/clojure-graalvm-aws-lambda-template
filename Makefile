TEMPLATE_MAKE=cd your-lambda && make

try-template-locally:
	rm -rf your-lambda/
	lein new clojure-graalvm-aws-lambda your-lambda
	${TEMPLATE_MAKE} build-lambda-zip
	cd ..
	rm -rf your-lambda/
