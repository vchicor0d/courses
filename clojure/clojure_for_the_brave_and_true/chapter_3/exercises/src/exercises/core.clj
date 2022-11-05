(ns exercises.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; 2 Write a function that takes a number and adds 100 to it
(defn add100 "adds 100 to a given number" [n] (+ 100 n))

;; 3 Write a function, dec-maker, that works exactly like the function inc-maker except with substraction
(defn dec-maker "Returns a function that decreases a number by n" [n] (fn [i] (- i n)))

;; 4 Write a function, mapset, that works like map excep the return value is a set
(defn mapset [f coll] (set (map f coll)))

;; 5 Create a function that's similar to symmetrize-body-parts except that it has to work with weird space aliens with radial symmetry. Instead of two eyes, arms, legs and so on they have five.
(def asym-alien-body-parts [{:name
 "head" :size 3}
{:name
 "1-eye" :size 1}
{:name
 "1-ear" :size 1}
{:name
 "mouth" :size 1}
{:name
 "nose" :size 1}
{:name
 "neck" :size 2}
{:name
 "1-shoulder" :size 3}
{:name
 "1-upper-arm" :size 3}
{:name
 "chest" :size 10}
{:name
 "back" :size 10}
{:name
 "1-forearm" :size 3}
{:name
 "abdomen" :size 6}
{:name
 "1-kidney" :size 1}
{:name
 "1-hand" :size 2}
{:name
 "1-knee" :size 2}
{:name
 "1-thigh" :size 4}
{:name
 "1-lower-leg" :size 3}
{:name
 "1-achilles" :size 1}
{:name
 "1-foot" :size 2}])


(defn matching-parts
  [part]
  (into [] (vector {:name (clojure.string/replace (:name part) #"^1-" "2-")
                    :size (:size part)}
                   {:name (clojure.string/replace (:name part) #"^1-" "3-")
                    :size (:size part)}
                   {:name (clojure.string/replace (:name part) #"^1-" "4-")
                    :size (:size part)}
                   {:name (clojure.string/replace (:name part) #"^1-" "5-")
                    :size (:size part)})))

(defn symmetrize-body-parts
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (into (matching-parts part) (vector part)))))
          []
          asym-body-parts))

;; 6 Create a function that generalizes symmetrize-body-parts and the function you created in Exercise 5. The new function should take a collection of body parts and the number of matching body parts to add. If you’re completely new to Lisp languages and functional programming, it probably won’t be obvious how to do this. If you get stuck, just move on to the next chapter and revisit the problem later.
(defn n-matching-parts
  [part n]
  ;; map aplica la función de reemplazo de 1- a una lista que va de 2 a n, la función reemplaza 1- por n-
  (into [] (map (fn [n] {:name (clojure.string/replace (:name part) #"^1-" (str n "-"))
                           :size (:size part)}) (range 2 (inc n)))))

(defn n-symmetrize-body-parts
  [asym-body-parts n]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (into (n-matching-parts part n) (vector part)))))
          []
          asym-body-parts))
