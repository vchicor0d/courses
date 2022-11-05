(ns hobbits.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

;; El parámetro part es un mapa, devolvemos otro mapa cuyo :name es el resultado de reemplazar left por right
;; y el :size el mismo que traía
(defn matching-part
  [part]
  ;; clojure.string/replace usa una expresión regular para saber qué reemplazar, esta se marca como una cadena precedida por el símbolo #
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Espera una seq de mapas que tienen :name y :size"
  [asym-body-parts]
  ;; Loop marca un punto de inicio de recursividad
  ;; En loop se definen remaining-asym-parts con el contenido de asym-body parts y final-body-parts como un vector vacío
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      ;; let separa una parte del resto
      (let [[part & remaining] remaining-asym-parts]
        ;; ejecuta la llamada recursiva al loop con las partes restantes y el vector con las partes ya emparejadas
        (recur remaining
               ;; Mete en final-body parts un set consistente en la parte y la matching-part de la parte
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(defn better-symmetrize-body-parts
  "Espera un seq con un :name y un :size"
  [asym-body-parts]
  ;; reduce aplica la función a los dos primeros argumentos o al resultado y al siguiente argumento
  ;; la función devuelve un vector con el set de la parte y su correspondiente
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))
