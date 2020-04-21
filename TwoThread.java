import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoThread
{
    private static JFrame mainFrame;
    private static JLabel infoLabel;
    private static JLabel progressLabel;
    private static JButton PlusHundredButton;
    private static JButton PlusFiveHundredButton;
	private static JButton MinusHundredButton;
	private static JButton MinusFiveHundredButton;
	
    private static Integer progress = 0;

    public static void main(String[] args)
    {
        mainFrame = new JFrame("Threaded Account");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(2, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoLabel = new JLabel("Account Balance:", JLabel.RIGHT);
        progressLabel = new JLabel("0", JLabel.LEFT);
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

        class MainWorker1 extends SwingWorker<Integer, Integer>
        {
           protected Integer doInBackground() throws Exception, InterruptedException
          {
             
             Thread.sleep(1000);
             progress = progress + 100;
             return progress;
          }

          protected void done()
          {
             try
             { progressLabel.setText(" " + get());
             } catch (Exception e){ }
          }
        }

       class MainWorker2 extends SwingWorker<Integer, Integer>
       {
          protected Integer doInBackground() throws Exception, InterruptedException
          {
             
             Thread.sleep(1000);
             progress = progress + 500;
             return progress;
          }

          protected void done()
          {
             try
             { progressLabel.setText(" " + get());
             } catch (Exception e){ }
          } 
        }
		   class MainWorker3 extends SwingWorker<Integer, Integer>
        {
           protected Integer doInBackground() throws Exception, InterruptedException
          {
             
             Thread.sleep(1000);
             progress = progress - 100;
             return progress;
          }

          protected void done()
          {
             try
             { progressLabel.setText(" " + get());
             } catch (Exception e){ }
          }
        }
		   class MainWorker4 extends SwingWorker<Integer, Integer>
        {
           protected Integer doInBackground() throws Exception, InterruptedException
          {
             
             Thread.sleep(1000);
             progress = progress - 500;
             return progress;
          }

       
          protected void done()
          {
             try
             { progressLabel.setText(" " + get());
             } catch (Exception e){ }
          }
        }

        PlusHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainWorker1().execute();
            }
        });
        
        PlusFiveHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainWorker2().execute();
            }
        });
		  MinusHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainWorker3().execute();
            }
        });
		  MinusFiveHundredButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainWorker4().execute();
            }
        });
		
        mainFrame.setVisible(true);
    }
}


