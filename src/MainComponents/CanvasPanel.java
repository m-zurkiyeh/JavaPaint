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
	private ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Color> colors = new ArrayList<>();
	static ColorSlider cs = new ColorSlider();
	public static String currentTool = "Pencil";
	private Robot robot;
	private Point co;
	static Color newColor;
	private Color pickerColor, pickedColor;
	Graphics graphics;
	Graphics2D g2D;

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
				case "Eraser":
					points.add(new Point(e.getX(), e.getY()));
					colors.add(newColor);
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
						System.out.println(pickerColor.getRed() + " " + pickerColor.getGreen() + " " + pickerColor.getBlue());
						if(pickerColor.getRed() == 238 && pickerColor.getGreen() == 238 && pickerColor.getBlue() == 238) {
							System.out.println("White");
						} else ColorPicker.changeBgColor(pickedColor);

					} catch (Exception ex) {

					}

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (currentTool) {

				case "Pencil":
				case "Eraser":
					points.add(new Point(e.getX(), e.getY()));
					colors.add(newColor);
					repaint();
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
//				for (int i = 0; i < points.size(); i++) {
//					points.remove(points.get(i));
//					colors.remove(colors.get(i));
//				}
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
		setVisible(true);
	}

	/**
	 * Default Constructor for the CanvasPanel Class
	 */
	public CanvasPanel() {

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
			g2D.fillOval(points.get(i).x - 15, points.get(i).y - 20, 30, 30);

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
	
	

}
