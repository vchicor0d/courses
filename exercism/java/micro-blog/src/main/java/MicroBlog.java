class MicroBlog {
  public String truncate(String input) {
    return input.codePoints() // Get a IntStream of unicode codepoints (Integer)
        .boxed() // Convert to IntStream to Stream<Integer>
        .limit(5)
        .map(Character::toChars) // Creates char array with codepoint
        .map(String::new)
        .reduce("", String::concat);
  }
}
