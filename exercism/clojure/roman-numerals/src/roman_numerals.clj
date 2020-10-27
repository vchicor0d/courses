(ns roman-numerals)

(defn arab-to-roman [num]
  (def roman "")
  (def numvar num)
  (if (>= (/ num 1000) 1)
    (do
      (def roman (str roman (clojure.string/join (repeat (/ num 1000) "M"))))
      (def numvar (mod numvar 1000))))
  (if (>= (/ numvar 900) 1)
    (do
      (def roman (str roman "CM"))
      (def numvar (mod numvar 900))))
  (if (>= (/ numvar 500) 1)
    (do
      (def roman (str roman "D"))
      (def numvar (mod numvar 500))))
  (if (>= (/ numvar 400) 1)
    (do
      (def roman (str roman "CD"))
      (def numvar (mod numvar 400))))
  (if (>= (/ numvar 100) 1)
    (do
      (def roman (str roman (clojure.string/join (repeat (/ numvar 100) "C"))))
      (def numvar (mod numvar 100))))
  (if (>= (/ numvar 90) 1)
    (do
      (def roman (str roman "XC"))
      (def numvar (mod numvar 90))))
  (if (>= (/ numvar 50) 1)
    (do
      (def roman (str roman "L"))
      (def numvar (mod numvar 50))))
  (if (>= (/ numvar 40) 1)
    (do
      (def roman (str roman "XL"))
      (def numvar (mod numvar 40))))
  (if (>= (/ numvar 10) 1)
    (do
      (def roman (str roman (clojure.string/join (repeat (/ numvar 10) "X"))))
      (def numvar (mod numvar 10))))
  (if (>= (/ numvar 9) 1)
    (do
      (def roman (str roman "IX"))
      (def numvar (mod numvar 9))))
  (if (>= (/ numvar 5) 1)
    (do
      (def roman (str roman "V"))
      (def numvar (mod numvar 5))))
  (if (>= (/ numvar 4) 1)
    (do
      (def roman (str roman "IV"))
      (def numvar (mod numvar 4))))
  (if (>= (/ numvar 1) 1)
    (do
      (def roman (str roman (clojure.string/join (repeat (/ numvar 1) "I"))))
      (def numvar (mod numvar 1))))
  roman)
    

(defn numerals [arab] ;; <- arglist goes here
  ;; your code goes here
  (arab-to-roman arab)
)
