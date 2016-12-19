(ns job-processor.handler
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]))

(defn run [code] (eval (read-string code)))

(defn handler [request]
  (let [code (get-in request [:body :code])
        result (pr-str (run code))]
      (response result)))

(def app
  (-> handler
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))
