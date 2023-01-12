(ns short-url.db.urls
  (:require [hugsql.core :as sql]))

(sql/def-db-fns "sql/urls.sql")

(sql/def-sqlvec-fns "sql/urls.sql")
