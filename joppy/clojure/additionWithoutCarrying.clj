;; A little boy is studying arithmetics. He has just learned how to add two integers, written one below another, column by column. But he always forgets about the important part - carrying.

;; Given two integers, your task is to find the result which the little boy will get.

;; Note: The boy had learned from this site, so feel free to check it out too if you are not familiar with column addition.

(defn additionWithoutCarrying [param1 param2] 
  (loop [n1 (if (zero? param1) "" (str param1))
         n2 (if (zero? param2) "" (str param2))
         sum (if (and (zero? param1) (zero? param2)) ["0"] [])]
    (if (and (empty? n1) (empty? n2))
      (read-string
       (reduce str
               (reverse
                (if (and (> (count sum) 1) (= \0 (last sum)))
                  (take (dec (count sum)) sum)
                  sum))))
      (recur
       (take (dec (count n1)) n1)
       (take (dec (count n2)) n2)
       (conj sum 
             (last 
              (str 
               (+ 
                (if (empty? n1) 
                  0 
                  (read-string 
                   (str 
                    (last n1)))) 
                (if (empty? n2) 
                  0 
                  (read-string 
                   (str 
                    (last n2))))))))))))
