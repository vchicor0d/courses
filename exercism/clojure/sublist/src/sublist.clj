(ns sublist)

(defn equal-lists [list1 list2]
  (= list1 list2))

(defn sublist? [list1 list2]
  (if (empty? list1)
    true
    (if (= (first list1) (first list2))
      (recur (drop 1 list1) (drop 1 list2))
      false)))

(defn sublist [list1 list2]
  (if (<= (count list1) (count list2))
    (if (= (first list1) (first list2))
      (if (sublist? (drop 1 list1) (drop 1 list2))
        true
        (recur list1 (drop 1 list2)))
      (recur list1 (drop 1 list2)))
    false))

(defn classify [list1 list2] ;; <- arglist goes here
      (cond
        (equal-lists list1 list2) :equal
        (empty? list1) :sublist
        (empty? list2) :superlist
        (sublist list1 list2) :sublist
        (sublist list2 list1) :superlist
        :else :unequal))
