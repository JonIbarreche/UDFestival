package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;



public class ConsultaConciertosWindow extends JInternalFrame{
	private JPanel contentPane;
	private JTable tabla;
	
	public ConsultaConciertosWindow() {
		
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
		
		DefaultTableModel modeloTabla = new DefaultTableModel();
		Object[] cabeceras = {"ID","ARTISTA","DESCRIPCION","CAPACIDAD","URL"};
		modeloTabla.setColumnIdentifiers(cabeceras);
		/*
		 * for (Concierto c : GestorBD.obtenerDatosConcierto()) {
			String [] fila ==
			modeloTabla.addRow(fila);
			}
		
		 */
		
		
	}

}
