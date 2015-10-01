package defaultpackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PeopleClickHandler implements MouseListener {
	private ArrayList<Person> people;

	public PeopleClickHandler(ArrayList<Person> people) {
		this.people = people;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Person p : people) {
			double xmid = p.getFace().getxFacePosition();
			double ymid = p.getFace().getyFacePosition();
			double radius = p.getFace().getFaceRadius();
			double x = e.getX()-9;
			double y = e.getY()-36;
			if ((xmid - radius <= x) && (x <= xmid + radius) && (ymid - radius <= y)
					&& (y <= ymid + radius)) {
				p.printFeatures();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// ignored
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// ignored
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
