package paper;

public abstract class Paper {
	protected int lenght;
	protected int height;
	protected String text;
	public Paper()
	{
		this.lenght = 100;
		this.height = 100;
		text = null;
	}
	
	public void SetText(String text)
	{
		this.text = text;
	}
	
	public String GetText()
	{
		return text;
	}
}
