package innerTools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

import MainComponents.CanvasPanel;

public class Line extends JPanel {
	private int x1,y1,x2,y2;
	private Color color;
	private int strokeSize;
	private CanvasPanel cv;
	//private Graphics g;
	
    public Line(int x1, int y1, int x2, int y2, int strokeSize,Color color) {
    	this.x1 = x1;
    	this.y1 = y1;
    	this.x2 = x2;
    	this.y2 = y2;
    	this.strokeSize = strokeSize;
    	this.color = color;
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeSize));
        g2d.drawLine(x1, y1, x2, y2);
    }

    public int getX1() {
		return x1;
    	
    }
    
    public int getX2() {
    	return x2;
    }
    
    public int getY1() {
    	return y1;
    }
    
    public int getY2() {
    	return y2;
    }
    /**
     * Sets the second x coordinate
     * @param x2 the variable of type int
     * @return void
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }
    
    /**
     * Sets the second y coordinate
     * @param y2 the variable of type int
     * @return void
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    

}