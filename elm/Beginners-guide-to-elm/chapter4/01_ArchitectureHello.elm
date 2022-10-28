module ArchitectureHello exposing (..)

import Browser
import Html exposing (..)
import Html.Attributes exposing (style)
import Html.Events exposing (onClick)

main =
    Browser.sandbox { init = model, view = view, update = update}

-- Así es como se verá nuestro modelo
type alias Model =
    { text : String
    , size : Int
    }

-- El modelo se encarga de mantener el estado
model : Model
model = 
    { text = "Hola, Mundo" 
    , size = 1
    }

-- Tipos de mensaes que podemos enviar
type Msg 
    = AddExcl
    | RemExcl
    | SizeUp
    | SizeDown

changeSize : Int -> Int -> Int
changeSize size change = 
    if (size + change) < 1 then
        1
    else
        size + change

removeExcl : String -> String
removeExcl txt = 
    if (String.right 1 txt) == "!" then
        String.dropRight 1 txt
    else
        txt

-- Update se encarga de actualizar el modelo
update : Msg -> Model -> Model
update msg mdl = 
    case msg of
        AddExcl -> 
            { mdl | text = mdl.text ++ "!"}
        RemExcl ->
            { mdl | text = (removeExcl mdl.text)}
        SizeUp ->
            { mdl | size = (changeSize mdl.size 1) }
        SizeDown ->
            { mdl | size = (changeSize mdl.size -1) }

myStyle : Int -> List (Attribute msg)
myStyle size = 
    [ style "fontSize" ((String.fromInt size) ++ "em")
    , style "color" "teal"
    ]

-- La vista se encarga de marcar como se verá nuestra app
view : Model -> Html Msg
view mdl = 
    div [] 
        [ div (myStyle mdl.size) [ text mdl.text ]
        -- Los botones mandan un mensaje del tipo especificado en el onClick que hará que el evento correspondiente del update se ejecute
        , button [ onClick AddExcl ] [ text "Add Exclamation mark" ] 
        , button [ onClick RemExcl ] [ text "Remove Exclamation mark" ] 
        , button [ onClick SizeUp ] [ text "+" ]
        , button [ onClick SizeDown ] [ text "-" ]
        ]