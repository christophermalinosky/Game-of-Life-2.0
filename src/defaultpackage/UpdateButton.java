package defaultpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


/**
 * This class implements the update button for the game.
 *
 * @author Curt Clifton.
 *         Created Sep 24, 2008.
 */
@SuppressWarnings("serial")
public class UpdateButton extends JButton implements ActionListener {
	private WorldComponent view;
	private GameOfLife2 game;

	/**
	 * Creates an update button that updates the given game.
	 *
	 * @param game
	 */
	public UpdateButton(GameOfLife2 game, WorldComponent view) {
		super("Click to Update");
		this.game = game;
		this.view = view;
		
		// Tells Java to call this class if the user clicks the button.
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// This button was clicked, so...
		// ...update the game state, and...
		this.game.tick();
		// ...tell the component that it needs to be repainted. 
		this.view.repaint();
	}

}
