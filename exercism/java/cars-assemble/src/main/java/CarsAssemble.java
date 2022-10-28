public class CarsAssemble {

  private final int CARS_PER_HOUR = 221;

  public double productionRatePerHour(int speed) {
    double successRate;

    if (speed == 10) {
      successRate = 0.77;
    } else if (speed == 9) {
      successRate = 0.8;
    } else if (speed >= 5) {
      successRate = 0.9;
    } else if (speed >= 1) {
      successRate = 1.0;
    } else {
      successRate = 0;
    }

    return CARS_PER_HOUR * speed * successRate;
  }

  public int workingItemsPerMinute(int speed) {
    return (int) productionRatePerHour(speed) / 60;
  }
}
