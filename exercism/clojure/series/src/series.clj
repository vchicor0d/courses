(ns series)

(defn slices [string length] ;; <- arglist goes here
  (if (not (zero? length))
    (loop [string string
           length length
           slice-list []]
      (if (>= (count string) length)
        (recur
         (drop 1 string)
         length
         (conj slice-list (take length string)))
        (map #(apply str %) slice-list))
      )
    '(""))
)
