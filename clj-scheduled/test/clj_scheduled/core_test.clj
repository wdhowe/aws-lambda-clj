(ns clj-scheduled.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [clj-scheduled.core :as clj-lambda]
            [clojure.java.io :as io]))

(deftest test-stream->map
  (testing "Stream to map conversion."
    (let [stream (io/input-stream "./test/clj_scheduled/resources/scheduled_event.json")
          event (clj-lambda/stream->map stream)]
      (is (= (:region event) "us-east-1"))
      (is (= (:source event) "aws.events")))))
