package buttons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MainComponents.CanvasPanel;
import MainComponents.MainApplication;

public class Pencil extends JLabel implements MouseListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color LIGHT_GRAY = new Color(204, 204, 204), DEFAULT_COLOR = new Color(238, 238, 238);
	URL iconUrl;
	ImageIcon img;
	private CanvasPanel cv;
	private static JFrame frame = MainApplication.getFrame();


	public Pencil(CanvasPanel cv) {
		iconUrl = getClass().getClassLoader().getResource("./images/pencil.png");
		img = new ImageIcon(
				new ImageIcon(iconUrl).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.cv = cv;
		addMouseListener(this);
		this.setIcon(img);
		this.setOpaque(true);
		this.setVisible(true);
		
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		cv.setCurrentTool("Pencil");
		frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
