


(defn addBinaryStrings [a b] 
  (loop [num1 a
         num2 b
         result []
         carry 0]
    (if (and (empty? num1) (empty? num2))
      (if (= 0 carry)
        (reduce str (reverse result))
        (reduce str (reverse (conj result carry))))
      (if (empty? num1)
        (recur num1
               (take (dec (count num2)) num2)
               (conj result (if (= 3 (+ (Integer. (str (last num2))) carry))
                              1
                              (if (= 2 (+ (Integer. (str (last num2))) carry))
                                0
                                (+ (Integer. (str (last num2))) carry))))
               (if (>= (+ (Integer. (str (last num2))) carry) 2) 1 0))
        (if (empty? num2)
          (recur (take (dec (count num1)) num1)
                 num2
                 (conj result (if (= 3 (+ (Integer. (str (last num1))) carry))
                                1
                                (if (= 2 (+ (Integer. (str (last num1))) carry))
                                  0
                                  (+ (Integer. (str (last num1))) carry)))) (if (>= (+ (Integer. (str (last num1))) carry) 2)
                                                                              1
                                                                              0))
          (let [lastn1 (Integer. (str (last num1)))
                lastn2 (Integer. (str (last num2)))
                sum (if (= 3 (+ lastn1 lastn2 carry)) 1 (if (= 2 (+ lastn1 lastn2 carry)) 0 (+ lastn1 lastn2 carry)))
                carr (if (>= (+ lastn1 lastn2 carry) 2) 1 0)] 
            (println "Num1: " num1 " Num2: " num2 " Last n1: " lastn1 " Last n2: " lastn2 " Sum: " sum " Carry: " carr)
            (recur 
             (take (dec (count num1)) num1) 
             (take (dec (count num2)) num2)
             (conj result sum)
             carr)))))))
