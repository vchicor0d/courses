(ns bob)

(defn response-for [s]
  (let [s (clojure.string/trim s)]
    (cond
      (and (= s (clojure.string/upper-case s)) (clojure.string/ends-with? s "?") (re-matches #"[A-Z]+[A-Z.,;'!:- ]*?" s)) "Calm down, I know what I'm doing!"
      (clojure.string/ends-with? s "?") "Sure."
      (clojure.string/blank? s) "Fine. Be that way!"
      (= s (clojure.string/upper-case s)) "Whoa, chill out!"
      :else "Whatever.")))
