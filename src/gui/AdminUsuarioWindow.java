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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUsuarioWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNickname;
	private JTextField txtMail;
	private JTextField txtPassword;
	private JTextField txtNumeroDeTelefono;

	

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
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setBounds(84, 95, 131, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNickname = new JTextField();
		txtNickname.setText("Nickname");
		txtNickname.setBounds(84, 142, 131, 22);
		contentPane.add(txtNickname);
		txtNickname.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setText("Mail");
		txtMail.setBounds(84, 193, 131, 22);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(84, 241, 131, 22);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtNumeroDeTelefono = new JTextField();
		txtNumeroDeTelefono.setText("Numero de Telefono");
		txtNumeroDeTelefono.setBounds(84, 294, 131, 22);
		contentPane.add(txtNumeroDeTelefono);
		txtNumeroDeTelefono.setColumns(10);
		
		JButton btnAdd = new JButton("AÑADIR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Añadir
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(84, 349, 131, 34);
		contentPane.add(btnAdd);
		
		JList listUsuario = new JList();
		listUsuario.setBounds(318, 97, 321, 219);
		contentPane.add(listUsuario);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Eliminar
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(415, 349, 131, 34);
		contentPane.add(btnEliminar);
	}
}
