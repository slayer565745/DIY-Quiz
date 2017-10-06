
public class FlashCard
{
	String question;
	String answer;
	int difficulty;
	public FlashCard(String ques, String ans, int d)
	{
		question = ques;
		answer = ans;
		difficulty = d;
	}

	public int getDifficulty()
		{
			return difficulty;
		}

	public void setDifficulty(int difficulty)
		{
			this.difficulty = difficulty;
		}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
}