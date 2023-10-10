package MainComponents;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.html.CSS;

import buttons.ColorSlider;

import java.awt.*;

/**
 * This class represents the primary panel in which the user will be drawing on
 * 
 * @author Malik
 *
 */
public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {

	// Both arraylists are essential. Do not Remove!
	private ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Color> colors = new ArrayList<>();
	static ColorSlider cs = new ColorSlider();
	public static String currentTool = "Pencil";

	static Color newColor = cs.getColor();
	Graphics graphics;
	Graphics2D g2D;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterized constructor for CanvasPanel
	 * 
	 * @param i serves no purpose but as a placeholder should the use of the default
	 *          constructor is necessary
	 */
	public CanvasPanel(int i) {
		addMouseMotionListener(this);
		setVisible(true);
	}

	/**
	 * Default Constructor for the CanvasPanel Class
	 */
	public CanvasPanel() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (currentTool) {
		case "Pencil":
			points.add(new Point(e.getX(), e.getY()));
			colors.add(newColor);
			repaint();
			break;
		}
	}

	/**
	 * When the mouse is pressed, a new Point storing the mouse's current X and Y
	 * axes is added to the points arraylist
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		switch (currentTool) {
		case "Pencil":
			points.add(new Point(e.getX(), e.getY()));
			colors.add(newColor);
			repaint();
			break;
		case "Color Picker":
			System.out.println("It pick colors");
			break;

		}

	}

	/**
	 * After the mouse has been released, all items inside of the points and colors
	 * Array lists are removed to save resources
	 * 
	 * @return void
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		for (int i = 0; i < points.size(); i++) {
			points.remove(points.get(i));
			colors.remove(colors.get(i));
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Almost identical result as mouseClicked except repaint() is called to call
	 * the overridden paint function
	 * 
	 * @param e the object of type MouseEvent
	 * @return void
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		switch (currentTool) {
		case "Pencil":
			newColor = cs.getColor();
			points.add(new Point(e.getX(), e.getY()));
			colors.add(newColor);
			repaint();
			break;

		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Overridden version of paintComponent that draws the shapes by iterating
	 * through the points and colors arraylists to draw shape with its set color
	 * respectively
	 * 
	 * @param g object of type Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		for (int i = 0; i < points.size(); i++) {
			g2D.setColor(colors.get(i));
			g2D.fillOval(points.get(i).x, points.get(i).y, 30, 30);

		}

	}

	/**
	 * Sets the current color
	 * 
	 * @param c the object of type Color
	 * @return void
	 */
	public void setDrawColor(Color c) {
		newColor = c;
	}

	public JPanel getPanel() {
		return this;
	}

	public void setCurrentTool(String tool) {
		currentTool = tool;
	}

	public String getCurrentTool() {
		return currentTool;
	}

}
