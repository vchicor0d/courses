;; Given a string s, can you compose exactly k non-empty palindromes using all letters of s?

;; Note that you can use only letters from s. Each letter from s that you use has to appear the exactly the same number of times in your palindromes as it does in s. Also note that you can rearrange string letters as you want.

;; Example

;;     For s = "abracadabra" and k = 3, the output should be composeKPalindromes(s, k) = true.

;;     The answer is true since you are able to compose 3 palindromes using each letter of "abracadabra" once. 3 possible palindromes that fulfill this requirement for example can be: "raaaaar", "bcb", and "d".

;;     For s = "abracadabra" and k = 2, the output should be composeKPalindromes(s, k) = false.

(defn composeKPalindromes [s k] 
  (if (> k (.length s))
    false
    (>= k (count (filter #(odd? (val %)) (frequencies s))))))
