(ns bob
  (:require
   [clojure.string :as str]))

(defn response-for [s]
  (let [s (str/trim s)]
    (cond
      (and (= s (str/upper-case s)) (str/ends-with? s "?") (re-matches #"[A-Z]+[A-Z\.,;'!:\- ]*\?" s)) "Calm down, I know what I'm doing!"
      (str/ends-with? s "?") "Sure."
      (str/blank? s) "Fine. Be that way!"
      (and (= s (str/upper-case s)) (some #(Character/isLetter %) s)) "Whoa, chill out!"
      :else "Whatever.")))
