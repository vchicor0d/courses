(ns chapter-3.core
  (:gen-class))

(defn -main

  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; if sólo admite una sentencia para true y otra para false
(defn truestatement
  []
  (if true
    "By Zeus's hammer!"
    "By Aquaman's trident"))

;; Si if es falso y no hay sentencia false devuelve nil
(defn falsestatement
  []
  (if false
    "By Odin's Elbow!"))

;; Para poner más de una sentencia usamos la función do
(defn ifdo
  []
  (if true
    (do (println "Success!")
        "By Zeus's hammer!")
    (do (println "Failure!")
        "By Aquaman's trident!")))

;; La función when se evalúa solo si es verdadero y permite varias sentencias
(defn whenstatement
  []
  (when true
    (println "Success!")
     "abra cadabra"))

;; nil es la ausencia de valor, nil y false evaluan a falso, todo lo demás a verdadero
(defn truthness
  []
  (println (nil? 1))
  (println (nil? nil))
  (if "hola"
    (println "saludos!"))
  (if nil
    (println "Esto no se verá")
    "Esto si, porque nil es falso"))

;; or devuelve el primer valor verdadero
(or 1 2)

;; and devuelve el último valor verdadero
(and 1 2)

;; Se pueden definir funciones anónimas (multiplica un número por 3)
((fn [number] (* 3 number)) 2)

;; La misma función en aplicada a un vector con map
(map (fn [number] (* 3 number)) [2 3])

;; La misma función definida como un "reader macro" # para marcar la función y % para posicionar el argumento
(#(* % 3) 2)

;; Con varios argumentos
(#(str %2 ", " %1) "mundo", "hola")

;;Una función con un número de argumentos variable
(defn varargs [& argumentos]
  (clojure.string/join ", " argumentos))

(varargs "hola" "mundo")

;; anónima con numero de argumentos variable
(#(clojure.string/join ", " %&) "hola" "mundo")

