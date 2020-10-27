import Browser
import Html exposing (..)
import Html.Attributes exposing (..)
import Html.Events exposing (onInput)
import String exposing (length, any)
import Char exposing (isDigit, isLower, isUpper)

--MAIN

main =
    Browser.sandbox { init = init, update = update, view = view}

-- MODEL
type alias Model =
    { name : String
    , password : String
    , passwordAgain : String
    }

init : Model
init =
    Model "" "" ""

-- UPDATE
type Msg
    = Name String
    | Password String
    | PasswordAgain String

update : Msg -> Model -> Model
update msg model =
    case msg of
        Name name ->
            { model | name = name }

        Password password ->
            { model | password = password }

        PasswordAgain password ->
            { model | passwordAgain = password }

-- VIEW
view : Model -> Html Msg
view model =
    div []
        [ viewInput "text" "Name" model.name Name
        , viewInput "password" "Password" model.password Password
        , viewInput "password" "Re-enter Password" model.passwordAgain PasswordAgain
        , viewValidation model
        ]

viewInput : String -> String -> String -> (String -> msg) -> Html msg
viewInput t p v toMsg =
    input [ type_ t, placeholder p, value v, onInput toMsg ] []

viewValidation : Model -> Html msg
viewValidation model =
    if (length model.password) == 0 && (length model.passwordAgain) == 0 then
        div [] []
    else if model.password /= model.passwordAgain then
        div [ style "color" "red" ] [text "Las contraseñas no coinciden"]
    else if (length model.password) < 8 then
        div [ style "color" "red" ] [ text "La contraseña no es de 8 caracteres o más" ]
    else if not (any isDigit model.password && any isUpper model.password && any isLower model.password) then
        div [ style "color" "red" ] [ text "La contraseña necesita al menos un número, una letra mayúscula y una minúscula"]
    else
        div [ style "color" "green" ] [text "OK"]
