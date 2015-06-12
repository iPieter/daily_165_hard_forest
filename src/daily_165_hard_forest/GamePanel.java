package daily_165_hard_forest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Event.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	//dimensions
	public static final int DIM = 70;
	public static final int WIDTH = DIM * 10;
	public static final int HEIGHT = WIDTH;
	
	private Thread thread;
	private boolean running;
	private int FPS = 20;
	private long targetTime = 1000/FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private Forest forest;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		
	}
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		this.forest = new Forest(DIM);

		running = true;
	}
	
	public void run() {
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			System.out.println("Frame");
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			if (wait >= 0 ) {
				try {
					thread.sleep(wait);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	private void update() {
		forest.tick();
	}
	
	private void draw() {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		forest.getImage(g);
		
	}
	
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0,0, null);
		g2.dispose();
	}
	
}
