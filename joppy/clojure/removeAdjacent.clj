;; Given a string, remove adjacent duplicate characters.

;; Example

;;     For s = "aaaaa", the output should be removeAdjacent(s) = "a";
;;     For s = "abccaaab", the output should be removeAdjacent(s) = "abcab".

(defn removeAdjacent [s] 
  (loop [remaining-s s
         result []]
    (if (empty? remaining-s)
      (reduce str result)
      (let [[current & remaining] remaining-s]
        (recur remaining
               (if (not= current (last result))
                 (conj result current)
                 result))))))
