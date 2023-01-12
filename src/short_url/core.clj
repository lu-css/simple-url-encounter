(ns short-url.core
  (:require [compojure.core :refer [GET POST defroutes]]
            [org.httpkit.server :as server]
            [short-url.db.manage-urls :as url]
            [ring.middleware.json :as mj]
            [ring.middleware.defaults :refer [api-defaults, wrap-defaults]])

  (:gen-class))

(def port 3000)

(defroutes app-routes
  (GET "/:code" [code] (url/get-redirect-url code))
  (POST "/" [] (mj/wrap-json-body url/add-url {:keywords? true})))

(defn -main
  [& _args]
  (server/run-server  (wrap-defaults #'app-routes api-defaults)  {:port port})
  (println (str "Servidor rodando na porta: " port)))
