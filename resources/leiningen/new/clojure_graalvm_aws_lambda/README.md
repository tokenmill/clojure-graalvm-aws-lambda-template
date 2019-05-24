# {{name}}

Custom AWS Lambda runtime with the Clojure `tools-deps` application compiled with GraalVM `native-image`.

## TL;DR

Set these environment variables:
- MY_AWS_DEFAULT_REGION
- MY_AWS_ACCESS_KEY_ID
- MY_AWS_SECRET_ACCESS_KEY
- MY_S3_BUCKET
- MY_S3_FOLDER

Run:
```
make deploy-lambda-via-container
```

Lambda is ready to be used. Go to your AWS Console to work with the new stack named `lambda-custom-runtime-{{lambda-name}}`.

## What is in the package

Most common operations are scripted in the Makefile:
- `make build-native-image`: inside the docker with the GraalVM builds native binary for the lambda and copies it to the project folder two files: `server` and `libsunec.so`
- `make build-lambda-zip`: inside the docker creates a custom AWS lambda runtime zip archive and copies it to the project folder as a `function.zip` file (for manual deployments).
- `make deploy-custom-runtime-lambda`: (use it if you have `awscli` installed and configured) builds a deployable lambda zip and deploys it to AWS.
- `make deploy-lambda-via-container`: builds lambda zip and deploys to AWS with your provided credentials (set the environment variables (e.g. `(export MY_AWS_DEFAULT_REGION=eu-west-1 && <set other enviroment variables> && make deploy-lambda-via-container)` or use something like [dotenv](https://github.com/robbyrussell/oh-my-zsh/tree/master/plugins/dotenv), or some other way).

## Prerequisites

This demo assumes that docker is available in the system.

## Usage

- Modify `request->response` function to do the work you need.
- When needed add libraries to the `deps.edn` (with a little more work Git deps from private git repositories can be achieved).
- Build native image with GraalVM inside a docker
- Configure CI (for environment variables)
- Deploy to AWS Lambda

```clojure
(defn request->response [request]
  (let [decoded-request (json/read-value request read-mapper)]
    (json/write-value-as-string decoded-request)))
```

## CI/CD

`.gitlab-ci.yml` file includes a demo on how the lambda can be deployed from the Gitlab CI pipeline. Create environment variables in the CI/CD setup of your project.
