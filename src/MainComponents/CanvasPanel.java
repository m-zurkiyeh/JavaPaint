package MainComponents;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.html.CSS;

import buttons.ColorPicker;
import buttons.ColorSlider;
import innerTools.*;

import java.awt.*;

/**
 * This class represents the primary panel in which the user will be drawing on
 * 
 * @author Malik Zurkiyeh
 * 
 */
public class CanvasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Both arraylists are essential. DO NOT REMOVE
	private ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Color> colors = new ArrayList<>();
	private ArrayList<Integer> drawSizes = new ArrayList<>();
	private ArrayList<Line> lines =  new ArrayList<>();
	private Line currentLine = null;
	static ColorSlider cs = new ColorSlider();
	public static String currentTool = "Pencil";
	private int drawSize = 30, xbegin = 0, ybegin = 0, xend = 0, yend = 0;
	private Robot robot;
	private Point co, startPoint;
	private Color color, pickerColor, pickedColor, eraserColor = new Color(238, 238, 238),
			lastColor = new Color(51, 51, 51);
	Graphics graphics;
	Graphics2D g2D;
	PencilAdjust pa = new PencilAdjust(this);

	/**
	 * Primary constructor for the CanvasPanel class
	 */
	public CanvasPanel() {
		setLayout(new BorderLayout());
		this.add(pa, BorderLayout.NORTH);
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
					points.add(new Point(e.getX() - drawSize / 2, e.getY() - drawSize / 2));
					colors.add(getDrawColor());
					drawSizes.add(drawSize);
					repaint();
					break;
				case "Eraser":
					points.add(new Point(e.getX() - drawSize / 2, e.getY() - drawSize / 2));
					colors.add(eraserColor);
					drawSizes.add(drawSize);
					repaint();
					break;
				case "Line Draw":
					if (currentLine != null) {
	                    currentLine.setX2(e.getX());
	                    currentLine.setY2(e.getY());
	                    repaint();
	                }
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
					points.clear();
					colors.clear();
					drawSizes.clear();
					setBackground(lastColor);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (currentTool) {
				case "Pencil":
					points.add(new Point(e.getX() - drawSize / 2, e.getY() - drawSize / 2));
					colors.add(color);
					drawSizes.add(drawSize);
					repaint();
					break;
				case "Eraser":
					points.add(new Point(e.getX() - drawSize / 2, e.getY() - drawSize / 2));
					colors.add(eraserColor);
					drawSizes.add(drawSize);
					repaint();
					break;
				case "Line Draw":
					xbegin = xend = e.getX();
					ybegin = yend = e.getY();
					currentLine = new Line(xbegin, ybegin, xend, yend);
                    lines.add(currentLine);
					repaint();
					break;
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				switch (currentTool) {
				case "Line Draw":
					if (currentLine != null) {
	                    currentLine.setX2(e.getX());
	                    currentLine.setY2(e.getY());
	                    repaint();
	                }
					break;
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
	 * @return void
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2D = (Graphics2D) g;

		for (int i = 0; i < points.size(); i++) {
			g2D.setColor(colors.get(i));
			Point p = points.get(i);
			g2D.fillOval((int) p.getX(), (int) p.getY(), drawSizes.get(i), drawSizes.get(i));
		}
		for(Line line: lines)
			line.draw(g);
		//g2D.drawLine(xbegin, ybegin, xend, yend);

	}

	/**
	 * Sets the current color
	 * 
	 * @param c the object of type Color
	 * @return void
	 */
	public void setDrawColor(Color newColor) {
		color = newColor;
		lastColor = color;
	}

	public void setDrawSize(int drawSize) {
		this.drawSize = drawSize;
	}

	/**
	 * Returns the previous color
	 * 
	 * @return lastColor the variable of type
	 */
	public Color getLastColor() {
		return lastColor;
	}

	public void setEraserColor(Color newColor) {
		eraserColor = newColor;
	}

	/**
	 * Sets the current tool
	 * 
	 * @param tool the parameter of type String
	 * @return void
	 */
	public void setCurrentTool(String tool) {
		currentTool = tool;
	}

	/**
	 * Returns the current tool string
	 * 
	 * @return currentTool the variable of typ String
	 */
	public String getCurrentTool() {
		return currentTool;
	}

	/**
	 * Returns the current color
	 * 
	 * @return color the variable of type Color
	 */
	public Color getDrawColor() {
		return color;

	}

}

