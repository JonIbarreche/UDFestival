package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminConciertoWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtArtista;
	private JTextField txtCapacidad;
	private JTextField txtUrl;
	private JList listConcierto;
	private JButton btnEliminar;

	

	/**
	 * Create the frame.
	 */
	public AdminConciertoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 510);
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
		
		txtArtista = new JTextField();
		txtArtista.setText("Artista");
		txtArtista.setBounds(86, 107, 163, 22);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setText("Capacidad");
		txtCapacidad.setBounds(86, 152, 163, 22);
		contentPane.add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.setText("Url Concierto");
		txtUrl.setBounds(86, 195, 163, 22);
		contentPane.add(txtUrl);
		txtUrl.setColumns(10);
		final JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				maxLengthdesc(txtDescripcion, e);
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		txtDescripcion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDescripcion.getText().equals("Descripción (max 255)")) {
					txtDescripcion.setText("");
				} else {
					txtDescripcion.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtDescripcion.getText().equals(""))
					txtDescripcion.setText("Descripción (max 255)");
			}
		});
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBorder(null);
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDescripcion.setText("Descripción (max 255)");
		txtDescripcion.setColumns(10);
		
		JScrollPane areaScrollPane = new JScrollPane(txtDescripcion);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setBounds(86, 230, 163, 143);
		contentPane.add(areaScrollPane);
		
		JButton btnAdd = new JButton("AÑADIR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//añadir
				JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(86, 386, 163, 43);
		contentPane.add(btnAdd);
		
		listConcierto = new JList();
		listConcierto.setBounds(337, 109, 303, 256);
		contentPane.add(listConcierto);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//eliminar Concierto
				JOptionPane.showMessageDialog(null, "Los datos se han eliminado correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(413, 384, 163, 45);
		contentPane.add(btnEliminar);
		
		JLabel lblUdfestival = new JLabel("UDFestival");
		lblUdfestival.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUdfestival.setForeground(Color.WHITE);
		lblUdfestival.setBounds(324, 434, 84, 16);
		contentPane.add(lblUdfestival);
	}
	
	/**
	 * metodo para el tamaño del texto de la descripcion
	 *
	 */
	public void maxLengthdesc(JTextArea txtDescripcion, KeyEvent e) {

		int max = 255;
		if (txtDescripcion.getText().length() > max + 1) {
			String shortened = txtDescripcion.getText().substring(0, max);
			txtDescripcion.setText(shortened);
			e.consume();
		} else if (txtDescripcion.getText().length() > max) {
			e.consume();
		}

	}
}
