(ns chapter-4.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


;; Map con varias listas, aplica una función con varios argumentos a los elementos de la lista 1 a 1,
;; si una de las listas es más corta solo se aplican hasta la longitud de esta
(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

;; Map puede ser usada para obtener todas las claves de un vector de mapas
(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)

;; take y drop son dos funciones que toman un número y una secuencia como argumentos
;; devuelven los n primeros elementos de la lista o la lista sin los n primeros elementos respectivamente
(take 3 (range 1 11))
(drop 3 (range 1 11))

;; take-while y drop-while hacen lo mismo pero en lugar de un número se les pasa una función predicado,
;; devolverán o eliminarán los elementos que la cumplan hasta que haya uno que no, respectivamente
(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 3) food-journal)

(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

;; filter toma un predicado y una secuencia y devuelve solo los elementos que pasan el filtro, la diferencia
;; con take-while es que filter evalúa todos los elementos y no sólo hasta que no se cumpla el predicado
(filter #(< (:human %) 5) food-journal)

;; some devuelve el valor de la función del primer caso verdadero del predicado en una secuencia:

;; la funcion devuelve true o false
(some #(> (:critter %) 3) food-journal)

;; la función devuelve el valor o false
(some #(and (> (:critter %) 3) %) food-journal)

;; sort ordena los elementos en orden ascendente
(sort '(3 1 2))

;; sort-by ordena los elementos en orden ascendente según el resultado se ser aplicados a una función
(sort-by count '("aa" "BBB" "c"))

;; concat añade los miembros de una secuencia al final de otra
(concat '(1 2) [3 4])

;; Secuencias Lazy (no se evalúan hasta que no se necesitan)
(def vampire-database
  {0 {:makes-blood-puns? false :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true  :has-pulse? true :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

;; hasta que first no materializa la secuencia, map no hace la llamada a la función vampire-related-details
(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))


;; Secuencias infinitas

;; repeat sin argumentos crea una secuencia lazy infinita de los un elemento, se materializan solo los elementos a tomar (8)
(concat (take 8 (repeat "na")) ["Batman!"])

;; repeatedly retorna una secuencia lazy que se materializa con take
(take 3 (repeatedly (fn [] (rand-int 10))))

;; into pone los elementos de una colección en otra
(into #{} '(1 1 2 2 2 3 3 3))
(into ["patatas"] ["uvas" "manzanas"])

;; conj mete elementos en una colección
(conj [0] [1])
(conj [0] 1)

;; Funciones con funciones como parámetro

;; apply aplica una funcion a una colección
(max 0 1 2) ;; 2
(max [0 1 2]) ;; [0 1 2]
(apply max [0 1 2]) ;; 2

;; partial devuelve una función a la que se le pueden pasar los argumentos que le falten más tarde
((partial +) 2 3)
(def saluda (partial str "Hola, "))
(saluda "Mundo")

;; complement devuelve el complemento de una función
(def not-vampire? (complement vampire?))
