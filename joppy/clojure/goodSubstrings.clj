;; You're writing a new programming language and you'd like it to have the capability of splitting a string into substrings with limited characters. More specifically, we'll call a substring good if the absolute difference in ASCII codes between any two of its characters is less than or equal to k.

;; For example, if k = 3, then the string "bad" would be considered good, since the greatest difference in ASCII codes is 3 (between the a and d characters). The string "nice" would not be considered good, since there's a difference of 11 between the c and n characters.

;; You are given a string strToSplit that consists of lowercase English letters only, and your task is to find the minimal number of good substrings you can split it into.

;; Hint: Iterate over the string strToSplit and keep the ASCII codes of the smallest and the greatest characters in the current substring. Every time when the difference between them is becomes greater than k, it means that the last considered symbol should be the first one in a new substring.

;; Example

;;     For strToSplit = "aaabaaabb" and k = 0, the output should be goodSubstrings(strToSplit, k) = 4.

;;     strToSplit could be split into ["aaa", "b", "aaa", "bb"]. Each substring must consist of only one type of character, because it is required that |si - sj| ≤ 0 for each substring s.

;;     For strToSplit = "aaabaaabb" and k = 1, the output should be goodSubstrings(strToSplit, k) = 1.

;;     Since the only characters in the string have a difference of 1, aaabaaabb meets the requirement |strToSpliti - strToSplitj| ≤ 1. So only 1 substring is required (and it's the full original string).

;;     For strToSplit = "aaabzaaabb" and k = 10, the output should be goodSubstrings(strToSplit, k) = 3.

;;     strToSplit could be split into ["aaab", "z", "aaabb"]. Since the z character has such a large differene with each of its adjacent characters, it must be in a substring of its own.

(defn goodSubstrings [strToSplit k] 
  (loop [ascii-values (map int strToSplit)
         jumps 0]
    (if (empty? ascii-values)
      jumps
      (let [[current & others] ascii-values
            current-jump (Math/abs (- current (if (empty? others) 0 (first others))))]
        (println (str "Jumps " jumps " Current: " current " Others: " others " Current-jump: " current-jump))
        (recur others 
               (if (<= current-jump k) 
                 jumps 
                 (+ 1 jumps)))))))
