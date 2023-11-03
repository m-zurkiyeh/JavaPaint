package innerTools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line {
	private int x1,y1,x2,y2;
	private Color color;
	private int drawSize;
	
    public Line(int x1, int y1, int x2, int y2) {
    	this.x1 = x1;
    	this.y1 = y1;
    	this.x2 = x2;
    	this.y2 = y2;
//    	this.color = color;
//    	this.drawSize = drawSize;
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(drawSize));
        g2d.drawLine(x1, y1, x2, y2);
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