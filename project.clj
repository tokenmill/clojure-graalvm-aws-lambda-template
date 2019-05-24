(defproject clojure-graalvm-aws-lambda/lein-template "0.3.0"
  :description "Template for AWS Lambda with Clojure tools-deps, GraalVM, Docker, and Gitlab CI"
  :url "https://gitlab.com/Jocas/clojure-graalvm-aws-lambda-template"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :deploy-repositories [["releases"  {:sign-releases false :url "https://clojars.org"}]
                        ["snapshots" {:sign-releases false :url "https://clojars.org"}]]
  :eval-in-leiningen true)
