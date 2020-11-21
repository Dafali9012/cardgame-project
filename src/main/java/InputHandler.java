import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class InputHandler {

    public static String getText(String prompt, List<String> validAnswers){
        Scanner userInput = new Scanner(System.in);
        String userString;
        do {
            System.out.println(prompt);
            userString = userInput.nextLine().toLowerCase();
        }
        while (!validAnswers.contains(userString));
        return userString;
    }

    public static int getInt(String prompt, int maxValue){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            System.out.println(prompt + ", max value: " + maxValue);
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
                userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch || userChoice > maxValue || userChoice < 0);
        return userChoice;
    }
    public static int getInt(String prompt, int minValue, int maxValue){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            System.out.println(prompt + ", min value: " + minValue +", max value: " + maxValue);
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
                userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch || userChoice > maxValue || userChoice < minValue);
        return userChoice;
    }
}
