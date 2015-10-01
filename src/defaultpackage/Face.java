package defaultpackage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

/**
 * Creates an graphics Face object that can be used to draw a face on a canvas.
 * 
 * @author Christopher Malinosky Created: September 18, 2014
 *
 */
public class Face {
	// Instance Variables
	private final double OUTLINE_SIZE = 3.0;
	private final double EYE_DISTANCE_FACTOR = Math.sqrt(2) / 2.0;
	private double xFacePosition;
	private double yFacePosition;
	private double faceRadius;
	private double faceAngle;
	private Color faceColor;
	private Color outlineColor;
	private Color eyeColor;
	private Color mouthColor;

	// Default constructor
	public Face() {
		this.xFacePosition = 50;
		this.yFacePosition = 100;
		this.faceRadius = 50;
		this.faceAngle = 0;
		this.faceColor = Color.yellow;
		this.outlineColor = Color.blue;
		this.eyeColor = Color.black;
		this.mouthColor = Color.red;
	}

	// Constructer with variables
	public Face(double xFacePosition, double yFacePosition, double faceRadius, double faceAngle,
			Color faceColor, Color outlineColor, Color eyeColor,
			Color mouthColor) {
		this.xFacePosition = xFacePosition;
		this.yFacePosition = yFacePosition;
		this.faceRadius = faceRadius;
		this.faceAngle = faceAngle;
		this.faceColor = faceColor;
		this.outlineColor = outlineColor;
		this.eyeColor = eyeColor;
		this.mouthColor = mouthColor;
	}

	/**
	 * Draws the Face onto the given Graphics2D object.
	 * 
	 * @param graphics2
	 *            Graphics object onto which to draw the face
	 */
	public void drawOn(Graphics2D graphics2) {
		// Moves the center of the canvas to the center of the face.
		graphics2.translate(this.xFacePosition, this.yFacePosition);

		// Rotates the canvas to the angle of the face.
		graphics2.rotate(this.faceAngle);

		// Draws the outline of the face.
		graphics2.setColor(this.outlineColor);
		Ellipse2D.Double faceOutline = new Ellipse2D.Double(-this.faceRadius,
				-this.faceRadius, 2 * this.faceRadius, 2 * this.faceRadius);
		graphics2.fill(faceOutline);

		// Draws the inside of the face.
		graphics2.setColor(this.faceColor);
		Ellipse2D.Double faceBackground = new Ellipse2D.Double(-this.faceRadius
				+ this.OUTLINE_SIZE, -this.faceRadius + this.OUTLINE_SIZE,
				2 * (this.faceRadius - this.OUTLINE_SIZE),
				2 * (this.faceRadius - this.OUTLINE_SIZE));
		graphics2.fill(faceBackground);

		// Draws the left eye.
		graphics2.setColor(this.eyeColor);
		Ellipse2D.Double leftEye = new Ellipse2D.Double(
				-((this.faceRadius / 2.0) * this.EYE_DISTANCE_FACTOR + this.faceRadius * 0.28),
				-((this.faceRadius / 2.0) * this.EYE_DISTANCE_FACTOR + this.faceRadius * 0.28),
				(this.faceRadius * 0.28) * 2, (this.faceRadius * 0.28) * 2);
		graphics2.fill(leftEye);

		// Draws the right eye.
		Ellipse2D.Double rightEye = new Ellipse2D.Double(
				((this.faceRadius / 2.0) * this.EYE_DISTANCE_FACTOR - this.faceRadius * 0.28),
				-((this.faceRadius / 2.0) * this.EYE_DISTANCE_FACTOR + this.faceRadius * 0.28),
				(this.faceRadius * 0.28) * 2, (this.faceRadius * 0.28) * 2);
		graphics2.fill(rightEye);

		// Draws the mouth.
		graphics2.setColor(this.mouthColor);
		Arc2D.Double mouth = new Arc2D.Double(-0.7 * faceRadius, -0.7
				* faceRadius, 2 * 0.7 * faceRadius, 2 * 0.7 * faceRadius,
				-15.0, -150.0, Arc2D.CHORD);
		graphics2.fill(mouth);

		// Returns the canvas to its original state.
		graphics2.setColor(Color.black);
		graphics2.rotate(-this.faceAngle);
		graphics2.translate(-this.xFacePosition, -this.yFacePosition);
	}

	/**
	 * Translates the Face by the given amount.
	 * 
	 * @param translateX
	 *            Amount to translate in the x direction
	 * @param translateY
	 *            Amount to translate in the y direction
	 */
	public void translate(double translateX, double translateY) {
		this.xFacePosition += translateX;
		this.yFacePosition += translateY;
	}

	/**
	 * Rotates the Face by the given number of degrees.
	 * 
	 * @param degreesToRotate
	 *            Number of degrees to rotate the Face (e.g. 180 to turn the
	 *            Face upside down)
	 */
	public void rotate(double degreesToRotate) {
		this.faceAngle += degreesToRotate * (Math.PI / 180);
	}
	
	public double getxFacePosition() {
		return xFacePosition;
	}

	public double getyFacePosition() {
		return yFacePosition;
	}

	public double getFaceRadius() {
		return faceRadius;
	}
}
