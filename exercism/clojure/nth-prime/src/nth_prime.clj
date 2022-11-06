(ns nth-prime)

(defn- prime? [n]
  (loop [current 2]
    (let [module (mod n current)
          result (/ n current)]
      (if (and (> n current) (zero? module))
        false
        (if (< result current)
          true
          (recur (inc current)))))))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (if (<= n 0)
    (throw (IllegalArgumentException.))
    (last (take n (filter prime? (filter #(> % 1) (range)))))))
