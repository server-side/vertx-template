(ns leiningen.new.vertx-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "vertx-template"))

(defn vertx-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' vertx-template project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["pom.xml" (render "pom.xml" data)]
             ["vertx_classpath.txt" (render "vertx_classpath.txt" data)]
             ["src/main/resources/mod.json" (render "mod.json" data)]
             ["src/main/clojure/main.clj" (render "main.clj" data)]
             )))
