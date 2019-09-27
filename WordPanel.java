import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WordPanel extends JPanel implements Runnable {
		public static volatile boolean done;
		private WordRecord[] words;
		private int noWords;
		private int maxY;


		
		public void paintComponent(Graphics g) {
			Toolkit.getDefaultToolkit().sync();
		    int width = getWidth();
		    int height = getHeight();
		    g.clearRect(0,0,width,height);
		    g.setColor(Color.red);
		    g.fillRect(0,maxY-10,width,height);

		    g.setColor(Color.black);
		    g.setFont(new Font("Helvetica", Font.PLAIN, 26));

		    //draw the words
		    //animation must be added
			for (int i = 0; i < noWords; i++) {
				//g.drawString(words[i].getWord(),words[i].getX(),words[i].getY());
				g.drawString(words[i].getWord(), words[i].getX(), words[i].getY() + 20);  //y-offset for skeleton so that you can see the words
			}

		}
		
		WordPanel(WordRecord[] words, int maxY) {
			this.words=words; //will this work?
			noWords = words.length;
			done=false;
			this.maxY=maxY;		
		}
		public void stop()
		{
			done=true;
			this.getGraphics().clearRect(0,0,getWidth(),getHeight());


		}


	Thread t1=new Thread() {
		public void run() {
			w.run();
		}
	};
				  t1.start();
		public void run() {
			int counter =0;
			while(!done)
			{
				Thread t1=new Thread() {
				if(counter>450)

					{
						break;
					}
				for(
					int j = 0;
					j<words.length;j++)

					{
						words[j].setY(words[j].getY() + 1);
					}

					paintComponent(this.getGraphics());

				try

					{
						TimeUnit.MILLISECONDS.sleep(50);
					} catch(
					InterruptedException e)

					{
						e.printStackTrace();
					}

					counter ++;
				}
			}

		}

	}


