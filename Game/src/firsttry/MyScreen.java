package firsttry;

import javax.swing.JFrame;

public class MyScreen extends JFrame{

/**
 * @author michael.wilson
 * @since Oct. 9, 2018
 */

	/**
	 * MyScreen default constructor
	 * @author michael.wilson
	 * @param none, default constructor
	 */
	public MyScreen() {
		
		// this is current instance, setters are mutator methods methods which change properties
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
		// TODO Auto-generated method stub

	public static void main(String[] args) {
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
	}
}

