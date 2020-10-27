(ns binary)

(defn digits-list [number]
  (loop [number number
         list ()]
    (if (< number 10)
      (conj list (mod number 10))
      (recur (quot number 10) (conj list (mod number 10))))))

(defn binary? [bin-list]
  (let [filtered (filter
                  (fn [bin-digit]
                    (or (= 0 bin-digit) (= 1 bin-digit)))
                  bin-list)]
    (= bin-list filtered)))

(defn power [n e]
  (reduce * (repeat e n)))

(defn to-decimal [bin-num]
  (if (= bin-num (re-matches #"\d+" bin-num))
    (let [bin-list (digits-list (Long/parseLong bin-num))]
      (if (binary? bin-list)
        (do
          (loop [bin-list bin-list
                 iter 0
                 acum 0]
            (if (empty? bin-list)
              acum
              (recur (take
                      (- (count bin-list) 1)
                      bin-list)
                     (inc iter)
                     (+ acum (if (and (= (last bin-list) 0) (= iter 0))
                               0
                               (power (* 2 (last bin-list)) iter)))))))
        0))
    0))
