package innerTools;

import java.awt.Dimension;

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
	private JSlider size = new JSlider();
	private int drawSize;

	public PencilAdjust(CanvasPanel cv) {
		add(size);
		this.cv = cv;
		this.setPreferredSize(new Dimension(150, 45));
		this.setVisible(true);
		this.setOpaque(true);
		size.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		drawSize = size.getValue();
		cv.setDrawSize(drawSize);
		
	}
}
