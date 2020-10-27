import Browser
import Html exposing (Html, Attribute, div, input, text)
import Html.Attributes exposing (..)
import Html.Events exposing (onInput)

-- MAIN
main =
    Browser.sandbox { init = init, update = update, view = view }

-- MODEL
type alias Model = --Defino alias de tipo Model
    { content : String } -- El tipo es un mapa (record) con una clave content de tipo String

init : Model -- Defino init de tipo Model
init =
    {content = ""} -- El mapa es el definido en el tipo anterior

-- UPDATE
type Msg
    = Change String

update : Msg -> Model -> Model
update msg model =
    case msg of
        Change newContent ->
            { model | content = newContent }

-- VIEW
view : Model -> Html Msg
view model =
    div []
        [ input [ placeholder "Text to reverse", value model.content, onInput Change ][]
        , div [] [ text ("Longitud: " ++ (String.fromInt (String.length model.content))) ]
        , div [] [ text (String.reverse model.content) ]
        ]
