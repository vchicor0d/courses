;; Find the greatest common divisor of two given integer numbers. Each number is given in the form of its prime factorization - a sorted array of all prime factors.

;; Example

;; For a = [2, 3, 3, 3, 5] and b = [2, 2, 2, 2, 3, 3], the output should be factorizedGCD(a, b) = 18.

;; a = 270 and b = 144, thus gcd(a, b) = gcd(270, 144) = 18.

(defn factorizedGCD [a b] 
  (let [A (reduce * a)
        B (reduce * b)]
    (loop [maxN (max A B)
           minN (min A B)]
      (let [remainder (mod maxN minN)]
        (println (str "max: " maxN " min: " minN " remainder: " remainder))
        (if (= 0 remainder)
          minN
          (recur minN (mod maxN minN)))))))
