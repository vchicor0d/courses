module UserImput exposing (..)

import Browser
import Html exposing (..)
import Html.Attributes exposing (..)
import Html.Events exposing (..)

main =
    Browser.sandbox { init = myModel, view = myView, update = myUpdate }

type alias Model =
    { text : String }

myModel : Model
myModel =
    Model ""

type Msg
    = Text String

myUpdate : Msg -> Model -> Model
myUpdate msg mdl = 
    case msg of 
        Text txt ->
            { mdl | text = txt }

styleText : List (Attribute msg)
styleText = 
    [ style "fontSize" "20em"
    , style "color" "sandyBrown"
    ]

myView : Model -> Html Msg
myView mdl = 
    div [] 
    [ input [ placeholder "Type text here", onInput Text] []
    , div styleText [ text mdl.text ]
    ]