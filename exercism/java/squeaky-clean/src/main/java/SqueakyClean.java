import java.util.function.UnaryOperator;

class SqueakyClean {
  static String clean(String identifier) {

    UnaryOperator<String> replaceSpaces = SqueakyClean::replaceSpaces;

    return replaceSpaces
        .andThen(SqueakyClean::replaceControlCharacters)
        .andThen(SqueakyClean::kebabToCamelConverter)
        .andThen(SqueakyClean::dropNotLetters)
        .andThen(SqueakyClean::dropGreekLowerCaseLetters)
        .apply(identifier);

  }

  private static String replaceSpaces(final String identifier) {
    return identifier.replace(" ", "_");
  }

  private static String replaceControlCharacters(final String identifier) {
    return identifier.codePoints().boxed().map(codepoint -> {

      if (Character.isISOControl(codepoint)) {
        return "CTRL";
      } else {
        return Character.toString(codepoint);
      }

    }).reduce("", String::concat);

  }

  private static String kebabToCamelConverter(final String identifier) {

    if (identifier.length() < 3) {
      return identifier;
    }

    StringBuilder builder = new StringBuilder();
    int[] codepoints = identifier.codePoints().toArray();

    builder.append(Character.toChars(codepoints[0]));

    for (int i = 1; i < codepoints.length - 1; i++) {

      if ("-".codePointAt(0) == codepoints[i]) {
        builder.append(new String(Character.toChars(codepoints[i + 1])).toUpperCase());
        i++;
      } else {
        builder.append(Character.toChars(codepoints[i]));
      }

    }

    builder.append(Character.toChars(codepoints[codepoints.length - 1]));
    return builder.toString();
  }

  private static String dropNotLetters(final String identifier) {
    return identifier.codePoints()
        .filter(codepoint -> Character.isLetter(codepoint) || codepoint == "_".codePointAt(0))
        .boxed()
        .map(Character::toString)
        .reduce("", String::concat);
  }

  private static String dropGreekLowerCaseLetters(final String identifier) {
    return identifier
        .codePoints()
        .filter(codepoint -> codepoint < "α".codePointAt(0) || codepoint > "ω".codePointAt(0))
        .boxed()
        .map(Character::toString)
        .reduce("", String::concat);
  }
}
