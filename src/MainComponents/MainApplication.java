package MainComponents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import buttons.*;
import menu_items.PicImport;
import innerTools.*;

public class MainApplication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private double width = screenSize.getWidth(), height = screenSize.getHeight();
	boolean colorChanged = true;
	private static JFrame frame = new JFrame();
	CanvasPanel cp = new CanvasPanel(1);
	InnerTools it = new InnerTools();
	ButtonsMenu bm = new ButtonsMenu();
	TopMenu tm = new TopMenu();
	JMenu fileMenu, helpMenu;
	Eraser e = new Eraser(cp);
	ColorSlider cs = new ColorSlider(1,cp);
	Square s = new Square(cp);
	Pencil p = new Pencil(cp);
	PaintBucket pb = new PaintBucket(cp);
	ColorPicker colPicker = new ColorPicker(1, cp, s);
	LineDraw ld = new LineDraw(cp);
	private Object[] swingComponents = { e, cs, colPicker, s, p, pb,ld};

	public MainApplication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized Constructor for the MainApplication Class
	 * 
	 * @param i
	 */
	MainApplication(int i) {
		initGUI(swingComponents);
	}

	/**
	 * Initializes the entire GUI for the user to interact with
	 * @param components the array of type Object
	 */
	private void initGUI(Object[] components) {
		frame.setSize(new Dimension(1280, 800));
		frame.setTitle("Canvas Painter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(cp, BorderLayout.CENTER);
		frame.add(bm, BorderLayout.WEST);
		frame.setJMenuBar(tm);
		for (Object o : components)
			bm.add((Component) o);
		bm.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setVisible(true);
	}

	/**
	 * Returns the current frame the application is using
	 * @return frame the object of type JFrame
	 */
	public static JFrame getFrame() {
		return frame;
	}
}
