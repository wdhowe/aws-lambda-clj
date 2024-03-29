(defproject com.github.wdhowe/aws-lambda-clj-scheduled "0.1.0"

  ;;; Project Metadata
  :description "A simple AWS Lambda function that prints the request stream."
  :url "https://github.com/wdhowe/aws-lambda-clj"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  ;;; Dependencies, Plugins
  :dependencies [[org.clojure/clojure "1.11.2"]
                 [org.clojure/data.json "2.5.0"]
                 [com.amazonaws/aws-lambda-java-runtime-interface-client "2.4.1"]]

  ;;; Profiles
  :profiles {:uberjar {:aot :all}}

  ;;; Running Project Code
  :repl-options {:init-ns aws-lambda-clj-scheduled.core})
