(defproject job-processor "0.1.0-SNAPSHOT"
  :description "Stupid Simple Job Processor"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.4.0"]
                 [yieldbot/flambo "0.8.0"]]

  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler job-processor.handler/app}
  :profiles { :dev {:aot [job-processor.handler]} 
              :provided
                {:dependencies [[javax.servlet/servlet-api "2.5"]
                                [ring/ring-mock "0.3.0"]
                                [org.apache.spark/spark-core_2.11 "2.0.1"]]}})
