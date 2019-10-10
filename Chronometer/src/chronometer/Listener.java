package chronometer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class Listener implements ActionListener
{
	
	public static int hours, minutes, seconds;
	private Timer chronometer;
	
	public Listener()
	{
		createTimer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() instanceof Timer)
		{
			// time logic
			seconds++;		
			if(seconds == 60)
			{
				minutes++;
				seconds = 0;
			}
			if (minutes == 60)
			{
				hours++;
				minutes = 0;
			}
			
			// update label
			Display.getLabel();
		}
		
		else if(e.getSource() instanceof JButton)
		{
			JButton button = (JButton)e.getSource();
			if(button.getText().equals("Run"))
			{
				chronometer.start();
				Display.restart.setEnabled(false);
				button.setText("Stop");
			}
			
			else if(button.getText().equals("Stop"))
			{
				chronometer.stop();
				Display.restart.setEnabled(true);
				button.setText("Run");
			}
			
			else if(button.getText().equals("Restart"))
			{
				hours = 0;
				minutes = 0;
				seconds = 0;
				Display.getLabel();
			}
		}	
	}
	
	public void createTimer()
	{
		chronometer = new Timer(1000, this);
	}
}
