module Pangram exposing (isPangram)

import String exposing (toLower, contains)
import List exposing (filter, length)

letters = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]

isPangram : String -> Bool
isPangram sentence =
    let
        lowerSentence = toLower sentence
        unusedLetters = filter (\string -> not (contains string lowerSentence)) letters
    in
        if length unusedLetters == 0 then
            True
        else
            False
