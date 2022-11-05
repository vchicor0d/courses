(ns interest-is-interesting)

(defn interest-rate
  [balance]
  (cond
    (neg? balance) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn annual-balance-update
  [balance]
  (bigdec (+ (* (/ (interest-rate balance) 100) (abs balance)) balance)))

(defn amount-to-donate
  [balance tax-free-percentage]
  (if (neg? balance)
    0
    (int (* (/ tax-free-percentage 100) balance 2))))