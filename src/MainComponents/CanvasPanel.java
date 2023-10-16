package MainComponents;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.html.CSS;

import buttons.ColorPicker;
import buttons.ColorSlider;

import java.awt.*;

/**
 * This class represents the primary panel in which the user will be drawing on
 * 
 * @author Malik
 * 
 */
public class CanvasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Both arraylists are essential. Do not Remove!
	private ArrayList<Point> points = new ArrayList<>(), eraPoints = new ArrayList<>();
	private ArrayList<Color> colors = new ArrayList<>(), eraColors = new ArrayList<>();
	static ColorSlider cs = new ColorSlider();
	public static String currentTool = "Pencil";
	private int xbegin = 0, ybegin = 0, xend = 0, yend = 0;
	private Robot robot;
	private Point co, startPoint;
	private static Color color, eraserColor = new Color(238, 238, 238), lastColor = new Color(51, 51, 51);
	private Color pickerColor, pickedColor;
	Graphics graphics;
	Graphics2D g2D;

	/**
	 * Default Constructor for the CanvasPanel Class
	 */
	public CanvasPanel() {

	}

	/**
	 * Parameterized constructor for CanvasPanel
	 * 
	 * @param i serves no purpose but as a placeholder should the use of the default
	 *          constructor is necessary
	 */
	public CanvasPanel(int i) {
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
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
					points.add(new Point(e.getX(), e.getY()));
					colors.add(lastColor);
					repaint();
					break;
				case "Eraser":
					points.add(new Point(e.getX(), e.getY()));
					colors.add(eraserColor);
					repaint();
					break;
				case "Line Draw":
					xbegin = xend = e.getX();
					ybegin = yend = e.getY();
					repaint();
					break;
				}

			}
		});
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				switch (currentTool) {
				case "Color Picker":
					try {
						co = MouseInfo.getPointerInfo().getLocation();
						robot = new Robot();
						pickerColor = robot.getPixelColor((int) co.getX(), (int) co.getY());
						pickedColor = new Color(pickerColor.getRed(), pickerColor.getGreen(), pickerColor.getBlue());
						System.out.println(pickerColor.toString());
						ColorPicker.changeBgColor(pickedColor);

					} catch (Exception ex) {
						System.out.println("An error has ocurred");
					}
					break;
				case "Paint Bucket":
					setBackground(color);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (currentTool) {
				case "Pencil":
					points.add(new Point(e.getX(), e.getY()));
					colors.add(lastColor);
					repaint();
					break;
				case "Eraser":
					points.add(new Point(e.getX(), e.getY()));
					colors.add(eraserColor);
					repaint();
					break;
				case "Line Draw":
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
				switch (currentTool) {
				case "Line Draw":
					xend = e.getX();
					yend = e.getY();
					repaint();
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

		});
		setOpaque(true);
		setVisible(true);
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
		switch (currentTool) {
		case "Pencil":
		case "Eraser":
			for (int i = 0; i < points.size(); i++) {
				g2D.setColor(colors.get(i));
				Point p = points.get(i);
				g2D.fillOval((int) p.getX() - 15, (int) p.getY() - 15, 30, 30);
			}
			break;

		case "Line Draw":
			g2D.drawLine(xbegin, ybegin, xend, yend);
			break;
		}

	}

	/**
	 * Sets the current color
	 * 
	 * @param c the object of type Color
	 * @return void
	 */
	public void setDrawColor(Color newColor) {
		if(getCurrentTool().equals("Pencil")) {
			lastColor = newColor;
		} 
	}

	/**
	 * Sets the string
	 * 
	 * @param tool
	 * @return void
	 */
	public void setCurrentTool(String tool) {
		currentTool = tool;
	}

	public String getCurrentTool() {
		return currentTool;
	}

	public Color getDrawColor() {
		if (currentTool.equals("Eraser")) {
			return eraserColor; // Use the eraser color when the eraser tool is active
		} else {
			return lastColor; // Use the selected color for other tools
		}

	}

}
