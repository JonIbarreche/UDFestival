package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaFotos extends JFrame  {
	
	
	private JPanel contentPane;
	
	
	
	public VentanaFotos() {
		
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblTusFotos = new JLabel("EXPERIENCIAS");
		lblTusFotos.setFont(new Font("Rockwell", Font.BOLD, 33));
		contentPane.add(lblTusFotos);
		
		JLabel label = new JLabel("<-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalWindow pw = new PrincipalWindow();
				pw.setVisible(true);
				dispose();
			}
		});
		
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(label);
		
		
		
		
		JPanel panelSur = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		
		JButton btnSubirFotos = new JButton("COMPARTE TUS EXPERIENCIAS");
		panelSur.add(btnSubirFotos);
		
		JPanel panelCentro = new JPanel();
		flowLayout.setAlignment(FlowLayout.CENTER);
		contentPane.add(panelSur, BorderLayout.CENTER);
		
		JLabel lblFoto = new JLabel("");
		panelCentro.add(lblFoto);
		
		
		
		
		
		btnSubirFotos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser("fotos"); //Objeto que me va a permitir seleccionar un fichero
				/*
				 * fotos es la carpeta creada dentro de mi proyecto donde estar�n las fotos a cargar
				 * */
				int sel = fc.showOpenDialog(null); //Abre la ventana de selecci�n de fichero
				if(sel == JFileChooser.APPROVE_OPTION) { //Si ha seleccionado abrir
					File ficheroSeleccionado = fc.getSelectedFile();
					//String nomfich = ficheroSeleccionado.getName();
					//ImageIcon im = new ImageIcon("fotos/"+nomfich);
					ImageIcon im = new ImageIcon(ficheroSeleccionado.getAbsolutePath());
					im.setDescription(ficheroSeleccionado.getAbsolutePath());
					lblFoto.setIcon(im);
				}
				
			}
		});
		
		setVisible(true);
	}
	
	
	
	
	
	

}