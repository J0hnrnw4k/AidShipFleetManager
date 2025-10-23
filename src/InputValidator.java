import java.util.Scanner;

public class InputValidator {
    private static final Scanner sc = new Scanner(System.in);

    public static String readString() {
        while (true) {
            String s = sc.nextLine();
            if (s != null) {
                s = s.trim();
                if (!s.isEmpty()) return s;
            }
            System.out.println("Input cannot be empty. Try again:");
        }
    }

    public static char readChar(String errorPrompt) {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.length() == 1) return s.charAt(0);
            System.out.print(errorPrompt);
        }
    }

    public static double readDoubleNumber(String errorPrompt) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print(errorPrompt);
            }
        }
    }

    public static int readIntNumber(String errorPrompt) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print(errorPrompt);
            }
        }
    }

    public static boolean readBooleanValue() {
        while (true) {
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("t") || s.equals("yes") || s.equals("y")) return true;
            if (s.equals("false") || s.equals("f") || s.equals("no") || s.equals("n")) return false;
            System.out.print("Enter yes/y or no/n (or true/false): ");
        }
    }
}

