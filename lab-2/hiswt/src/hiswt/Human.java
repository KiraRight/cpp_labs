package hiswt;

/**
 * Human have printer and paper. He can control printing
 * @author Анастасия
 *
 */
public class Human {
	private Paper paperInHumanArms;
	private Printer printerForHuman;
	
	public Human()
	{
		this.printerForHuman = new Printer();
		this.paperInHumanArms = new Paper();
	}
	
	/**
	 * Method for pick up paper from printer
	 */
	public void PickUpPaper()
	{
		this.paperInHumanArms = printerForHuman.givePaper();
	}
	
	/**
	 * Method for put paper in printer
	 */
	public void PutPaper()
	{
		paperInHumanArms = new Paper();
		printerForHuman.setPaper(paperInHumanArms);
	}
	
	/**
	 * We "click" on print-button on printer and start to print
	 * @param whatWePrint - doc that we print
	 * @return true, when we start printing, false, when we have some problems
	 */
	public boolean Print(String whatWePrint)
	{
		if(whatWePrint.compareTo("текст")==0)
			printerForHuman.PrintText();
		else 
			if(whatWePrint.compareTo("изображение")==0)
				printerForHuman.PrintImage();
			else return false;
				
		return true;
	}
	
	/**
	 * Method check paper in printer
	 * @return true, when we find paper in printer
	 */
	public boolean CheckPaperInPrinter()
	{
		if(printerForHuman.getPaper() != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Method for read document
	 * @return String of text
	 */
	String readText()
	{
		return paperInHumanArms.GetText();
	}
}
