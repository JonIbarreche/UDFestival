package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import bd.GestorBD;





public class ConsultaConciertosWindow extends JInternalFrame{
	private JPanel contentPane, panelTabla;
	private JTable tablaConciertos;
	private DefaultTableModel modeloConciertos;
	
	
	
	public ConsultaConciertosWindow() {
		tablaConciertos = new JTable();
		add(new JScrollPane(tablaConciertos), BorderLayout.CENTER);
		modeloConciertos = new DefaultTableModel();
		
		
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
		
		tablaConciertos = new JTable();
		add(new JScrollPane(tablaConciertos), BorderLayout.CENTER);
		modeloConciertos = new DefaultTableModel();
		panelTabla = new JPanel();
		contentPane.add(panelTabla, BorderLayout.CENTER);
		Object[] cabeceras = {"ID","ARTISTA","DESCRIPCION","CAPACIDAD","URL"};
		modeloConciertos.setColumnIdentifiers(cabeceras);
		cargarModeloTabla();
		tablaConciertos = new JTable(modeloConciertos);
		panelTabla.add(tablaConciertos);
		
		private void cargarModeloTabla() {
			GestorBD.cargarConectarDriver();
			ArrayList<Concierto> a = GestorBD.obtenerDatosConcierto(con);
			BD.closeBD(con);
			for(Conncierto con: a) {
				String [] fila = {con.getId(),con.getArtista(),con.getDescripcion(),String.valueOf(con.getCapacidad()),con.getUrl()};
				modeloTabla.addRow(fila);
			}
		}
	
		/*
		 * for (Concierto c : GestorBD.obtenerDatosConcierto()) {
			String [] fila ==
			modeloTabla.addRow(fila);
			}
		
		 */
		
		
	}

}
