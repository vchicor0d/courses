(ns triangle)

(defn- check-length [side]
  (> side 0))

(defn- check-triangle-inequality [side1 side2 side3]
  (not (and
        (<= side1 (+ side2 side3))
        (<= side2 (+ side1 side3))
        (<= side3 (+ side1 side2)))))

(defn is-valid? [side1 side2 side3]
  (not
   (or (some false? (map check-length [side1 side2 side3]))
       (check-triangle-inequality side1 side2 side3))))

(defn equilateral? [side1 side2 side3]
  (and
   (is-valid? side1 side2 side3)
   (= side1 side2 side3)))

(defn isosceles? [side1 side2 side3]
  (and
   (is-valid? side1 side2 side3)
   (or
    (= side1 side2)
    (= side1 side3)
    (= side2 side3))))

(defn scalene? [side1 side2 side3]
  (and
   (is-valid? side1 side2 side3)
   (not (isosceles? side1 side2 side3))))
