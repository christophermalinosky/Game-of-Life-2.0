package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WorldViewer {
	private static final Dimension JFRAME_SIZE = new Dimension(1200, 800);
	//30*20 faces
	public static void main(String[] args) {
		JFrame faceJFrame = new JFrame();
		faceJFrame.setSize(JFRAME_SIZE);
		GameOfLife2 game = new GameOfLife2();
		game.stuff();
		WorldComponent view =  new WorldComponent(game.getPeople());
		final UpdateButton updateButton = new UpdateButton(game, view);
		faceJFrame.add(updateButton, BorderLayout.SOUTH);
		faceJFrame.add(view);
		faceJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		faceJFrame.setVisible(true);
		Timer timerA = new Timer(200, updateButton);
		timerA.start();
		PeopleClickHandler peopleClickHandler = new PeopleClickHandler(game.getPeople());
		faceJFrame.addMouseListener(peopleClickHandler);
	}
}
