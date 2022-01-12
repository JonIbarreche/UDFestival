package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import bd.BDException;
import bd.GestorBD;
import jdo.Concierto;
import jdo.Ticket;
import jdo.Usuario;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TicketWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtConcierto;
	private JTextField txtPrecio;
	private JTextField txtSesion;
	private JTable table;
	
    private ArrayList<Ticket> listaTickets;
    private Ticket t;
    private DefaultTableModel modelo;
    
    
    
    private void verTickets() throws BDException, SQLException {
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		
		modelo.addColumn("IdTicket");
		modelo.addColumn("IdConcierto");
		modelo.addColumn("Precio");
		modelo.addColumn("Sesion");


		ResultSet rs = GestorBD.llenarTablaTickets();
		try {
			while (rs.next()) {
				Ticket t = new Ticket(); 
					
					Concierto c = new Concierto();
					c.setId((int) rs.getObject(2));
				
					t.setId((int) rs.getObject(1));
					t.setConcierto(c);
					t.setPrecio((int) rs.getObject(3));
					t.setSesion((String) rs.getObject(4));
					
					modelo.addRow( new Object[] { t.getId(), t.getConcierto().getId(), t.getPrecio(), t.getSesion() } );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 table.setModel( modelo );

	}
    
/*
    private void verTickets() throws SQLException {
        Vector<String> headers = new Vector<String>( Arrays.asList( "Id", "Concierto", "Precio", "Sesión" ) );
        modelo = new DefaultTableModel( 
            new Vector<Vector<Object>>(),
            headers 
        );
    
        ResultSet rs = null;
		try {
			rs = GestorBD.llenarTablaTickets();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				Object [] registro = new Object[4]; 

				for (int i=0; i < registro.length; i++) {
					registro[i] = rs.getObject(i+1);
				}
				modelo.addRow(registro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        for (Ticket t : listaTickets) {
        	modelo.addRow( new Object[] { t.getId(), t.getConcierto(), t.getPrecio(), t.getSesion() } );
        }
        
        table.setModel( modelo );
        // Pone tamaños a las columnas de la tabla
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(2).setMinWidth(60);
        table.getColumnModel().getColumn(2).setMaxWidth(60);
    }
*/
    
	public TicketWindow() {
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			verTickets();
		} catch (BDException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		
		
		JLabel lblNewLabel = new JLabel("<-");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalWindow pw = new PrincipalWindow();
				pw.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 13, 46, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Comprar Tickets");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 33));
		lblNewLabel_1.setBounds(220, 13, 300, 57);
		contentPane.add(lblNewLabel_1);
		
		txtConcierto = new JTextField();
		txtConcierto.setText("ConciertoId");
		txtConcierto.setBounds(86, 159, 163, 22);
		contentPane.add(txtConcierto);
		txtConcierto.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("Precio");
		txtPrecio.setBounds(86, 211, 163, 22);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtSesion = new JTextField();
		txtSesion.setText("Sesion");
		txtSesion.setColumns(10);
		txtSesion.setBounds(86, 263, 163, 22);
		contentPane.add(txtSesion);
		
		
		
		JButton btnNewButton = new JButton("AÃ±adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AÃ±adir 
				JOptionPane.showMessageDialog(null, "Los datos se han aÃ±adido correctamente", "Exito en la operacion",
						JOptionPane.INFORMATION_MESSAGE);

				int concierto = Integer.parseInt(txtConcierto.getText());
				long precio = Integer.parseInt(txtPrecio.getText());
				String sesion = txtSesion.getText();
				
				Concierto c = new Concierto();
				c.setId(concierto);
				Ticket t = new Ticket(0, c, precio, sesion);
				
 
				try {
					GestorBD.insertarTicket(t);
				} catch (BDException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(86, 382, 163, 46);
		contentPane.add(btnNewButton);
		
		JButton btnEl = new JButton("Eliminar");
		btnEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verTickets();
				} catch (BDException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", "Exito en la operacion",
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
				JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", "Exito en la operacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setBounds(286, 382, 164, 46);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(293, 86, 387, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
