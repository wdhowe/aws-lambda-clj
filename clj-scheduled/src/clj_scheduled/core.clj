(ns clj-scheduled.core
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io])
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler]))

(defn stream->map
  "Transforms an input stream,`in`,into a clojure map with keywords."
  [in]
  (json/read (io/reader in) :key-fn keyword))

(defn map->stream
  "Writes a map,`m`,to an output stream,`out`."
  [m out]
  (with-open [w (io/writer out)]
    (json/write m w)))

(defn process-event
  "Process the lambda event."
  [event]
  (println "Got lambda event:" event)
  {:status "ok"})

(defn -handleRequest
  "Entrypoint for the lambda function. The event is input stream,`in`."
  [_self in out _context]
  (-> (stream->map in)
      (process-event)
      (map->stream out)))
