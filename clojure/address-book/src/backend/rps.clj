(ns app.rps)

;; (defn move-details [name beats]
;;   {:name name :beats beats})
  

;; (def moves {:rock (move-details "Rock" :scissors)
;;             :paper (move-details "Paper" :rock)
;;             :scissors (move-details "Scissors" :paper)}
;;   )

(def moves [:rock :paper :scissors])
(def beat-map {:rock :scissors, :paper :rock, :scissors :paper})

;; (defn get-weaker-move [move]
;;   (:beats (move moves)))

(defn game "Plays a game of Rock-paper-scissors" [p1-move p2-move]
  (cond
    (= (p1-move beat-map) p2-move) (println "P1 wins!")
    (= (p2-move beat-map) p1-move) (println "P2 wins!")
    :else (println "Draw!")))

(defn play []
  (game (rand-nth moves) (rand-nth moves)))
