
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Banner extends JPanel implements ActionListener {

	private int xPos, yPos;
	public static ArrayList<Balloon> Balloons;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Balloon b : Balloons) {
			b.draw(g, true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		for (Balloon b : Balloons) {
			
			int y = b.getY();
			y--;
			if (y < -0.5 * b.getRadius()) {
				y = (int) (500 + 0.5 * b.getRadius());
				
			}
			
			b.move(b.getX(), y);
			

			repaint();
		}
	}

	public static void main(String[] args) {

		Balloons = new ArrayList<Balloon>();
		//Balloon b1 = new Balloon(100, 500, 50, Color.BLUE);
		//Balloons.add(b1);
		
		Balloon b2 = new RoundBalloon(200, 500, 40, Color.RED);
		Balloons.add(b2);
		
		Balloon b3 = new OvalBalloon(300, 500, 50, Color.GREEN);
		Balloons.add(b3);
		
		Balloon b4 = new RoundBalloon(500, 500, 60, Color.BLUE);
		Balloons.add(b4);

		JFrame window = new JFrame("Action Demo");

		window.setBounds(300, 300, 500, 500);

		Banner panel = new Banner();
		panel.setBackground(Color.CYAN);

		// Add panel to window:
		Container c = window.getContentPane();
		c.add(panel);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		// Set the initial position of the message:
		panel.xPos = panel.getWidth();
		panel.yPos = panel.getHeight() / 2;

		// Create a Timer object that fires every 30 milliseconds;
		// attach it to panel so that panel "listens to" and
		// processes the timer events; start the timer:
		Timer clock = new Timer(30, panel);
		clock.start();
	}
}
