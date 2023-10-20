package innerTools;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MainComponents.CanvasPanel;

public class SizePreview extends JPanel {
	/**
	 * 
	 */
	private Graphics g;
	private static final long serialVersionUID = 1L;
	private PencilAdjust pa;
	private CanvasPanel cv;
	private int circleX;
	private int circleY;
	private int circleRadius;

	public SizePreview(PencilAdjust pa, CanvasPanel cv) {
		this.setPreferredSize(new Dimension(100, 120));
		this.pa = pa;
		this.cv = cv;
		this.circleRadius = pa.getDrawSize() / 2; // Initialize circleRadius
		this.setOpaque(true);
		this.setVisible(true);
		repaint();

	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// Calculate the new center of the panel
		int centerX = panelWidth / 2;
		int centerY = panelHeight / 2;
		int circleSize = pa.getDrawSize();

		// Update the circle position based on the new center
		int circleX = (panelWidth - circleSize) / 2;
		int circleY = (panelHeight - circleSize) / 2;
		g.setColor(cv.getDrawColor());
		g.fillOval(circleX, circleY-10, pa.getDrawSize(), pa.getDrawSize());
//        ui.update(g, this);
	}
}
