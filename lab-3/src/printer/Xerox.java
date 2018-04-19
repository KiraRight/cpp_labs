package printer;

import paper.Paper;

public class Xerox extends Printer{
	
	private String ScunBuffer;
	
	public Xerox()
	{
		super();
		this.ScunBuffer = null;
	}
	public void ScanPaper(Paper paper)
	{
		ScunBuffer = paper.GetText();
	}
	
	public String GetScanBuffer()
	{
		return ScunBuffer;
	}
	
	public void Print()
	{
			paperInPrinter.SetText(ScunBuffer);
	}
}
