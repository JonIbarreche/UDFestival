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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWindow extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministracion = new JLabel("ADMINISTRACION");
		lblAdministracion.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblAdministracion.setBounds(197, 41, 329, 70);
		contentPane.add(lblAdministracion);
		
		JButton btnAdministrarConciertos = new JButton("Administrar Conciertos");
		btnAdministrarConciertos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir a AdminConciertoWindow
				AdminConciertoWindow acw = new AdminConciertoWindow();
				acw.setVisible(true);
				dispose();
			}
		});
		btnAdministrarConciertos.setForeground(Color.BLACK);
		btnAdministrarConciertos.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnAdministrarConciertos.setBounds(221, 155, 278, 50);
		contentPane.add(btnAdministrarConciertos);
		
		JButton btnAdministrarUsuarios = new JButton("Administrar Usuarios");
		btnAdministrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir a AdminUsuarioWindow
				AdminUsuarioWindow auw = new AdminUsuarioWindow();
				auw.setVisible(true);
				dispose();
			}
		});
		btnAdministrarUsuarios.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnAdministrarUsuarios.setBounds(221, 260, 278, 50);
		contentPane.add(btnAdministrarUsuarios);
		
		JLabel lblUdfestival = new JLabel("UDFestival");
		lblUdfestival.setForeground(Color.WHITE);
		lblUdfestival.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUdfestival.setBounds(321, 412, 67, 28);
		contentPane.add(lblUdfestival);
		
		JLabel label = new JLabel("<-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				dispose();
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(44, 13, 42, 28);
		contentPane.add(label);
	}
}
