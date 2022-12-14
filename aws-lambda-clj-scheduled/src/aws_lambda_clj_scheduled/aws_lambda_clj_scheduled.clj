(ns aws-lambda-clj-scheduled.aws-lambda-clj-scheduled
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io])
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler]))

(defn stream->map
  "Transforms an input stream into a clojure map."
  [in]
  (json/read (io/reader in) :key-fn keyword))

(defn -handleRequest
  "Implementation for RequestStreamHandler that handles a Lambda Function request"
  [_ input-stream _output-stream _context]
  (println "-handleRequest called with input stream:" (stream->map input-stream)))
