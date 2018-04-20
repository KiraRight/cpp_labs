package hiswt;

/**
 * This is printer
 * @author Анастасия
 *
 */
public class Printer {
	private Paper paperInPrinter;
	
	public Printer()
	{
		this.paperInPrinter = null;
	}
	
	/**
	 * When we have text, we print it on OfficePaper
	 * @see OfficePaper()
	 */
	public void PrintText()
	{
		paperInPrinter = new OfficePaper();
		String text = "A plan for capturing cookies";
		paperInPrinter.SetText(text);
	}
	
	/**
	 * When we have image, we print it on PhotoPaper
	 * @see PhotoPaper()
	 */
	public void PrintImage()
	{
		paperInPrinter = new DrawingPaper();
		String image = "This is image. You're belive in it?";
		paperInPrinter.SetText(image);
	}
	
	/**
	 * Method set paper in printer
	 * @param paper that we set in printer
	 */
	void setPaper(Paper paper)
	{
		this.paperInPrinter = paper;
	}
	
	/**
	 * Method give paper from printer
	 * @return paper that we give
	 */
	Paper givePaper()
	{
		Paper paper = this.paperInPrinter;
		this.paperInPrinter = null;
		return paper;
	}
	
	/**
	 * Method get status of paper in printer
	 * @return
	 */
	Paper getPaper()
	{
		return this.paperInPrinter;
	}
}
