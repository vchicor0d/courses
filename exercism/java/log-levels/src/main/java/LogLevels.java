public class LogLevels {

  public static String message(String logLine) {
    return extractMessage(logLine);
  }

  public static String logLevel(String logLine) {
    return extractLevel(logLine);
  }

  public static String reformat(String logLine) {
    return extractMessage(logLine) + " (" + extractLevel(logLine) + ")";
  }

  private static String extractMessage(final String logline) {
    return logline.substring(logline.indexOf(" ")).trim();
  }

  private static String extractLevel(final String logline) {
    return logline.substring(1, logline.indexOf("]"))
        .toLowerCase();
  }
}
