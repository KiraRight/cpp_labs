package hiswt;

/**
 * This class represents paper 
 */
public class Paper {
	private int lenght;
	private int height;
	private String text;
	public Paper()
	{
		this.lenght = 100;
		this.height = 100;
		text = null;
	}
	
	/**
	 * Method for setting text on paper
	 * @param text - this is text for setting
	 */
	public void SetText(String text)
	{
		this.text = text;
	}
	
	/**
	 * Method for reading text
	 * @return text that we read on this paper
	 */
	String GetText()
	{
		return text;
	}
}
