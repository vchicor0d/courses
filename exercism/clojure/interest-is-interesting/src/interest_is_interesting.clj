(ns interest-is-interesting)

(defn interest-rate
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn annual-balance-update
  [balance]
  (bigdec (+ balance (* balance (interest-rate balance)))))

(defn amount-to-donate
  [balance tax-free-percentage]
  (bigint (* balance (if (> balance 0) (* 2 tax-free-percentage) tax-free-percentage))))