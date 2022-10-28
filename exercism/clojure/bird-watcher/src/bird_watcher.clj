(ns bird-watcher)

(def last-week 
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (last birds))))

(defn day-without-birds? [birds]
  (not (empty? (filter zero? birds))))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter #(>= % 5) birds)))

(defn odd-week? [birds]
  (not (some false? (map = birds [1 0 1 0 1 0 1]))))
