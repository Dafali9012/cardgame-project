package main;

import java.util.Scanner;

public class InputHandler {
    public InputHandler(){

    }
    public int getInt(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }
}
