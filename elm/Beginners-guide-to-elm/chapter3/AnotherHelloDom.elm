module AnotherHello exposing (..)

import Html exposing (..)

checkStatus : Int -> String
checkStatus status = 
    if status == 200 then
        "Ta to bien"
    else if status == 404 then
        "No te conosco"
    else
        "Ten cuidaaaao"

statusChecks : List String
statusChecks = 
    [ checkStatus 200
    , checkStatus 404
    , checkStatus 418
    ]

renderList : List String -> Html msg
renderList lst = 
    ul []
    -- Función anónima para map empieza con \
    (List.map (\l -> li [] [text l]) lst)

-- Renderizar la lista usando pipes
anotherRenderList : List String -> Html msg
anotherRenderList lst = 
    lst
        |> List.map (\l -> li [] [text l])
        |> ul []

main = 
    div [] [
        h1 [] [
            text "List of statuses:"
        ],
        renderList statusChecks,
        anotherRenderList statusChecks
    ]