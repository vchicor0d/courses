;; In order to stop the Mad Coder evil genius you need to decipher the encrypted message he sent to his minions. The message contains several numbers that, when typed into a supercomputer, will launch a missile into the sky blocking out the sun, and making all the people on Earth grumpy and sad.

;; You figured out that some numbers have a modified single digit in their binary representation. More specifically, in the given number n the kth bit from the right was initially set to 0, but its current value might be different. It's now up to you to write a function that will change the kth bit of n back to 0.

;; Example

;;     For n = 37 and k = 3, the output should be killKthBit(n, k) = 33.

;;     3710 = 1001012 ~> 1000012 = 3310.

;;     For n = 37 and k = 4, the output should be
;;     killKthBit(n, k) = 37.

;;     The 4th bit is 0 already (looks like the Mad Coder forgot to encrypt this number), so the answer is still 37.

(defn dec-to-bin-seq [n]
  (loop [dec-n n
         bin-seq []]
    (if (<= dec-n 1)
      (reverse (conj bin-seq dec-n))
      (recur (int (/ dec-n 2)) (conj bin-seq (mod dec-n 2))))))

(defn pow [x n]
  (reduce * (repeat n x)))

(defn bin-seq-to-dec [bin]
  (loop [bin-seq bin
         n 0]
    (if (empty? bin-seq)
      n
      (recur (drop 1 bin-seq) (+ n (* (first bin-seq) (pow 2 (dec (count bin-seq)))))))))

(defn killKthBit [n k] 
  (let [rev-bin-seq (reverse (dec-to-bin-seq n))]
    (bin-seq-to-dec (reverse (flatten (conj [] (take (dec k) rev-bin-seq) 0 (drop k rev-bin-seq)))))))
