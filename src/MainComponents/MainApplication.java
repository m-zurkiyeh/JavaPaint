package MainComponents;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import buttons.*;
import menu_items.PicImport;

public class MainApplication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private double width = screenSize.getWidth(), height = screenSize.getHeight();
	boolean colorChanged = true;
	private static JFrame frame = new JFrame();
	ButtonsMenu bm = new ButtonsMenu();
	TopMenu tm = new TopMenu();
	CanvasPanel cp = new CanvasPanel(1);
	JMenu fileMenu,helpMenu;
	Eraser e = new Eraser();
	ColorSlider cs = new ColorSlider(1);
	ColorPicker colPicker = new ColorPicker(1,cp);
	Object [] swingComponents = {e,cs,colPicker};
	
	public MainApplication() {
		// TODO Auto-generated constructor stub
	}
	
	MainApplication(int i) {
		//frame.setSize(new Dimension((int) width - 20, (int) height - 60));
		frame.setSize(new Dimension(800,600));
		frame.setTitle("Canvas Painter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(cp,BorderLayout.CENTER);
		frame.add(bm, BorderLayout.WEST);
		frame.setJMenuBar(tm);
		initGUI();
		bm.setLayout(new FlowLayout(FlowLayout.LEFT));
		//frame.setLayout(null);
		frame.setVisible(true);

	}
	
	private void initGUI() {
		for(Object o : swingComponents)
			bm.add((Component) o);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
}
