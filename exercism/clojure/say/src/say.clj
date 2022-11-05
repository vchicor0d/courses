(ns say)

(defn- units [num]
  (case num
    \0 ""
    \1 "one"
    \2 "two"
    \3 "three"
    \4 "four"
    \5 "five"
    \6 "six"
    \7 "seven"
    \8 "eight"
    \9 "nine"))

(defn- tenths [num]
  (let [tenth (first num)
        unit (last num)]
    (case tenth
      \0 (units unit)
      \1 (case num
           "10" "ten"
           "11" "eleven"
           "12" "twelve"
           "13" "thirteen"
           "15" "fifteen"
           "18" "eighteen"
           (str (units unit) "teen"))
      (str
       (case tenth
         \2 "twenty"
         \3 "thirty"
         \4 "forty"
         \5 "fifty"
         \8 "eighty"
         (str (units tenth) "ty"))
       (when (not= \0 unit) (str "-" (units unit)))))))

(defn- cypher-format [num cyphers]
  (str (apply str (take (- cyphers (count num)) (repeat "0"))) num))

(defn- hundreths [num]
  (let [hundreth (first num)
        tenth (cypher-format (apply str (drop 1 num)) 2)]
    (case hundreth
      \0 (tenths tenth)
      (str (units hundreth) " hundred" (when (and
                                              (seq tenth)
                                              (not= "00" tenth))
                                         (str " " (tenths tenth)))))))

(defn- split-hundreths [num max-cyphers]
  (apply str (take (- (count num) max-cyphers) num)))

(defn- not-only-zeros? [num-string]
  (some #(not= \0 %) num-string))

(defn- thousands [num]
  (when (not-only-zeros? num)
    (clojure.string/trim
     (str
      (hundreths (cypher-format (split-hundreths num 3) 3)) " thousand "
      (hundreths (apply str (take-last 3 num)))))))

(defn- millions [num]
  (when (not-only-zeros? num)
    (clojure.string/trim
     (str
      (hundreths (cypher-format (split-hundreths num 6) 3)) " million "
      (thousands (apply str (take-last 6 num)))))))

(defn- billions [num]
  (clojure.string/trim
   (str
    (hundreths (cypher-format (split-hundreths num 9) 3)) " billion "
    (millions (apply str (take-last 9 num))))))

(defn number [num]
  (let [num (str (if (neg? num) 9999999999999 num))
        cyphers (count num)]
    (cond
      (= "0" num) "zero"
      (= cyphers 1) (units (first num))
      (= cyphers 2) (tenths num)
      (= cyphers 3) (hundreths num)
      (<= cyphers 6) (thousands num)
      (<= cyphers 9) (millions num)
      (<= cyphers 12) (billions num)
      :else (throw (IllegalArgumentException. "Out of range")))))
