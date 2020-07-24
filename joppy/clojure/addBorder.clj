;; Given a rectangular matrix of characters, add a border of asterisks(*) to it.

;; Example

;; For

;; picture = ["abc",
;;            "ded"]

;; the output should be

;; addBorder(picture) = ["*****",
;;                       "*abc*",
;;                       "*ded*",
;;                       "*****"]

;; Input/Output

;;     [execution time limit] 16 seconds (clj)

;;     [input] array.string picture

;;     A non-empty array of non-empty equal-length strings.

;;     Guaranteed constraints:
;;     1 ≤ picture.length ≤ 100,
;;     1 ≤ picture[i].length ≤ 100.

;;     [output] array.string
;;         The same matrix of characters, framed with a border of asterisks of width 1.

(defn addBorder [picture] 
  (let [width (count (first picture))]
    (flatten
     (conj [] 
           (reduce str (repeat (+ 2 width) "*"))
           (map #(str "*" % "*") picture)
           (reduce str (repeat (+ 2 width) "*"))))))
