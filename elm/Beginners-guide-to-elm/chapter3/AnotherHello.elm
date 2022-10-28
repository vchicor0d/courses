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

main = 
    statusChecks
    |> String.join " "
    |> text