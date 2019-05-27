# clojure-graalvm-aws-lambda-template

[![Clojars Project](https://img.shields.io/clojars/v/clojure-graalvm-aws-lambda/lein-template.svg)](https://clojars.org/clojure-graalvm-aws-lambda/lein-template)
[![pipeline status](https://gitlab.com/Jocas/clojure-graalvm-aws-lambda-template/badges/master/pipeline.svg)](https://gitlab.com/Jocas/clojure-graalvm-aws-lambda-template/commits/master)

A Leiningen template for AWS Lambda custom runtime with GraalVM compiled Clojure project.

Published in [Clojars](https://clojars.org/clojure-graalvm-aws-lambda/lein-template)

## Usage

Run:
```
lein new clojure-graalvm-aws-lambda your-lambda
```

This results in a project structure like this:
```
$ tree -a your-lambda
your-lambda
├── bootstrap
├── deps.edn
├── Dockerfile
├── .gitignore
├── .gitlab-ci.yml
├── lambda.yml
├── Makefile
├── README.md
└── src
    └── lambda
        └── core.clj

2 directories, 9 files

```

Then 
```
cd your-lambda
```

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

Lambda is ready to be used. Go to your AWS Console to work with the new stack named `lambda-custom-runtime-your-lambda`.

## License

This project is licensed under the Apache 2.0 License - see the LICENSE file for details
