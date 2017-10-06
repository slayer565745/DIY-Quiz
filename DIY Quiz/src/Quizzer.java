import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quizzer
{
	static ArrayList <FlashCard> questions = new ArrayList <FlashCard>();
	static int numberOfQuestions;
	public static int questionsRight=0;
	public static double possibleScore;
	public static int scoreCounter;
	public static void main(String[] args)
	{
				CardGenerator.createQuiz();
	}
	
	public static void quiz()
	{
		Scanner in = new Scanner(System.in);
		Scanner reply = new Scanner(System.in);
		int categoryCounter = 0;
		try
			{
		System.out.println("What category would you like to answer.");
		String categoryType =reply.nextLine();
		System.out.println("How many of those questions do you want to be tested on?");
		numberOfQuestions = in.nextInt();
		for(int c=0; c<questions.size(); c++)
			{
				if(questions.get(c).getCategory().equals(categoryType))
					{
						categoryCounter++;
					}
			}
		if(categoryCounter == 0)
			{
				System.out.println("Nothing matched your category.");
				quiz();
			}
		if(numberOfQuestions > questions.size()||categoryCounter<numberOfQuestions)
			{
				System.out.println("Sorry there aren't that many questions (or there aren't that many in this category).");
				quiz();
			}
		possibleScore = 0;
		System.out.println("Here we goooooooo!");
		System.out.println();
		int runCounter = 0;
		boolean questionsRunner=true;
		while(questionsRunner)
			{
		for (int i = 0; i < questions.size(); i++)
		{
			int randomNumber = (int) (Math.random()*questions.size());
			if(questions.get(randomNumber).getCategory().equals(categoryType))
				{
			categoryCounter++;
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
			runCounter++;
			if(runCounter>=numberOfQuestions)
				{
					questionsRunner=false;
				}
				}
			catch(InputMismatchException |  IndexOutOfBoundsException e)
				{
					System.out.println("You tried to cheat!!!!");
					System.out.println("You recieve a 0 on this quiz. Try again later");
					System.exit(0);
				}	
				}
				}
			}
			}
		catch(InputMismatchException |  IndexOutOfBoundsException e)
			{
				System.out.println("Something seems to have gone wrong.");
				System.out.println("Your score will not be graded.");
				System.exit(0);
			}
		System.out.println("Would you like to be tested on any other categories?");
		Scanner runReply = new Scanner(System.in);
		String run = runReply.nextLine();
		if(run.equals("yes"))
			{
				quiz();
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

//I created a difficulty counter.
//I bug fixed any attempt to cheat / ask too many questions. (No Trolling)
//I used the difficulty counter to change your total score.
//I added the category function.
//I made it re-run to select multiple categories.
//I made it so you can't run more questions than you have.

