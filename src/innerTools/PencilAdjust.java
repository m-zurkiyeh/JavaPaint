package innerTools;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import MainComponents.CanvasPanel;

public class PencilAdjust extends JPanel implements ChangeListener {
	private CanvasPanel cv;
	private JSlider size = new JSlider(10,80);
	private SizePreview sp;
	private int drawSize;
	public PencilAdjust(CanvasPanel cv) {
		sp = new SizePreview(this,cv);
		this.cv = cv;
		this.setPreferredSize(new Dimension(150, 100));
		this.setVisible(true);
		this.setOpaque(true);
		size.addChangeListener(this);
		add(size);
		add(sp);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		drawSize = size.getValue();
		cv.setDrawSize(drawSize);
		sp.repaint();
		
	}
	
	public int getDrawSize() {
		return drawSize;
	}
	
	@Override
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(cv.getDrawColor());
        g.fillOval(500, 500, getDrawSize(), getDrawSize());

        ui.update(g, this);
    }
	
	
}
