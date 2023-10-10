package MainComponents;
import javax.swing.*;
import menu_items.*;

public class TopMenu extends JMenuBar {
	/**
	 * Serial id which for some reason Eclipse threw a warning for
	 */
	private static final long serialVersionUID = 1L;
	JMenu fileMenu,helpMenu;
	PicImport pi;

	TopMenu() {
		fileMenu = new JMenu("File");
		pi = new PicImport("Import Picture");
		fileMenu.add(pi);
		this.add(fileMenu);
	}

}
