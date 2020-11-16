package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    public InputHandler(){

    }
    public int getInt(){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch);
        return userChoice;
    }
}