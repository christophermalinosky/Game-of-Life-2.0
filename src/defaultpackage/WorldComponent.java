package defaultpackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class WorldComponent extends JComponent {
		private ArrayList<Person> people;
	
		public WorldComponent(ArrayList<Person> people){
			this.people = people;
		}
	
		/**
		 * Draws Faces.
		 */
		@Override
		protected void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);

			Graphics2D graphics2 = (Graphics2D) graphics;

			// this.testDrawing(graphics2);
			drawFaces(graphics2);
		}

		/*
		 * Tests that Faces are drawn correctly on the given Graphics2 object.
		 */
		private void drawFaces(Graphics2D graphics2) {
			for(Person p : people){
				p.getFace().drawOn(graphics2);
			}
		}
}
