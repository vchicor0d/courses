-- Nombre de nuestro módulo y las funciones que exponemos, podemos usar (..) para exponerlas todas
module HelloDom exposing (..)

-- Módulos que importamos y las clases que exponemos, podemos usar (..) para exponerlas todas
import Html exposing (Html, text, div, h1, p)
import Html.Attributes exposing (class)

-- Si a una función no se le pone el tipo el compilador lo infiere, podemo ver las inferencias que ha hecho usando elm make --warn <archivo>
main : Html msg
main = 
    -- Los nodos del DOM toman 2 listas como argumentos, la primera siendo los atributos y la segunda los nodos que contenga
    div [class "myDiv"] [
        h1 [class "header"] [text "Welcom to my Elm site"],
        p [] [text "Me mola Elm!"],
        p [] [text "Deseando darle duro"]
    ]