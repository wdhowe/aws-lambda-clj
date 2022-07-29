(ns aws-lambda-clj-scheduled.aws-lambda-clj-scheduled-test
  (:require [clojure.test :refer [deftest is testing]]
            [aws-lambda-clj-scheduled.aws-lambda-clj-scheduled :as aws-lambda]
            [clojure.java.io :as io]))

(deftest test-stream->map
  (testing "Stream to map conversion."
    (let [stream (io/input-stream "./test/aws_lambda_clj_scheduled/resources/scheduled_event.json")
          event (aws-lambda/stream->map stream)]
      (is (= (:region event) "us-east-1"))
      (is (= (:source event) "aws.events")))))
