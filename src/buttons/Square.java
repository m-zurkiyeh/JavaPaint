package buttons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import MainComponents.CanvasPanel;

public class Square extends JLabel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color LIGHT_GRAY = new Color(204, 204, 204), DEFAULT_COLOR = new Color(238, 238, 238);
	private CanvasPanel cv;
	URL iconUrl;
	ImageIcon img;

	public Square(CanvasPanel cv) {
		this.cv = cv;
		iconUrl = getClass().getClassLoader().getResource("./images/square.png");
		img = new ImageIcon(
				new ImageIcon(iconUrl).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		addMouseListener(this);
		this.setIcon(img);
		this.setOpaque(true);
		this.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
		cv.setDrawColor(this.getBackground());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}

}
