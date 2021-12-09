package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketWindow extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtIdTicket;
	private JTextField txtConcierto;
	private JTextField txtSesion;
	private JTextField txtArtista;
	private JTextField txtUrl;
	
	/**
	 * Create the frame.
	 */
	public TicketWindow() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Comprar Tickets");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblNewLabel_1.setBounds(220, 13, 300, 57);
		contentPane.add(lblNewLabel_1);
		
		txtIdTicket = new JTextField();
		txtIdTicket.setText("IdTicket");
		txtIdTicket.setBounds(86, 107, 163, 22);
		contentPane.add(txtIdTicket);
		txtIdTicket.setColumns(10);
		
		txtConcierto = new JTextField();
		txtConcierto.setText("Concierto");
		txtConcierto.setBounds(86, 159, 163, 22);
		contentPane.add(txtConcierto);
		txtConcierto.setColumns(10);
		
		txtSesion = new JTextField();
		txtSesion.setText("Sesion");
		txtSesion.setBounds(86, 211, 163, 22);
		contentPane.add(txtSesion);
		txtSesion.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setText("Artista");
		txtArtista.setColumns(10);
		txtArtista.setBounds(86, 263, 163, 22);
		contentPane.add(txtArtista);
		
		txtUrl = new JTextField();
		txtUrl.setText("Url Concierto");
		txtUrl.setColumns(10);
		txtUrl.setBounds(86, 315, 163, 22);
		contentPane.add(txtUrl);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Añadir 
				JOptionPane.showMessageDialog(null, "Los datos se han añadido correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(86, 382, 163, 46);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(354, 107, 300, 250);
		contentPane.add(list);
		
		JButton btnEl = new JButton("Eliminar");
		btnEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Eliminar
				JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnEl.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEl.setBounds(487, 382, 164, 46);
		contentPane.add(btnEl);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guardar
				JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", "Éxito en la operación",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setBounds(286, 382, 164, 46);
		contentPane.add(btnGuardar);
	}
}
