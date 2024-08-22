package org.carlos;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private String difficultyString;
    private final String[] difficulties;
    private int chances;
    private final int number_guess;
    private int attempts;
    private boolean game_state;

    public NumberGuessingGame () {
        difficulties = new String[3];
        difficulties[0] = "Easy";
        difficulties[1] = "Medium";
        difficulties[2] = "Hard";
        game_state = false;
                number_guess = (int) (Math.random()*100) + 1;
    }

    public boolean isGame_state() {
        return game_state;
    }

    public void setGame_state(boolean game_state) {
        this.game_state = game_state;
    }

    public void setDifficultyString(int difficulty) {
        this.difficultyString = difficulties[difficulty-1];
    }

    public String getDifficultyString() {
        return difficultyString;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to the Number Guessing Game!");
    }

    public static void rulesMessage() {
        System.out.println("You have to guess a number between 1 and 100.");
        System.out.println("You have 5 attempts to guess the number.");
    }

    public void printDifficulties() {
        for (int i = 0; i <  difficulties.length; i++) {
            System.out.println(i+1+". "+difficulties[i] + " ("+10/(i+1) + " chances)");
        }
    }

    public void difficultyMessage() {
        int max_chances = 10;
        System.out.println("\nPlease select the difficulty level: ");
        Scanner sc = new Scanner(System.in);
        printDifficulties();
        int option = Integer.parseInt(sc.nextLine());
        setDifficultyString(option);
        setChances(max_chances/option);
        System.out.println("Great! You have selected the " + getDifficultyString()+ " difficulty level.");
        System.out.println("You have "+ getChances()+ " chances.");
        System.out.println("Let's start the game!");
    }

    public void initGame() {
        while (chances > 0) {
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choise = sc.nextInt();
            if(verifyAnswer(choise)){
                break;
            }
        }
    }

    public boolean verifyAnswer(int choice) {
        attempts++;
        if(choice == number_guess) {
            System.out.println("Congratulations! You guessed the correct number in "+attempts+ " attempts.");
            return true;
        }else {
            chances--;
            if( choice > number_guess){
                System.out.println("Incorrect! The number is less than "+ choice);
            }else {
                System.out.println("Incorrect! The number is more than "+ choice);
            }
            if( chances == 0) {
                System.out.println("Sorry! No more attempts. You lose the game, try again.");
            }

            return false;
        }
    }

    public static void main(String[] args) {

        NumberGuessingGame game = new NumberGuessingGame();
        System.out.println();
        welcomeMessage();
        rulesMessage();
        game.difficultyMessage();
        game.initGame();


    }

}