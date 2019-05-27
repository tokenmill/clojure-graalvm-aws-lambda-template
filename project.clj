(defproject clojure-graalvm-aws-lambda/lein-template "0.3.2"
  :description "Template for AWS Lambda with Clojure tools-deps, GraalVM, Docker, and Gitlab CI"
  :url "https://github.com/tokenmill/clojure-graalvm-aws-lambda-template"
  :license {:name "Apache License Version 2.0, January 2004"
            :url "http://www.apache.org/licenses/"}
  :deploy-repositories [["releases"  {:sign-releases false :url "https://clojars.org"}]
                        ["snapshots" {:sign-releases false :url "https://clojars.org"}]]
  :scm {:name "git"
        :url "https://github.com/tokenmill/clojure-graalvm-aws-lambda-template"}
  :eval-in-leiningen true)
