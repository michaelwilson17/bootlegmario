package firsttry;

import java.awt.Image;
import java.awt.Toolkit;

public class GoodGuy {

	private int xCoord = 0;
	private int yCoord = 0;
	private int height = 10;
	private int width = 10;
	private Image img;

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	/**
	 * GoodGuy default constructor
	 */
	public GoodGuy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("..files/mario.png");
	}
	
	/**
	 * GoodGuy overload constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height
	 */
	public GoodGuy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w); 
		setHeight(h);
		setImg(imgpath);
	}
	
	public void moveIt(int direction, int w, int h) {
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		
		System.out.println(x);
		System.out.println(y);
		
		if (direction == 39) {
			x = x + speed;
			if (x > w) { x = x - speed * 3; }
			setxCoord(x);
			setImg("files/mario.png");
		} else if (direction == 37) {
			if (x < 0) { x = x + speed * 3; }
			x = x - speed;
			setxCoord(x);
			setImg("files/marioleft.png");
		} else if (direction == 38) {
			if (y < 0) { y = y + speed * 3; }
			y = y - speed;
			setyCoord(y);
		} else if (direction == 40) {
			if (y > h - 10) { y = y - speed * 3; }
			y = y + speed;
			setyCoord(y);
		}	
	}
		
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	
}



