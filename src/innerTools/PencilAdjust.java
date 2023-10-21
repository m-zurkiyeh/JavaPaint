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
	private int drawSize = 30;
	public PencilAdjust(CanvasPanel cv) {
		this.setPreferredSize(new Dimension(150, 100));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		sp = new SizePreview(this,cv);
		size.addChangeListener(this);
		add(size);
		add(sp);
		sp.repaint();
		this.cv = cv;
		this.setVisible(true);
		this.setOpaque(true);

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
	
	
	
}
