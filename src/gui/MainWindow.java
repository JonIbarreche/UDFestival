package gui;

import java.awt.EventQueue;
import gui.ExampleWindow;

public class MainWindow {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleWindow frame = new ExampleWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
