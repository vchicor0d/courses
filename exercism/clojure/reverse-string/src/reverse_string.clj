(ns reverse-string)

;; Using loop and recur
;; (defn reverse-string [s]
;;   (loop [original s
;;          reversed '()]
;;     (if (empty? original)
;;       (apply str reversed)
;;       (recur (drop 1 original) (cons (first original) reversed)))))

;;Using into
(defn reverse-string [s]
  (apply str (into () s)))
