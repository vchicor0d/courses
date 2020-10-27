(ns beer-song
  (:require [clojure.string :as str]))

(defn give-bottles [num]
  (if (> num 1)
    (str num " bottles")
    (if (= num 1)
      (str num " bottle")
      (str "no more bottles"))
  ))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (def bottles (give-bottles num))
  (def one-less (give-bottles (dec num)))  
  (if (> num 1)
    (def taken "one")
    (def taken "it")
    )
  (def first-phrase (str (str/capitalize bottles) " of beer in the wall, " bottles " of beer."))
  (def second-phrase
    (if (= num 0)
      (str "Go to the store and buy some more, " (give-bottles 99) " of beer in the wall")
      (str "Take " taken " down and pass it around, " one-less " of beer on the wall.")))
  (str first-phrase "\n" second-phrase "\n"))


(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (def song "")
   (doseq [ver-num (reverse (range 0 (inc start)))]
     (def song (str song (verse ver-num) "\n")))
   song)
  ([start end]
   (def song "")
   (doseq [ver-num (reverse (range end (inc start)))]
     (def song (str song (verse ver-num) "\n")))
   song)
  )
