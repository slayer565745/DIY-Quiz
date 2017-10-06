import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quizzer
{
	static ArrayList <FlashCard> questions = new ArrayList <FlashCard>();
	static int numberOfQuestions;
	static int questionsRight;
	public static double possibleScore;
	public static int scoreCounter;
	public static void main(String[] args)
	{
				CardGenerator.createQuiz();
	}
	
	public static void quiz()
	{
		Scanner in = new Scanner(System.in);
		try
			{
		System.out.println("How many of those questions do you want to be tested on?");
		numberOfQuestions = in.nextInt();
		possibleScore = 0;
		System.out.println("Here we goooooooo!");
		System.out.println();
		questionsRight = 0;
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			int randomNumber = (int) (Math.random()*questions.size());
			try
				{
			Scanner ans = new Scanner(System.in);
			System.out.println("_____________________________________________________________________________");
			System.out.println("Q: " + questions.get(randomNumber).getQuestion());
			System.out.println("Difficulty: " + questions.get(randomNumber).getDifficulty() + "/10");
			System.out.print("A: ");
			String answer = ans.nextLine();
			answer = answer.toLowerCase();
			if (answer.equals(questions.get(randomNumber).getAnswer().toLowerCase()))
			{
				questionsRight = questionsRight + 1*questions.get(randomNumber).getDifficulty();
				scoreCounter++;
			}
			possibleScore = possibleScore + 1*questions.get(randomNumber).getDifficulty();
			questions.remove(randomNumber);
			System.out.println("_____________________________________________________________________________");
			System.out.println();
				}
			catch(InputMismatchException |  IndexOutOfBoundsException e)
				{
					System.out.println("You tried to cheat!!!!");
					System.out.println("You recieve a 0 on this quiz. Try again later");
					System.exit(0);
				}	
			}
			}
		catch(InputMismatchException |  IndexOutOfBoundsException e)
			{
				System.out.println("Something seems to have gone wrong.");
				System.out.println("Your score will not be graded.");
				System.exit(0);
			}
		score();
	}
	
	public static void score()
	{
		System.out.println("_____________________________________________________________________________");
		double percentage = (double)((questionsRight/possibleScore)*100);
		
		System.out.println("You got " + scoreCounter + " right out of " + numberOfQuestions + ": " + percentage + "%");
		System.out.println("This score may not seem right, but it is. It simply accounts for difficulty.");
	}
}
//Changes Below

//I created a difficulty counter
//I bug fixed any attempt to cheat / ask too many questions. (No Trolling)
//I used the difficulty counter to change your total score.



