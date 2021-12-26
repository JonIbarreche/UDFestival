package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import bd.GestorBD;
import jdo.Usuario;
import bd.BDException;
import bd.GestorBD;
import org.apache.log4j.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroWindow extends JFrame {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre= new JTextField();
	private JTextField textFieldApodo = new JTextField();
	private JTextField textFieldMail = new JTextField();
	private JPasswordField textFieldContra = new JPasswordField();
	private JTextField textFieldNTelefono = new JTextField();
	private int phone;

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(BDException.class);
	private JTextField textFieldisAdmin;



	/**
	 * Create the frame.
	 */
	public RegistroWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblRegistro.setBounds(242, 38, 194, 74);
		contentPane.add(lblRegistro);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNombre.setBounds(48, 121, 129, 30);
		contentPane.add(lblNombre);
		
		JLabel lblApodo = new JLabel("APODO");
		lblApodo.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblApodo.setBounds(48, 172, 129, 30);
		contentPane.add(lblApodo);
		
		JLabel lblMail = new JLabel("MAIL");
		lblMail.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblMail.setBounds(48, 225, 129, 30);
		contentPane.add(lblMail);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblContrasea.setBounds(48, 274, 129, 30);
		contentPane.add(lblContrasea);
		
		JLabel lblNumeroDeTelefono = new JLabel("NUMERO DE TELEFONO");
		lblNumeroDeTelefono.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNumeroDeTelefono.setBounds(48, 317, 173, 30);
		contentPane.add(lblNumeroDeTelefono);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(221, 125, 255, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApodo = new JTextField();
		textFieldApodo.setBounds(221, 176, 255, 22);
		contentPane.add(textFieldApodo);
		textFieldApodo.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(221, 229, 255, 22);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		textFieldContra = new JPasswordField();
		textFieldContra.setBounds(221, 278, 255, 22);
		contentPane.add(textFieldContra);
		textFieldContra.setColumns(10);
		
		textFieldNTelefono = new JTextField();
		textFieldNTelefono.setBounds(221, 321, 255, 22);
		contentPane.add(textFieldNTelefono);
		textFieldNTelefono.setColumns(10);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				dispose();
			}
		});
		btnSalir.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnSalir.setBounds(148, 405, 147, 48);
		contentPane.add(btnSalir);
		
		JButton btnRegistrase = new JButton("REGISTRASE");
		btnRegistrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Añadir BD a registro de Usuario
				String nom = textFieldNombre.getText();
				String apo = textFieldApodo.getText();
				String mail = textFieldMail.getText();
				String con = textFieldContra.getText();
				int tf = Integer.parseInt(textFieldNTelefono.getText());
				int isAdmin = Integer.parseInt(textFieldisAdmin.getText());
				
				
				Usuario u = new Usuario(0,nom, apo, mail, con, tf, isAdmin);
				
				try {
					GestorBD.guardarUsuario(u);
					JOptionPane.showMessageDialog(null, "Los datos se han registrado correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
				} catch (BDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//GestorBD.insertarUsuario(nom, apo, mail, con, tf);
				dispose();
			}
		});
		btnRegistrase.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnRegistrase.setBounds(362, 405, 147, 48);
		contentPane.add(btnRegistrase);
		
		JLabel label = new JLabel("<-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginWindow lww = new LoginWindow();
				lww.setVisible(true);
				dispose();
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(12, 13, 42, 22);
		contentPane.add(label);
		
		JLabel lblIsadmin = new JLabel("isAdmin");
		lblIsadmin.setBounds(48, 360, 110, 16);
		contentPane.add(lblIsadmin);
		
		textFieldisAdmin = new JTextField();
		textFieldisAdmin.setBounds(221, 356, 255, 22);
		contentPane.add(textFieldisAdmin);
		textFieldisAdmin.setColumns(10);
	}
	
	/*
	 * Crear Usuario en la BD (conectar a BD)
	 */
	
	public void registro(JTextField textFieldNTelefono, JTextField textFieldNombre, JTextField textFieldApodo,
			JTextField textFieldMail, JPasswordField textFieldContra) {
		
		phone = Integer.parseInt(textFieldNTelefono.getText().toString());
		System.out.println("--------------------------");
		System.out.println("Añadiendo usuario en la BD");
		try {
			//
			
			System.out.println("Añadido un nuevo usuario a la Base de Datos");
		} finally {
			// TODO: handle finally clause
		}
	}
}
