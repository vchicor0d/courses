(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first & rest] deck]
    first))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[first second & rest] deck]
    second))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[first second & rest] deck]
    (->> rest
         (cons first)
         (cons second))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[first & rest] deck]
    [first rest]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[first & rest] deck]
    (filter #(not (nil? %)) (concat (list first) face-cards rest))))
