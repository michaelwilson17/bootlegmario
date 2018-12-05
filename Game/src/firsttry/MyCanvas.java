package firsttry;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Image;

import sun.audio.*;



public class MyCanvas extends Canvas implements KeyListener {
	
	GoodGuy link = new GoodGuy (10,10,50,50,"files/mario.png");
	Peach peach = new Peach (10,70,50,50,"files/peach.png");
	LinkedList badguys = new LinkedList();
	
/**
 * @author michael.wilson
 * @since Oct. 9, 2018
 * @param no parameters, default constructor
 */
	public MyCanvas() {
		this.setSize(600,400);
		this.addKeyListener(this);
		playIt1("files/mario.wav");
	
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();
		for(int i = 0; i<10; i++) {
			BadGuy bg = new BadGuy(rand.nextInt(winwidth), rand.nextInt(winheight),50,50,"files/villain.png");
			Rectangle r = new Rectangle(50,50,30,30);
			if (r.contains(link.getxCoord(),link.getyCoord())) { 
				System.out.println("badguy on top of link");
				continue;
		}
		badguys.add(bg);
		}
	}

		
	private void playIt2(String string) {
	// TODO Auto-generated method stub
	
}

	/**
	 * paint overload java.awt.Canvas paint method and make draw an oval
	 * @param graphics context variable called g
	 */
	@Override
	public void paint(Graphics g) {
		
		
	
		g.drawImage(Toolkit.getDefaultToolkit().getImage("files/mariob.png"), 0, 0, 600, 400, this);
		
		g.drawImage(link.getImg(), link.getxCoord(), link.getyCoord(), link.getWidth(), link.getHeight(), this);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("files/peach.png"), 0, 0, 6000, 6000, this);
		
		g.drawImage(peach.getImg(), peach.getxCoord(), peach.getyCoord(), peach.getWidth(), peach.getHeight(), this);
		
		for (int i = 0; i < badguys.size(); i++) {
			BadGuy bg = (BadGuy) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			
		}
		
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
	
		link.moveIt(e.getKeyCode(),this.getWidth(),this.getHeight());
		peach.moveIt(e.getKeyCode(),this.getWidth(),this.getHeight());
		
		for (int i = 0; i < badguys.size(); i++) {
			BadGuy bg = (BadGuy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			Rectangle ggr = new Rectangle(link.getxCoord(),link.getyCoord(),link.getWidth(),link.getHeight());
			Rectangle pn = new Rectangle(peach.getxCoord(),peach.getyCoord(),peach.getWidth(),peach.getHeight());
			//if (r.contains(link.getxCoord(),link.getyCoord())) {
			if (r.intersects(ggr)) {
				

				System.out.println("badguy hit by link");
				badguys.remove(i);
			}
			if (r.intersects(pn)) {

				System.out.println("badguy hit by link");
				badguys.remove(i);
			}
		}
		repaint();
	}


	private void playIt(String string) {
	// TODO Auto-generated method stub
	
}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	

public void playIt1(String filename) {
	
	try {
		InputStream in = new FileInputStream(filename);
		AudioStream as = new AudioStream(in);
		AudioPlayer.player.start(as);
	} catch (IOException e) {
		System.out.println(e);
	}
}
}