package src;



import javax.swing.JFrame;

public class MainSnake {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Adventures");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null);
		frame.add(new Map());
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
