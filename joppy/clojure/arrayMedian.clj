;; Given a sequence of integers, find its median.

;; Example

;;     For sequence = [-1, 3, -2, 2], the output should be arrayMedian(sequence) = 0.5;
;;     For sequence = [1, 3, 2], the output should be arrayMedian(sequence) = 2.

(defn arrayMedian [sequence] 
  (double (/ (reduce + sequence) (count sequence))))
