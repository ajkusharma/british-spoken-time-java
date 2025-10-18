import java.util.Map;
import java.util.TreeMap;

public class BritishSpokenTime {
    private static final String MIDNIGHT = "midnight";
    private static final String NOON = "noon";

    private static final Map<Integer, String> SMALL = createSmallMap();
    private static final Map<Integer, String> TENS = createTensMap();

    private static Map<Integer, String> createSmallMap() {
        Map<Integer, String> m = new TreeMap<>();
        m.put(0, "zero");
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");
        m.put(5, "five");
        m.put(6, "six");
        m.put(7, "seven");
        m.put(8, "eight");
        m.put(9, "nine");
        m.put(10, "ten");
        m.put(11, "eleven");
        m.put(12, "twelve");
        m.put(13, "thirteen");
        m.put(14, "fourteen");
        m.put(15, "fifteen");
        m.put(16, "sixteen");
        m.put(17, "seventeen");
        m.put(18, "eighteen");
        m.put(19, "nineteen");
        return m;
    }

    private static Map<Integer, String> createTensMap() {
        Map<Integer, String> m = new TreeMap<>();
        m.put(20, "twenty");
        m.put(30, "thirty");
        m.put(40, "forty");
        m.put(50, "fifty");
        return m;
    }

    // Convert number 0..59 to words like "thirty two", "oh five" handled by callers for small numbers
    public static String numberToWords(int n) {
        if (n < 0 || n > 59) throw new IllegalArgumentException("number out of range: " + n);
        if (n < 20) return SMALL.get(n);
        // n is between 20 and 59 here
        int tens = (n / 10) * 10;
        int ones = n % 10;
        String tensWord = TENS.getOrDefault(tens, SMALL.get(tens));
        if (ones == 0) return tensWord;
        return tensWord + " " + SMALL.get(ones);
    }

    // Convert hour 0..23 to 12-hour word (1..12)
    public static String hourToWord(int hour24) {
        int h12 = hour24 % 12;
        if (h12 == 0) h12 = 12;
        return numberToWords(h12);
    }

    public static String toSpoken(String time) {
        if (time == null) throw new IllegalArgumentException("time string is null");
        String[] parts = time.trim().split(":");
        if (parts.length != 2) throw new IllegalArgumentException("time must be in HH:MM format");
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(parts[0]);
            minute = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("time must contain numeric HH and MM");
        }
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59)
            throw new IllegalArgumentException("time out of range");

        // Special cases
        if (hour == 0 && minute == 0) return MIDNIGHT;
        if (hour == 12 && minute == 0) return NOON;

        // Exact hour
        if (minute == 0) {
            return hourToWord(hour) + " o'clock";
        }

        // divisible by 5 -> use past/to/quarter/half rules
        if (minute % 5 == 0) {
            if (minute == 15) return "quarter past " + hourToWord(hour);
            if (minute == 30) return "half past " + hourToWord(hour);
            if (minute == 45) return "quarter to " + hourToWord((hour + 1) % 24);
            if (minute < 30) return numberToWords(minute) + " past " + hourToWord(hour);
            // minute > 30
            int toMin = 60 - minute;
            return numberToWords(toMin) + " to " + hourToWord((hour + 1) % 24);
        }

        // not divisible by 5 -> use numeric spoken form like "six thirty two" or "six oh two"
        String hourWord = hourToWord(hour);
        String minuteWords;
        if (minute < 10) {
            // say "oh five" for 06:05 -> "six oh five"
            minuteWords = "oh " + numberToWords(minute);
        } else {
            minuteWords = numberToWords(minute);
        }
        return hourWord + " " + minuteWords;
    }


    // Simple CLI: accept a time string as argument or read from stdin when no args provided
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java BritishSpokenTime HH:MM");
            System.out.println("Examples: 00:00 -> midnight, 12:00 -> noon, 7:35 -> twenty five to eight");
            return;
        }
        String input = args[0];
        System.out.println(toSpoken(input));
    }
}
