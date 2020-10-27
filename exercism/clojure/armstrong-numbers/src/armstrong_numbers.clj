(ns armstrong-numbers)

;; Replaced flatten and recursive call with conj and loop+recur
(defn digits-list [number]
  (loop [number number
         list ()]
    (if (< number 10)
      (conj list (mod number 10))
      (recur (quot number 10) (conj list (mod number 10))))))

;(defn digits-list [number]
;  (flatten
;   (list
;    (if (> number 10)
;      ;; Replaced (long (/ .. by (quot
;      (digits-list (quot number 10)))
;    (mod number 10))))

(defn power [n e]
  (reduce * (repeat e n)))

(defn armstrong? [num]
  ;; Changed def for let, .size for count  
  (let [num-as-list (digits-list num)
        ;; Merged two let functions into one
        digits (count num-as-list)]
       (= num
         ;; Replace latter code with thread-last macro
         (->> num-as-list
             (map (fn [x] (power x digits)))
             (reduce +))))
         ;(reduce +
         ;        (map
         ;         (fn [x]
         ;           (power x digits))
         ;         num-as-list)))))
)

