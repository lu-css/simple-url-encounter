(ns short-url.db.manage-urls
  (:require [short-url.db.urls :as sql]
            [short-url.url.make-url :as url]
            [short-url.url.valid-url :as v]
            [short-url.db :refer [db]]))

(defn- register-url
  [url]

  (let [code (url/get-safe-url 6)]
    (println code)
    (when (= (sql/insert-url db {:code code, :original url}) 1)
      code)))

(defn add-url
  "Adds a new URL.
  And return the code."
  [req]

  (let [url (:url (:body req))]
    (when (v/valid-protocol? url)
      (register-url url))))

(defn get-url
  "Returns the url of given code."
  [code]

  (sql/url-by-id db {:code code}))

(defn get-redirect-url
  "Return a redicted url"
  [code]

  (let [url (:original (get-url code))]
    (str "<meta http-equiv=\"refresh\" content=\"0; URL='"
         url
         "'\"/>")))
