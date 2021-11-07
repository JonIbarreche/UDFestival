package gui;

import java.awt.EventQueue;
import java.util.logging.Level;
import org.apache.log4j.*;

import gui.LoginWindow;

public class MainWindow {
	private static final Logger logger = LogManager.getLogger(MainWindow.class);


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					logger.warn(Level.WARNING, e);
				}
			}
		});
	}

}
//Prueba