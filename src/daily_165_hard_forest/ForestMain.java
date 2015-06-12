package daily_165_hard_forest;
import javax.swing.JFrame;

public class ForestMain {

	public static void main(String[] args) {
		JFrame window = new JFrame("A Tale of Lumber and Claws");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}
