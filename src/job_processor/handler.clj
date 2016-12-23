(ns job-processor.handler
  (:require [compojure.core :refer :all]
    [ring.util.response :refer [response]]
    [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
    [ring.middleware.json :refer [wrap-json-body]]))

(defn read-eval
  [function]
  (let [reads (read-string function)
        evals (eval reads)]
      evals))

(defn read-evals
  [& functions]
  (apply map read-eval functions))


(defn handler [request]
  (let [body (get-in request [:body])
        input (:input body)
        commands (reverse (:commands body))
        input-evaled (read-eval input)
        commands-evaled (apply comp (read-evals commands))
        result (->> input-evaled commands-evaled)]
      (response (pr-str result))))


(def app
  (-> handler
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))
