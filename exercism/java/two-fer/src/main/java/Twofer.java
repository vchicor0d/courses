public class Twofer {
  public String twofer(String name) {
    name = (name != null) ? name : "you";
    return "One for " + name + ", one for me.";
  }
}
