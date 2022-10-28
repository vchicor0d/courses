module WordGuess exposing (..)

import Random.List
import Browser
import Html exposing (..)
import Html.Attributes exposing (..)
import Html.Events exposing (onClick, onInput)

main =
    Browser.sandbox { init = model, view = view, update = update }

type alias WordHint =
    { word : String, length : Int }

type alias Model =
    { word : String 
    , guess : String
    , isCorrect : Bool
    , hint : WordHint
    }

words : List String
words =
    ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]

getWord : Random.Generator String
getWord = 
    Random.List.choose words

model : Model
model = 
    Model (Random.generate String getWord) "" False (WordHint "S" 1)

type Msg 
    = Answer String
    | Hint

update : Msg -> Model -> Model
update msg mdl =
    case msg of
        Answer guess ->
            { mdl | guess = guess, isCorrect = checkWord mdl guess }
        Hint ->
            { mdl | hint = getHint mdl }

getHint : Model -> WordHint
getHint {word, hint, isCorrect } =
    if not isCorrect then
        { hint | word = String.left (hint.length + 1) word, 
                length = 
                    if hint.length <= String.length word then
                        hint.length + 1 
                    else 
                        hint.length
                    }
    else
        hint

checkWord : Model -> String -> Bool
checkWord mdl guess =
    String.toLower mdl.word == String.toLower guess

generateResult : Model -> Html Msg
generateResult { isCorrect, hint, word, guess } =
    let 
        value = 
            if word == hint.word then
                ([style "color" "red"],[ text "No lo has adivinado" ])
            else if isCorrect then
                ([style "color" "green"],[ text "Lo has conseguido!" ])
            else if String.length guess == 0 then
                ([],[text ""])
            else
                ([],[text "Nope"])
    in
        div (Tuple.first value) (Tuple.second value)

mainStyle : List (Attribute msg)
mainStyle = 
    [ style "fontFamily" "monospace"
    , style "textAlign" "center"
    , style "fontSize" "2em"
    ]

view : Model -> Html Msg
view mdl =
    div mainStyle
    [ h2 [] [ text ("Busco una palabra de "
                    ++ String.fromInt (String.length mdl.word)
                    ++ " letras que empieza por \"" 
                    ++ mdl.hint.word 
                    ++ "\"")] 
    , input [ placeholder "Escribe tu palabra", onInput Answer ] []
    , button [ onClick Hint ] [ text "Pista" ] 
    , generateResult mdl
    ]