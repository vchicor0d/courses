class QueenAttackCalculator {

  private final Queen whiteQueen;
  private final Queen blackQueen;

  public QueenAttackCalculator(final Queen whiteQueen, final Queen blackQueen) {
    checkQueensPosition(whiteQueen, blackQueen);
    this.whiteQueen = whiteQueen;
    this.blackQueen = blackQueen;
  }

  public boolean canQueensAttackOneAnother() {
    return checkVerticals() || checkDiagonal1() || checkDiagonal2();
  }

  private void checkQueensPosition(final Queen whiteQueen, final Queen blackQueen) {

    if (whiteQueen == null || blackQueen == null) {
      throw new IllegalArgumentException("You must supply valid positions for both Queens.");
    }

    if (whiteQueen.getX() == blackQueen.getX() && whiteQueen.getY() == blackQueen.getY()) {
      throw new IllegalArgumentException("Queens cannot occupy the same position.");
    }

  }

  private boolean checkVerticals() {
    return whiteQueen.getX() == blackQueen.getX() || whiteQueen.getY() == blackQueen.getY();
  }

  private boolean checkDiagonal1() {
    int x = whiteQueen.getX();
    int y = whiteQueen.getY();

    while (x >= 0 && y >= 0) {

      if (x == blackQueen.getX() && y == blackQueen.getY()) {
        return true;
      }

      x--;
      y--;
    }

    while (x < 8 && y < 8) {

      if (x == blackQueen.getX() && y == blackQueen.getY()) {
        return true;
      }

      x++;
      y++;
    }

    return false;
  }

  private boolean checkDiagonal2() {
    int x = whiteQueen.getX();
    int y = whiteQueen.getY();

    while (x < 8 && y >= 0) {

      if (x == blackQueen.getX() && y == blackQueen.getY()) {
        return true;
      }

      x++;
      y--;
    }

    while (x >= 0 && y < 8) {

      if (x == blackQueen.getX() && y == blackQueen.getY()) {
        return true;
      }

      x--;
      y++;
    }

    return false;
  }

}
