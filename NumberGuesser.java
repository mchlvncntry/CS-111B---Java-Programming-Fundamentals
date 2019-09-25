import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {

		//Continues to play a new match until player decides to end the program
		do {
			playOneGame();
		} while (shouldPlayAgain());
	}

	// Repeats rounds of number guessing until the computer guesses the correct number
	public static void playOneGame(){ 
		System.out.println("Guess a number between 1 and 100...");

		int minNum = 1, //Sets initial minimum guessable value
			maxNum = 100; //Sets initial maximum guessable value

		char userResponse = 'c'; //Initializes user response to 'c' for while loop to start
		int guess = 50;

		while (userResponse != 'c') {
			guess = getMidpoint(); //Retreieves a midpoint based on the current min and max values
			userResponse = getUserResponse(); //Sets high, low or correct based on user input for each round

			if (userResponse == 'h') {
				minNum = guess + 1;} //Sets a new min value if user user says number is higher
			else if (userResponse == 'l') {
				maxNum = guess - 1;} //Sets a new max value if user user says number is lower
		}			
	}

	//Asks player if they want to play again and returns their answer to continue/end the program
	public static boolean shouldPlayAgain(){
		System.out.println("Do you want to play again? (y/n): ");
		Scanner input = new Scanner(System.in); //Creates scanner object
		char playAgain = input.next().charAt(0); //Stores if player wants to play again
		
		if (playAgain == 'y') {
			return true;} //Creates TRUE boolean to continue the original while loop
		else {
			return false;} //Creates FALSE boolean to break the original while loop
	}

	//Creates a new midpoint for the computer to use as a guess. This is repeated each round
	public static int getMidpoint(int minNum, int maxNum){
		int newGuess = (minNum + maxNum) / 2; //Sets a new guess based on new min amd max values
		return newGuess; //Sends new guess back to playOneGame to be used as guess in while loop
	}

	//Retrieves a user response of high, low or correct to continue/end each round of guessing
	public static char getUserResponse(int guess){
		Scanner input = new Scanner(System.in); //Creates scanner object
		System.out.println(guess + "? Is it higher, lower or correct? (h/l/c): ");
		return input.next().charAt(0); //Retrieves high, low or correct for each round
	}
}