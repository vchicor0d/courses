(ns raindrops)

(defn- check-factor [number factor]
  (zero? (mod number factor)))

(defn- factor-check-list [number]
  {:3 (check-factor number 3)
   :5 (check-factor number 5)
   :7 (check-factor number 7)})

(defn- raindrop-sound [factor]
  (case factor
    :3 "Pling"
    :5 "Plang"
    :7 "Plong"))

(defn convert [number]
  (let [factors (factor-check-list number)]
    (if (some true? (vals factors))
      (reduce str (map raindrop-sound (keys (filter #(true? (val %)) factors))))
      (str number))))
