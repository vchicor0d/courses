(ns all-your-base)

(defn valid-number? [base number]
  (def valid true)
  (doseq [n number]
    (if (or (>= n base) (< n 0))
      (def valid false)))
  valid)

(defn valid? [source-base number dest-base]
  (if (or (< source-base 2) (< dest-base 2))
    false
    (valid-number? source-base number)))

(defn power [n e]
  (reduce * (repeat e n)))

(defn base-to-dec [base number]
  (loop [number number
         iter 0
         acum 0]
    (if (empty? number)
      acum
      (recur (take
              (- (count number) 1) number)
             (inc iter)
             (+ acum (* (last number) (power base iter))))))
    
  )

(defn dec-to-base [number base]
  (if (= 0 number)
    '(0)
    (loop [number number
           base-num ()]
      (if (= number 0)
        base-num
        (recur (quot number base) (conj base-num (mod number base))))
      )))

(defn digits-list [number]
  (loop [number number
         list ()]
    (if (< number 10)
      (conj list (mod number 10))
      (recur (quot number 10) (conj list (mod number 10))))))

(defn convert [source-base number dest-base]
  (if (valid? source-base number dest-base)
    (if (empty? number)
      number
      (let [number-dec (base-to-dec source-base number)]
        (case dest-base
          10 (if (list? number-dec) number-dec (digits-list number-dec))
          (dec-to-base number-dec dest-base))
        )
      )
    nil
    )
  )
