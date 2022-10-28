public class Queen {

  private final int x;
  private final int y;

  public Queen(final int x, final int y) {
    this.x = posCheck(x, "row");
    this.y = posCheck(y, "column");
  }

  private int posCheck(final int pos, final String posName) {

    if (pos >= 0 && pos < 8) {
      return pos;
    } else {
      String message = "Queen position must have "
          + ((pos < 0) ? "positive " + posName + "." : posName + " <= 7.");
      throw new IllegalArgumentException(message);
    }

  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
