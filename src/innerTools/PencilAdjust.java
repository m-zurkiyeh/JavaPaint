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
	private JSlider size = new JSlider(10, 80);
	private JSlider stroke = new JSlider(0, 40);
	private SizePreview sp;
	private int drawSize = 30, strokeSize = 10;
	private static boolean visible = true;

	public PencilAdjust(CanvasPanel cv) {
		this.setPreferredSize(new Dimension(150, 100));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		sp = new SizePreview(this, cv);
		size.addChangeListener(this);
		stroke.addChangeListener(this);
		add(size);
		add(sp);
		add(stroke);
		sp.repaint();
		this.cv = cv;
		this.setVisible(visible);
		this.setOpaque(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == size) {
			drawSize = size.getValue();
			cv.setDrawSize(drawSize);
			sp.repaint();
		} else if (e.getSource() == stroke) {
			strokeSize = stroke.getValue();
			cv.setStrokeSize(strokeSize);
			//sp.repaint();

		}

	}

	public int getDrawSize() {
		return drawSize;
	}

	public static void setVisible() {
		visible = !visible;
		// setVisible(visible);
	}

	public boolean getVisible() {
		return visible;
	}

}
