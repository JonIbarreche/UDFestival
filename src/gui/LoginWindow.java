package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import bd.BDException;
import bd.GestorBD;
import org.apache.log4j.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername1;
	private JPasswordField txtPassword1;
	private JLabel lblLoginMessage1 = new JLabel("");
	private static final Logger logger = LogManager.getLogger(BDException.class);

	
	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUdFestival = new JLabel("UD FESTIVAL");
		lblUdFestival.setFont(new Font("Cooper Black", Font.BOLD, 33));
		lblUdFestival.setBounds(189, 49, 273, 47);
		contentPane.add(lblUdFestival);
		
		JPanel panel = new JPanel();
		panel.setBounds(184, 130, 278, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername1 = new JTextField();
		txtUsername1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if (txtUsername1.getText().equals("Usuario")) {
					txtUsername1.setText("");
				} else {
					txtUsername1.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername1.getText().equals(""))
					txtUsername1.setText("Usuario");
			}
			
		});
		txtUsername1.setFont(new Font("Rockwell", Font.BOLD, 14));
		txtUsername1.setText("Usuario");
		txtUsername1.setBounds(26, 13, 224, 31);
		panel.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		JPanel lblIconPassword1 = new JPanel();
		lblIconPassword1.setBounds(184, 217, 278, 57);
		contentPane.add(lblIconPassword1);
		lblIconPassword1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(Color.RED);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setBounds(194, 287, 263, 22);
		contentPane.add(textPane);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if (txtPassword1.getText().equals("Contraseña")) {
					txtPassword1.setText("");
					txtPassword1.setEchoChar('\u25CF');
					
				} else {
					txtPassword1.selectAll();
					txtPassword1.setEchoChar('\u25CF');
				}

			
			}
			@Override
			public void focusLost(FocusEvent e) {

				if (txtPassword1.getText().equals("")) {
					txtPassword1.setText("Contraseña");
					txtPassword1.setEchoChar((char) 0);
				}
			
			}
		});
		txtPassword1.setBounds(26, 13, 221, 28);
		lblIconPassword1.add(txtPassword1);
		txtPassword1.setText("Contraseña");
		
		JButton btnRegister = new JButton("REGISTRARSE");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroWindow rw = new RegistroWindow();
				rw.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(89, 322, 173, 57);
		contentPane.add(btnRegister);
		
		JPanel pnlBtnLogin1 = new JPanel();
		pnlBtnLogin1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Login(txtPassword1, txtUsername1);
				String contra = txtPassword1.getText().toString();
				String usuario = txtUsername1.getText();
				String[] datosInicio = null;

				txtUsername1.setBackground(null);
				txtPassword1.setBackground(null);
				textPane.setVisible(false);
				if (txtUsername1.getText().equals("admin") && txtPassword1.getText().equals("admin")) {
					lblLoginMessage1.setText("");
					AdminWindow aw = new AdminWindow();
					aw.setVisible(true);
					dispose();
					// De momento dejamos este usuario para acceder desde LoginWindow a PrincipalWindow (hasta que añadamos la BD)
				} else {

					try {
						datosInicio = GestorBD.inicioSesion(usuario);
					} catch (BDException e1) {
						logger.error("Error al iniciar sesión debido a un problema en la BD", e1);
					}
					if (datosInicio != null) {
						String contrabd = datosInicio[0];
						boolean sesionIniciada = contrabd.equals(contra);

						if (sesionIniciada) {
							// Como Usuario
							logger.info("Sesión iniciada como " + usuario);
							lblLoginMessage1.setText("te has loggeado correctamente!");
							PrincipalWindow pw = new PrincipalWindow();
							pw.setVisible(true);
							dispose();
						} else {
							logger.warn("La contraseña introducida es incorrecta");
							textPane.setVisible(true);
							textPane.setText("Contraseña incorrecta.");
							txtPassword1.setBackground(Color.RED);
						}
					} else {
						logger.warn("El usuario introducido no existe");
						textPane.setVisible(true);
						textPane.setText("Usuario no encontrado");
						txtUsername1.setBackground(Color.RED);
					}

				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin1.setBackground(new Color(20, 30, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin1.setBackground(new Color(47, 79, 79));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin1.setBackground(new Color(60, 80, 90));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin1.setBackground(new Color(20, 30, 40));
			}
		});
		
		
		pnlBtnLogin1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBtnLogin1.setBackground(new Color(100, 149, 237));
		pnlBtnLogin1.setBounds(385, 322, 173, 57);
		contentPane.add(pnlBtnLogin1);
		pnlBtnLogin1.setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIniciarSesion.setBounds(38, 13, 106, 31);
		pnlBtnLogin1.add(lblIniciarSesion);
		
		JLabel lblGest = new JLabel("Entrar como Invitado");
		lblGest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalWindow pw = new PrincipalWindow();
				pw.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGest.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGest.setForeground(Color.BLUE);
			}
		});
		lblGest.setForeground(new Color(0, 0, 255));
		lblGest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGest.setBounds(257, 381, 127, 14);
		contentPane.add(lblGest);
		
		
	}
	/*
	 * Metodo para hacer login (no esta conectado a BD todavia)
	 * Añadir un else if que checkee si el usuario y contraseña de la BD son correctos y llevar a la ventana principal
	 * 
	 * 
	  
	public void Login(JPasswordField txtPassword1, JTextField txtUsername1) {
		if (txtUsername1.getText().equals("admin") && txtPassword1.getText().equals("admin")) {
			lblLoginMessage1.setText("");
			AdminWindow aw = new AdminWindow();
			aw.setVisible(true);
			dispose();
			// De momento dejamos este usuario para acceder desde LoginWindow a PrincipalWindow (hasta que añadamos la BD)
		}else if (txtUsername1.getText().equals("user") && txtPassword1.getText().equals("1234")) {
			lblLoginMessage1.setText("te has loggeado correctamente!");
			PrincipalWindow pw = new PrincipalWindow();
			pw.setVisible(true);
			dispose();
		}
		else if (txtUsername1.getText().equals("") || txtUsername1.getText().equals("Username")
				|| txtPassword1.getText().equals("") || txtPassword1.getText().equals("Password")) {
			lblLoginMessage1.setText("Por favor rellena los campos!");
		} else {
			lblLoginMessage1.setText("Usuario y contraseña no coinciden");
		}
	}
	*/
	
}
