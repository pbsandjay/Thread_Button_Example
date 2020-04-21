// 68 74 74 70 73 3a 2f 2f 77 77 77 2e 79 6f 75 74 75 62 65 2e 63 6f 6d 2f 77 61 74 63 68 3f 76 3d 6c 57 44 37 6a 34 31 6b 5f 79 34

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoButton
{
    private static JFrame mainFrame;
    private static JLabel infoLabel;
    private static JLabel progressLabel;

    private static JButton PlusHundredButton;
    private static JButton PlusFiveHundredButton;
	private static JButton MinusHundredButton;
    private static JButton MinusFiveHundredButton;
	 
	
    private static int progress = 0;

    public static void main(String[] args)
    {
        mainFrame = new JFrame("Non Threaded Account");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(2, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoLabel = new JLabel("Progress: ", JLabel.RIGHT);
        progressLabel = new JLabel("500", JLabel.LEFT);
        PlusHundredButton = new JButton("+100");
        PlusFiveHundredButton = new JButton("+500");
		
        MinusHundredButton = new JButton("-100");
		MinusFiveHundredButton = new JButton("-500");
		
        mainFrame.add(infoLabel);
        mainFrame.add(progressLabel);
        mainFrame.add(PlusHundredButton);
        mainFrame.add(PlusFiveHundredButton);
        mainFrame.add(MinusHundredButton);
        mainFrame.add(MinusFiveHundredButton);
		

      PlusHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int temp = progress;
                pause();
                progress = temp + 100;
                progressLabel.setText(" " + progress);
            }
        });
        
       PlusFiveHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int temp = progress;
                pause();
                progress = temp + 500;
                progressLabel.setText(" " + progress);
            }
        });
		  
 		

	   MinusHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int temp = progress;
                pause();
                progress = temp - 100;
                progressLabel.setText(" " + progress);
            }
        });
        
       MinusFiveHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int temp = progress;
                pause();
                progress = temp - 500;
                progressLabel.setText(" " + progress);
            }
        });
		  
 		

        
        mainFrame.setVisible(true);
    }
    
    public static void pause(){
        try{Thread.sleep(500);
        } catch (InterruptedException e) { }
    }
}
