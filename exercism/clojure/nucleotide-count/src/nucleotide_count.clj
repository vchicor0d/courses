(ns nucleotide-count)

(defn split-strand [strand]
  (seq strand))

(defn count-nucleotide [nucleotide strand]
  (def number 0)
  (doseq [nuc strand]
    (if (= nucleotide nuc)
      (def number (inc number))))
  number)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (or (= nucleotide \A) (= nucleotide \T) (= nucleotide \C) (= nucleotide \G))
    (count-nucleotide nucleotide (split-strand strand))
    (throw "Invalid nucleotide passed"))
)


(defn nucleotide-counts [strand]
  (if (re-matcher #"[ATCG]+" strand)
    (let [splited-strand (split-strand strand)
          A-count (count-nucleotide \A splited-strand)
          T-count (count-nucleotide \T splited-strand)
          C-count (count-nucleotide \C splited-strand)
          G-count (count-nucleotide \G splited-strand)]
      {\A A-count, \T T-count, \C C-count, \G G-count})
    (throw "Invalid nucleotide detected"))
)
