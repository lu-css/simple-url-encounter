(ns short-url.url.make-url
  (:require
   [clojure.string :as string]))

(def url-safe-chars (-> "abcdefghijklmnopqrstuvwxyz0123456789-._~()'!*:@,;" (string/split #"")))

(defn get-safe-url
  "Return a URL safe string with specified lenght."
  [lenght]

  (->> (map (fn [_] (rand-nth url-safe-chars)) (range lenght))
       (string/join "")))
