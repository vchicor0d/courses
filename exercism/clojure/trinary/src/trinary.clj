(ns trinary)

(defn digits-list [number]
  (loop [number number
         list ()]
    (if (< number 10)
      (conj list (mod number 10))
      (recur (quot number 10) (conj list (mod number 10))))))

(defn trinary? [trin-list]
  (let [filtered (filter
                  (fn [trin-digit]
                    (or (= 0 trin-digit) (= 1 trin-digit) (= 2 trin-digit)))
                  trin-list)]
    (= trin-list filtered)))

(defn power [n e]
  (reduce * (repeat e n)))

(defn to-decimal [trin-num]
  (if (= trin-num (re-matches #"\d+" trin-num))
    (let [trin-list (digits-list (Long/parseLong trin-num))]
      (if (trinary? trin-list)
        (do
          (loop [trin-list trin-list
                 iter 0
                 acum 0]
            (if (empty? trin-list)
              acum
              (recur (take
                      (- (count trin-list) 1)
                      trin-list)
                     (inc iter)
                     (+ acum (if (and (= (last trin-list) 0) (= iter 0))
                               0
                               (* (last trin-list) (power 3 iter))))))))
        0))
    0))
