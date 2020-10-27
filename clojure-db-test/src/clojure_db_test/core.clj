(ns clojure-db-test.core
  (:gen-class)
  (:require [clojure.java.jdbc :as jdbc]))

(def alimerka-local-db
  {:dbtype "oracle"
   :dbname "XE"
   :user "alimerka"
   :password "Director3"})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (jdbc/query alimerka-local-db ["select description from cor_sku_sku"]))
