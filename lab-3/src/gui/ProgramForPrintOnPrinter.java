package gui;

/**
 *@version 1.0
 *@since 1.0 
 */
import human.Human;
import paper.DrawingPaper;
import paper.OfficePaper;
import paper.Paper;
import printer.Xerox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * Main class, where we create GUI
 * @author Анастасия
 *
 */
public class ProgramForPrintOnPrinter 
{
	public static Shell ConfigureShell(Display display, Human human, Xerox xerox)
	{
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setText("Let's print!");
		shell.setSize(300, 100);
		shell.setLayout(new GridLayout(3,false));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gridData.horizontalSpan = 3;
		Label Label = new Label(shell, SWT.LEFT);
		Label.setText("Принтер");
		Label.setLayoutData(gridData);
		
		Button putPaperButton = new Button(shell, SWT.PUSH);
		putPaperButton.setText("Заправить");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		
		Label putLabel = new Label(shell, SWT.LEFT);
		putLabel.setText("Принтер не заправлен");
		putLabel.setLayoutData(gridData);
		
		Button printButton = new Button(shell, SWT.PUSH);
		printButton.setText("Печатать");
		
		Combo kindOfPrint = new Combo(shell, SWT.NULL);
		kindOfPrint.setItems(new String [] {"текст","изображение"});
		
		Button putPrintButton = new Button(shell, SWT.PUSH);
		putPrintButton.setText("Забрать");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		
		gridData.horizontalSpan = 3;
		Label Label2 = new Label(shell, SWT.LEFT);
		Label2.setText("Ксерокс");
		Label2.setLayoutData(gridData);
		
		Button putPaperScunButton = new Button(shell, SWT.PUSH);
		putPaperScunButton.setText("Заправить");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		
		Label putScunLabel = new Label(shell, SWT.LEFT);
		putScunLabel.setText("Ксерокс не заправлен");
		putScunLabel.setLayoutData(gridData);
		
		Button ScunButton = new Button(shell, SWT.PUSH);
		ScunButton.setText("Отсканировать");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		
		Label scunLabel = new Label(shell, SWT.LEFT);
		scunLabel.setText("Текст:");
		scunLabel.setLayoutData(gridData);
		
		Button PrintScunButton = new Button(shell, SWT.PUSH);
		PrintScunButton.setText("Распечатать");
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		Label controlLabel = new Label(shell, SWT.LEFT);
		controlLabel.setText("Контроль");
		controlLabel.setLayoutData(gridData);
		
		putPaperButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(human.CheckPaperInPrinter() == false)
				{
					human.PutPaper();	
					putLabel.setText("Принтер заправлен");
					putLabel.getParent().layout();
				}
				}
			});
		putPaperScunButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(xerox.getPaper()==null)
				{	
					xerox.setPaper(new DrawingPaper());
					putScunLabel.setText("Ксерокс заправлен");
					putScunLabel.getParent().layout();
				}
				}
			});
		printButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				String text = new String(kindOfPrint.getText());
				if(human.CheckPaperInPrinter() == true)
				{
					if(text.compareTo("")!=0)
					{
						if(human.Print(text))
						{
							controlLabel.setText("Заберите " + text);
							controlLabel.getParent().layout();
						}
						else
						{
							controlLabel.setText("Нет такой возможности");
							controlLabel.getParent().layout();
						}
					}
					else
					{
						controlLabel.setText("Выберите способ печати");
						controlLabel.getParent().layout();
					}
				}
				else
				{
					controlLabel.setText("Заправьте принтер");
					controlLabel.getParent().layout();
				}				
				}
			});
		putPrintButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(human.CheckPaperInPrinter() == true)
				{
					human.PickUpPaper();
					putLabel.setText("Принтер не заправлен");
					putLabel.getParent().layout();	
					String text = human.readText();
					if(text!=null)
						controlLabel.setText("Текст: " + text);
					else
						controlLabel.setText("Текста нет");
					controlLabel.getParent().layout();
				}
				}
			});
		ScunButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				Paper forScun = new OfficePaper();
				forScun.SetText("Fox in the box");
				xerox.ScanPaper(forScun);
				scunLabel.setText("Текст: "+xerox.GetScanBuffer());
				scunLabel.getParent().layout();
				}
			});
		PrintScunButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if(xerox.getPaper() != null)
				{
					xerox.Print();
					controlLabel.setText("Текст: "+ xerox.givePaper().GetText());
					controlLabel.getParent().layout();
					putScunLabel.setText("Ксерокс не заправлен");
					putScunLabel.getParent().layout();
				}		
				else
				{
					controlLabel.setText("Заправьте ксерокс");
					controlLabel.getParent().layout();
				}
				}
			});
		return shell;
		}

	public static void main(String[] args) 
	{
		Display display = new Display();
		Human human = new Human();
		Xerox xerox = new Xerox();
		Shell shell = ConfigureShell(display, human, xerox);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) 
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
