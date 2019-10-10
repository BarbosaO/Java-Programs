package chronometer;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class Display 
{
	// instance variables
	
	String title;
	
	private JFrame frame;
	private JPanel panel;
	protected static JButton runStop, restart;
	public static JLabel label;
	
	// Listener Object
	Listener ls;
	
	// Constructor 
	public Display(String aTitle)
	{
		title =  aTitle;
		ls =  new Listener();
		createFrame();
		createPanel();
	}
	
	// create Frame
	public void createFrame()
	{
		try 
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			{
			    if ("Nimbus".equals(info.getName())) 
			    {
			        UIManager.setLookAndFeel(info.getClassName());
			         break;
			    }
			}
			    
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		frame = new JFrame(title);
		frame.setSize(900,130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// create Panel
	public void createPanel()
	{
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,10,10,10);
		
		// buttons
		createButtons();
		c.gridx = 0;
		c.gridy = 0;
		panel.add(runStop,c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(restart, c);
		
		// label
		label = new JLabel();
		getLabel();
		label.setFont(new Font("Sans Seriff", Font.BOLD, 90));
		c.gridx = 2;
		c.gridy = 0;
		panel.add(label, c);
		
		frame.add(panel);
					
	}
	
	public void createButtons()
	{
		// instantiate buttons
		runStop = new JButton("Run");
		runStop.addActionListener(ls);
		
		restart = new JButton("Restart");
		restart.addActionListener(ls);
		restart.setEnabled(false);
		
		// modify them
		runStop.setFont(new Font("Sans Seriff", Font.BOLD, 45));
		restart.setFont(new Font("Sans Seriff", Font.BOLD, 45));
		
	}
	
	public static JLabel getLabel()
	{
		
		if(Listener.hours <= 9)
		{
			label.setText("0" + Listener.hours + " : " + Listener.minutes + " : " + 
					Listener.seconds);
			if(Listener.minutes <= 9)
			{
				label.setText("0" + Listener.hours + " : 0" + Listener.minutes + " : " + 
						Listener.seconds);
				if(Listener.seconds <= 9)
				{
					label.setText("0" + Listener.hours + " : 0" + Listener.minutes + " : 0" + 
							Listener.seconds);
				}
			}
			else
			{
				label.setText("0" + Listener.hours + " : " + Listener.minutes + " : " + 
						Listener.seconds);
				if(Listener.seconds > 9)
				{
					label.setText("0" + Listener.hours + " : " + Listener.minutes + " : " + 
							Listener.seconds);
				}
			}		
			
		}
		else 
			label.setText(Listener.hours + " : " + Listener.minutes + " : " + 
					Listener.seconds);
		
		return label;
	}
}