package com.marksuree;

import static com.marksuree.MyBuffer.isBufferFull;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;;

/**
 * 
 *
 *This class is main and responsible for GUI creation.
 */
public class Main {
	public static MyBuffer buffer;

	/**
	 * in main method we create new buffer object and then GUI
	 * @param args
	 */
	public static void main(String[] args) {
		buffer = new MyBuffer();
		createGUI();
	}
	
	/**
	 * This method create GUI: two buttons and one label.
	 */
	public static void createGUI()
	{
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setMinimumSize(270, 100);
		shell.setText("Creator and consumer");
		
		FillLayout fill = new FillLayout();
		fill.type = SWT.VERTICAL;
		shell.setLayout(fill);
		
		Button creator = new Button(shell, SWT.PUSH);
		creator.setText("make magic");
		
		Button consumer = new Button(shell, SWT.PUSH);
		consumer.setText("Consume info");
		consumer.setEnabled(false); 
		
		Label label = new Label(shell, SWT.NONE);
		
		Label resultChanger = new Label (shell, SWT.NONE);
		resultChanger.setText ("   Result will be here");
		
		/**
		 * This method is the logic of creator button. CreatorThread write new info inside the buffer, until the buffer become full.
		 * If buffer is full, we can't create more new info.
		 */
		creator.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				consumer.setEnabled(true);
				if(isBufferFull)
				{
					creator.setEnabled(false);
					resultChanger.setText("  The buffer is full, you can't "
							+ "create more info");
				}
				else
				{
					resultChanger.setText(" ");
					CreatorThread creatorThread = new CreatorThread();
					creatorThread.start();
					try
					{
						creatorThread.join();
					}
					catch(InterruptedException e)
					{
						System.out.println("Creator stopped");
					}
				}
				}
			});
		
		/**
		 * This method is the logic of consumer button. We read data and clean buffer after that.
		 */
		consumer.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				ConsumerThread consumerThread = new ConsumerThread();
				consumerThread.start();
				try
				{
					consumerThread.join();
				}
				catch(InterruptedException e)
				{
					System.out.println("Consumer stopped");
				}
				String str = String.valueOf(consumerThread.result);
				resultChanger.setText(str);
					buffer = new MyBuffer();
					consumer.setEnabled(false);
					creator.setEnabled(true);
				}
			});
		
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}


