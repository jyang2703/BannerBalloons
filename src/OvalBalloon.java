import java.awt.Color;
import java.awt.Graphics;

public class OvalBalloon extends Balloon {

	public OvalBalloon() {
		super();
	}

	public OvalBalloon(int x, int y, int r, Color c) {
		super(x, y, r, c);
	}

	public void draw(Graphics g, boolean makeItFilled) {
		int x = getX();
		int y = getY();
		int r = getRadius();
		g.setColor(getColor());
		if (makeItFilled)
			g.fillOval(x - r, y - r, r, 2 * r);
		else
			g.drawOval(x - r, y - r, r, 2 * r);
	}

	public double distance(int x, int y) {
		double dx = 2* (x - getX());
		double dy = y - getY();
		return Math.sqrt(dx * dx + dy * dy);
	}
}
