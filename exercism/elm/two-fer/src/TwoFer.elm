module TwoFer exposing (twoFer)


twoFer : Maybe String -> String
twoFer name =
    case name of
        Just nameString ->
            "One for " ++ nameString ++ ", one for me."

        Nothing ->
            "One for you, one for me."
