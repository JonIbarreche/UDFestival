package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUsuarioWindow extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AdminUsuarioWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministradorUsuarios = new JLabel("ADMINISTRADOR USUARIOS");
		lblAdministradorUsuarios.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblAdministradorUsuarios.setBounds(130, 13, 509, 52);
		contentPane.add(lblAdministradorUsuarios);
		
		JLabel label = new JLabel("<-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminWindow aw = new AdminWindow();
				aw.setVisible(true);
				dispose();
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(33, 16, 45, 52);
		contentPane.add(label);
	}

}
