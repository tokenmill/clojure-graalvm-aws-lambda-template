(ns leiningen.new.clojure-graalvm-aws-lambda
  (:require [clojure.string :as s]
            [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "clojure-graalvm-aws-lambda"))

(defn name-to-lambda-name [name]
  (let [[x & xs] (s/split name #"-")]
    (str x (s/join (map s/capitalize xs)))))

(defn clojure-graalvm-aws-lambda [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :lambda-name (name-to-lambda-name name)}]
    (main/info "Generating fresh 'lein new' clojure-graalvm-aws-lambda project.")
    (->files data
             ["src/lambda/core.clj" (render "core.clj" data)]
             [".gitignore" (render "gitignore" data)]
             [".gitlab-ci.yml" (render "gitlab-ci.yml" data)]
             ["bootstrap" (render "bootstrap" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["lambda.yml" (render "lambda.yml" data)]
             ["Makefile" (render "Makefile" data)]
             ["README.md" (render "README.md" data)])))
