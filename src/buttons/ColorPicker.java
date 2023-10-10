package buttons;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import MainComponents.*;

public class ColorPicker extends JLabel implements MouseListener {
	private URL iconUrl;
	private ImageIcon img;
	private Cursor c;
	private static JFrame frame = MainApplication.getFrame();
	private CanvasPanel drawingPanel;
	private static final Color LIGHT_GRAY = new Color(204,204,204), DEFAULT_COLOR = new Color(238,238,238);
	public ColorPicker() {
		
	}
	
	public ColorPicker(int i, CanvasPanel drawingPanel) {
		iconUrl = getClass().getClassLoader().getResource("./images/ColorPicker.png");
		img = new ImageIcon(new ImageIcon(iconUrl).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		addMouseListener(this);
		this.drawingPanel = drawingPanel;
		
		this.setIcon(img);
		this.setOpaque(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this) {
			c = Toolkit.getDefaultToolkit().createCustomCursor(img.getImage(), new Point(10,30), TOOL_TIP_TEXT_KEY);
			frame.setCursor(c);
			drawingPanel.setCurrentTool("Color Picker");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(LIGHT_GRAY);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(DEFAULT_COLOR);
		
	}
	

}
