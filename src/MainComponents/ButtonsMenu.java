package MainComponents;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.net.URL;

import javax.swing.JPanel;
import buttons.*;
public class ButtonsMenu extends JPanel {
	private static String[] toolNameStrings = { "Eraser", "Cutter", "Pencil", "Color Chooser", "Color Picker",
			"Transform", "Picture", "Color Slider","Move" };
	protected static int imgNum = new File("src//images").listFiles().length;
	ColorSlider cs = new ColorSlider();
	protected static URL[] iconURLs = new URL[imgNum];

	ButtonsMenu() {
		this.setPreferredSize(new Dimension(150, 100));
	}
}
