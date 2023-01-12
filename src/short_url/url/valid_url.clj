(ns short-url.url.valid-url)

(def protocol-regex #"^(http|https):\/\/\S*")

(defn valid-protocol?
  "Return true if the url
  is HTTP or HTTPs."
  [url]

  (not= (re-matches protocol-regex url) nil))
