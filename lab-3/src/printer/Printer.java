package printer;

import paper.DrawingPaper;
import paper.OfficePaper;
import paper.Paper;

public class Printer {
	protected Paper paperInPrinter;
	public Printer()
	{
		this.paperInPrinter = null;
	}
	protected void PrintText()
	{
		String text = new String("I'm belive I can print");
		paperInPrinter.SetText(text);
	}
	
	protected void PrintImage()
	{
		String image = new String("This is image. Imagine it. Belive in it");
		paperInPrinter.SetText(image);
	}
	
	public boolean Print(String whatWePrint)
	{
		if(whatWePrint.compareTo("текст")==0)
		{
			paperInPrinter = new OfficePaper(); 
			this.PrintText();
		}
		else 
			if(whatWePrint.compareTo("изображение")==0)
			{
				paperInPrinter = new DrawingPaper();
				this.PrintImage();
			}
			else return false;		
		return true;
	}
	
	public void setPaper(Paper paper)
	{
		this.paperInPrinter = paper;
	}
	
	public Paper givePaper()
	{
		Paper paper = this.paperInPrinter;
		this.paperInPrinter = null;
		return paper;
	}
	
	public Paper getPaper()
	{
		return this.paperInPrinter;
	}
}
