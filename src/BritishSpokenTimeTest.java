public class BritishSpokenTimeTest {
    private static int failures = 0;

    public static void assertEqual(String input, String expected) {
        try {
            String actual = BritishSpokenTime.toSpoken(input);
            if (!actual.equals(expected)) {
                failures++;
                System.out.printf("FAIL: %s -> expected: '%s', got: '%s'\n", input, expected, actual);
            } else {
                System.out.printf("PASS: %s -> '%s'\n", input, actual);
            }
        } catch (Exception e) {
            failures++;
            System.out.printf("ERROR: %s -> threw %s\n", input, e);
        }
    }

    public static void main(String[] args) {
        // Provided examples
        assertEqual("01:00", "one o'clock");
        assertEqual("02:05", "five past two");
        assertEqual("03:10", "ten past three");
        assertEqual("04:15", "quarter past four");
        assertEqual("05:20", "twenty past five");
        assertEqual("06:25", "twenty five past six");
        assertEqual("06:32", "six thirty two");
        assertEqual("07:30", "half past seven");
        assertEqual("07:35", "twenty five to eight");
        assertEqual("08:40", "twenty to nine");
        assertEqual("09:45", "quarter to ten");
        assertEqual("10:50", "ten to eleven");
        assertEqual("11:55", "five to twelve");
        assertEqual("00:00", "midnight");
        assertEqual("12:00", "noon");

        // Extra edge cases
        assertEqual("00:05", "five past twelve");
        assertEqual("12:05", "five past twelve");
        assertEqual("23:59", "eleven fifty nine");
        assertEqual("00:01", "twelve oh one");
        assertEqual("13:01", "one oh one");
        assertEqual("11:11", "eleven eleven");

        if (failures == 0) {
            System.out.println("\nAll tests passed.");
            System.exit(0);
        } else {
            System.out.println("\nFailures: " + failures);
            System.exit(1);
        }
    }
}
