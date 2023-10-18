package buttons;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import MainComponents.*;



public class ColorSlider extends JLabel implements MouseListener, ChangeListener {

	/**
	 * 
	 */
	private static boolean colorChanged = false;
	private static final long serialVersionUID = 1L;
	private static final Color LIGHT_GRAY = new Color(204, 204, 204), DEFAULT_COLOR = new Color(238, 238, 238);
	private static Color newColor;
	private URL iconUrl;
	private ImageIcon img;
	private JPanel colorDialogPanel, westColorDialoguePanel, colorPreviewPanel;
	private JButton colorDialogValidateButton;
	private JDialog colorDialog;
	private JSlider rSlider, gSlider, bSlider;
	private CanvasPanel cv;

	/**
	 * Default Constructor for ColorSlider
	 */
	public ColorSlider() {
		
	}
	
	
	/**
	 * Initializes the ColorSlider to be shown as well as its actions
	 * @param i just a placeholder int file to allow the use of the default constructor
	 */
	public ColorSlider(int i, CanvasPanel cv) {
		this.cv = cv;
		iconUrl = getClass().getClassLoader().getResource("./images/ColorChooser.png");
		img = new ImageIcon(new ImageIcon(iconUrl).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		addMouseListener(this);
		colorDialogPanel = new JPanel();
		westColorDialoguePanel = new JPanel();
		colorPreviewPanel = new JPanel();
		colorDialogValidateButton = new JButton("OK");
		colorDialog = new JDialog();
		rSlider = new JSlider(0, 255);
		gSlider = new JSlider(0, 255);
		bSlider = new JSlider(0, 255);
		rSlider.addChangeListener(this);
		gSlider.addChangeListener(this);
		bSlider.addChangeListener(this);
		colorDialogValidateButton.addMouseListener(this);
		colorDialog.setSize(new Dimension(400, 240));
		colorDialog.add(westColorDialoguePanel, BorderLayout.WEST);
		colorDialog.add(colorPreviewPanel, BorderLayout.CENTER);
		colorDialog.add(colorDialogPanel, BorderLayout.SOUTH);
		westColorDialoguePanel.add(Box.createRigidArea(new Dimension(5, 5)));
		westColorDialoguePanel.setLayout(new BoxLayout(westColorDialoguePanel, BoxLayout.Y_AXIS));
		westColorDialoguePanel.add(new JLabel("R"));
		westColorDialoguePanel.add(rSlider);
		westColorDialoguePanel.add(Box.createRigidArea(new Dimension(5, 20)));
		westColorDialoguePanel.add(new JLabel("G"));
		westColorDialoguePanel.add(gSlider);
		westColorDialoguePanel.add(Box.createRigidArea(new Dimension(5, 20)));
		westColorDialoguePanel.add(new JLabel("B"));
		westColorDialoguePanel.add(bSlider);
		colorDialogPanel.add(colorDialogValidateButton);
		this.setIcon(img);
		this.setOpaque(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this) {
			colorPreviewPanel.setBackground(new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue()));
			colorDialog.setLocationRelativeTo(null);
			colorDialog.setVisible(true);
			colorDialog.setResizable(false);
			colorDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}
		
		if(e.getSource() == colorDialogValidateButton) {
			newColor = new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
			cv.setDrawColor(newColor);
			colorDialog.dispose();
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


	@Override
	public void stateChanged(ChangeEvent e) {
		newColor = new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
		colorPreviewPanel.setBackground(newColor);

	}

	/**
	 * Returns the new Color object
	 * @return newColor
	 */
	public Color getColor() {
		colorChanged = true;
		return newColor;
	}
	
	
	/**
	 * 
	 * @param c the parameter of type Color
	 * @return void
	 */
	public static void setColor(Color c) {
		newColor = c;
	}
}
