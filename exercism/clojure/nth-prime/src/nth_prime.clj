(ns nth-prime)

(defn- prime? [n]
  (loop [current 2]
    (if (and (> n current) (= 0 (mod n current)))
      false
      (if (= n current)
        true
        (recur (inc current))))))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (if (<= n 0)
    (throw (IllegalArgumentException.))
    (last (take n (filter prime? (filter #(> % 1) (range)))))))
