(ns acronym)

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (apply str (map #(re-seq #"") (clojure.string/split phrase #"[ \-]"))))
