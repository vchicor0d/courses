(ns collatz-conjecture)

(defn conjecture [num step]
  (if (= num 1)
    step
    (case (= (mod num 2) 0)
      true (conjecture (/ num 2) (inc step))
      false (conjecture (inc (* num 3)) (inc step)))))

(defn collatz [num] ;; <- arglist goes here
  ;; your code goes here
  (conjecture num 0)
)
