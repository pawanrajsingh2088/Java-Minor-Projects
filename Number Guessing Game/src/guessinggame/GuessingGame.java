package guessinggame;

/**
 * Java game that allows user to guess a random number that has been generated.
 * @author Aditya Raj
 */

import javax.swing.*;

public class GuessingGame {
    //main method 
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1); //generate random num
        int userAnswer = 0; //initialize
        // log correct answer to console for verification
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1; //initialize
        // Display input dialog until the user guesses the correct number 
        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null, 
                "Enter a guess between 1 and 100", "Guessing Game", 3); // display initial input dialog to user
            userAnswer = Integer.parseInt(response); //convert string to int for use in check method below
            //pass userAnswer and the Compter gen number along with guess count to method
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count)); 
            count++; //increment number of tries for each attempt
        }  
    }
    
    //Determine guess function to check how close number is to generated number and display try count
    public static String determineGuess(int userAnswer, int computerNumber, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "Your guess is incorrect\nTry Number: " + count;
            
        }
    }
}
