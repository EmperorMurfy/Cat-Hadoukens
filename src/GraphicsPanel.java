// Graphics Panel


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;


public class GraphicsPanel extends JPanel implements KeyListener{
	
	
	private Timer timer;
	
	private Background background1;			// The background object will display a picture in the background.
	private Background background2;	
	

	// method: GraphicsPanel Constructor
	// description: This 'method' runs when a new instance of this class in instantiated.  It sets default values  
	// that are necessary to run this project.  You do not need to edit this method.
	public GraphicsPanel(){
		background1 = new Background();	// You can set the background variable equal to an instance of any of  
		background2 = new Background(background1.getImage().getIconWidth(),"background/dollHouse.jpg");
		
        this.setFocusable(true);			// for keylistener
		this.addKeyListener(this);
		
					

		setPreferredSize(new Dimension(background1.getImage().getIconWidth(),
				background2.getImage().getIconHeight()));  
		// This line of code sets the dimension of the panel equal to the dimensions
		// of the background image.
			
	}
	
	public void clock(){
		
		this.repaint();
	}
	
	// method: paintComponent
	// description: This method is called when the Panel is painted.  It contains code that draws shapes onto the panel.
	// parameters: Graphics g - this object is used to draw shapes onto the JPanel.
	// return: void
	public void paintComponent(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		
		// background
	
        background1.draw(this, g);
		background2.draw(this, g);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
				
		
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// This function will play the sound "fileName".
		public static void playSound(String fileName) {
			try {
				File url = new File(fileName);
				Clip clip = AudioSystem.getClip();

				AudioInputStream ais = AudioSystem.getAudioInputStream(url);
				clip.open(ais);
				clip.start();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}

}