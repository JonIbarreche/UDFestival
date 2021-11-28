package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PackAhorroWindow extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtIdTicket;
	private JTextField txtConcierto;
	private JTextField txtSesion;
	private JTextField txtArtista;
	private JTextField txtUrl;

	/**
	 * Create the frame.
	 */
	public PackAhorroWindow() {
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 13, 46, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Comprar Pack Ahorro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblNewLabel_1.setBounds(180, 13, 380, 57);
		contentPane.add(lblNewLabel_1);
		
		txtIdTicket = new JTextField();
		txtIdTicket.setText("IdPackAhorro");
		txtIdTicket.setBounds(86, 107, 163, 22);
		contentPane.add(txtIdTicket);
		txtIdTicket.setColumns(10);
		
		txtConcierto = new JTextField();
		txtConcierto.setText("Nombre");
		txtConcierto.setBounds(86, 159, 163, 22);
		contentPane.add(txtConcierto);
		txtConcierto.setColumns(10);
		
		txtSesion = new JTextField();
		txtSesion.setText("Descripcion");
		txtSesion.setBounds(86, 211, 163, 22);
		contentPane.add(txtSesion);
		txtSesion.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setText("Precio");
		txtArtista.setColumns(10);
		txtArtista.setBounds(86, 263, 163, 22);
		contentPane.add(txtArtista);
		
		txtUrl = new JTextField();
		txtUrl.setText("Url PackAhorro");
		txtUrl.setColumns(10);
		txtUrl.setBounds(86, 315, 163, 22);
		contentPane.add(txtUrl);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(86, 382, 163, 46);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(354, 107, 300, 250);
		contentPane.add(list);
		
		JButton btnEl = new JButton("Eliminar");
		btnEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEl.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEl.setBounds(487, 382, 164, 46);
		contentPane.add(btnEl);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setBounds(286, 382, 164, 46);
		contentPane.add(btnGuardar);

	}

}
