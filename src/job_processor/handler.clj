(ns job-processor.handler
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]
            [flambo.conf :as conf]
            [flambo.api :as f]))

(def c (->  (conf/spark-conf)
            (conf/master "local")
            (conf/app-name "job-processor")))

(def sc (f/spark-context c))

(defn run [code] (eval (read-string code)))

(defn handler [request]
  (let [code (get-in request [:body :code])
        result (pr-str (run code))]
      (response result)))

(def app
  (-> handler
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))
