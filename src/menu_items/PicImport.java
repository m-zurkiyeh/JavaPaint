package menu_items;

import java.awt.event.*;
import javax.swing.*;

public class PicImport extends JMenuItem implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PicImport(String name) {
		addActionListener(this);
		this.setText(name);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("This button has been clicked");

	}

	
}
