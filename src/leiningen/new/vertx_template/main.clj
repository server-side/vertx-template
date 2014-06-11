(ns main
    (:require [vertx.core :as core]
              [vertx.http :as http]))

(defn req-handler [req]
  (println "Got request:" (.uri req))
  (println "Headers are:" (pr-str (http/headers req)))
  (-> (http/server-response req)
    (http/add-header "Content-Type" "text/html; charset=UTF-8")
    (http/end "<html><body><h1>Hello from vert.x!</h1></body></html>\n")))

(-> (http/server)
    (http/on-request req-handler)
    (http/listen 8080))


; you can create periodic timer like this

;(println "vertx core/periodic will print Hello Vert.x every 1000ms")
;(core/periodic 1000
;  (println "Hello from vertx!"))

