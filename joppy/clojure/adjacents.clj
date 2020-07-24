;; Remove repeated adjacents of an input string ("AAAbbCaBb" -> "AbCaBb")
(defn removeAdjacent [s] 
  (loop [remaining-s s
         result []]
    ;; Condition to exit loop, if no remaining characters in string
    (if (empty? remaining-s)
      ;; if empty convert seq of chars in string
      (reduce str result)
      ;; Split first character from the rest
      (let [[current & remaining] remaining-s]
        (recur remaining
               ;; if current character is not the same as last in vector we add it, else return the vector as is
               (if (not= current (last result))
                 (conj result current)
                 result))))))

