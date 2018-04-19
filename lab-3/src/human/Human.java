package human;

import paper.OfficePaper;
import paper.Paper;
import printer.Printer;

public class Human {
	private Paper paperInHumanArms;
	private Printer printerForHuman;
	public Human()
	{
		this.printerForHuman = new Printer();
		this.paperInHumanArms = new OfficePaper();
	}
	
	public void PickUpPaper()
	{
		this.paperInHumanArms = printerForHuman.givePaper();
	}
	
	public void PutPaper()
	{
		printerForHuman.setPaper(paperInHumanArms);
	}
	
	public boolean Print(String forPrint)
	{
		if(printerForHuman.Print(forPrint))
			return true;
		else
			return false;
	}
	
	public boolean CheckPaperInPrinter()
	{
		
		if(printerForHuman.getPaper() != null)
			return true;
		else
			return false;
	}
	
	public String readText()
	{
		return paperInHumanArms.GetText();
	}
}
