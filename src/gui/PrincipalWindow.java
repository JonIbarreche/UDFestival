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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalWindow extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public PrincipalWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUdfestival = new JLabel("UDFestival");
		lblUdfestival.setHorizontalAlignment(SwingConstants.CENTER);
		lblUdfestival.setFont(new Font("Rockwell", Font.BOLD, 42));
		lblUdfestival.setBounds(250, 13, 240, 57);
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
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(36, 13, 46, 40);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Comprar Tickets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir a TicketWindow
				TicketWindow tw = new TicketWindow();
				tw.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton.setBounds(230, 100, 278, 50);
		contentPane.add(btnNewButton);
		
		JButton btnComprarPackAhorro = new JButton("Comprar Pack Ahorro");
		btnComprarPackAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir a TicketWindow
				TicketWindow tw = new TicketWindow();
				tw.setVisible(true);
				dispose();
			}
		});
		btnComprarPackAhorro.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnComprarPackAhorro.setBounds(230, 200, 278, 50);
		contentPane.add(btnComprarPackAhorro);
		
		JButton btnSubirFotos = new JButton("Comparte tus experiencias");
		btnSubirFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir a VentanaFotos
				VentanaFotos f = new VentanaFotos();
				f.setVisible(true);
				dispose();
			}
		});
		
		btnSubirFotos.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnSubirFotos.setBounds(230, 300, 278, 50);
		contentPane.add(btnSubirFotos);

	}
}
