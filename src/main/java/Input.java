import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {
    public static int number(String prompt, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int result = -1;
        System.out.print(prompt);
        while(result == -1) {
            try {
                result = scan.nextInt();
            } catch (InputMismatchException ignored) {}
            if(result > max || result < min) result = -1;
            if(result == -1) System.out.print("Invalid input\n"+prompt);
            scan.nextLine();
        }
        return result;
    }

    public static String text(String prompt, String[] validInput) {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.print(prompt);
        while(true) {
            input = scan.nextLine();
            for(String c : validInput) {
                if(input.toLowerCase().equals(c.toLowerCase())) {
                    return input.toLowerCase();
                }
            }
            System.out.print("Invalid input\n"+prompt);
        }
    }
}
