package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminConciertoWindow extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AdminConciertoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministradorConciertos = new JLabel("ADMINISTRADOR CONCIERTOS");
		lblAdministradorConciertos.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblAdministradorConciertos.setBounds(97, 13, 585, 54);
		contentPane.add(lblAdministradorConciertos);
		
		JLabel label = new JLabel("<-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminWindow aw = new AdminWindow();
				aw.setVisible(true);
				dispose();
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setBounds(24, 13, 51, 32);
		contentPane.add(label);
	}

}
