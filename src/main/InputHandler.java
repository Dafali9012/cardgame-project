package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    public InputHandler(){

    }
    public String getText(){
        return null;
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
        userInput.close();
        return userChoice;
    }

    public int getInt(String prompt){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            System.out.println(prompt);
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch || userChoice < 0);
        userInput.close();
        return userChoice;
    }

    public int getInt(String prompt, int maxValue){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            System.out.println(prompt + ", max value: " + maxValue);
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch || userChoice > maxValue || userChoice < 0);
        userInput.close();
        return userChoice;
    }
    public int getInt(String prompt, int minValue, int maxValue){
        Scanner userInput = new Scanner(System.in);
        boolean wentToCatch;
        int userChoice = 0;
        do {
            System.out.println(prompt + ", min value: " + minValue +", max value: " + maxValue);
            try {
                wentToCatch = false;
                userChoice = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again: ");
                userInput.next();
                wentToCatch = true;
            }
        } while (wentToCatch || userChoice > maxValue || userChoice < minValue);
        userInput.close();
        return userChoice;
    }
}
