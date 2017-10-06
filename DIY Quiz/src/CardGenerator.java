import java.util.InputMismatchException;
import java.util.Scanner;

public class CardGenerator
{
	public static void createQuiz()
	{
		Scanner in = new Scanner(System.in);
		try
			{
		System.out.println("How many total flashcards do you want?");
		int allQuestions = in.nextInt();
		if(allQuestions>100 || allQuestions<1)
			{
				System.out.println("Yeah, we're not gonna do that.");
				createQuiz();
			}
		System.out.println();
		for (int i = 0; i < allQuestions; i++)
		{
			Scanner QandA = new Scanner(System.in);
			System.out.println("What question do you want for question number " + (i + 1) + "?");
			String question = QandA.nextLine();
			System.out.println("Great! and what would be the answer to that question?");
			String answer = QandA.nextLine();
			System.out.println("On a scale from 1 to 10 how difficult is this question?");
			Scanner input = new Scanner(System.in);
			int difficulty = input.nextInt();
			Quizzer.questions.add(new FlashCard(question, answer, difficulty));
			System.out.println();
		}
		Quizzer.quiz();
			}
		catch(InputMismatchException |  IndexOutOfBoundsException e)
			{
				System.out.println("Something went wrong, please try to enter your questions again.");
				createQuiz();
			}
	}
}