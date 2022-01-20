package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bd.BDException;
import bd.GestorBD;
import jdo.Concierto;
import jdo.Ticket;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TicketWindow extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtConcierto, txtPrecio, txtSesion, text4;
	  
	    public static final String[] columns = {
	        "IdTicket", "IdConcierto", "Precio", "Sesion"
	    };
	    private DefaultTableModel model = new DefaultTableModel(columns, 0);
	    private JTable table = new JTable(model);
	    private JPanel mainPanel = new JPanel();
	public TicketWindow() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		{
			setBounds(100, 100, 740, 500);
			setContentPane(mainPanel);
	        mainPanel.setBackground(new Color(135, 206, 235));
	        mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	          table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
	          @Override
	          public void valueChanged(ListSelectionEvent e) {
	                int i = table.getSelectedRow();
	                txtConcierto.setText((String)model.getValueAt(i, 0));
	                txtPrecio.setText((String)model.getValueAt(i, 1));
	                txtSesion.setText((String)model.getValueAt(i, 2));
	            }
	        });
	        mainPanel.setLayout(null);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(247, 93, 455, 225);
	        mainPanel.add(scrollPane);
	    	}
		JButton addButton = new JButton("Añadir");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addButton.setBounds(108, 387, 126, 38);
		mainPanel.add(addButton);
		JButton updateButton = new JButton("Guardar");
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateButton.setBounds(286, 387, 143, 38);
		mainPanel.add(updateButton);
		txtSesion = new JTextField();
		txtSesion.setText("Sesion");
		txtSesion.setBounds(35, 251, 151, 21);
		mainPanel.add(txtSesion);
		txtPrecio = new JTextField();
		txtPrecio.setText("Precio");
		txtPrecio.setBounds(35, 200, 151, 21);
		mainPanel.add(txtPrecio);
		txtConcierto = new JTextField();
		txtConcierto.setText("ConciertoId");
		txtConcierto.setBounds(35, 151, 151, 21);
		mainPanel.add(txtConcierto);
		
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
				model.addRow(registro);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(483, 387, 143, 38);
		mainPanel.add(btnEliminar);
		
		JLabel lblTiTulo = new JLabel("Comprar Tickets");
		lblTiTulo.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblTiTulo.setBounds(286, 27, 296, 44);
		mainPanel.add(lblTiTulo);
		
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
		lblNewLabel.setBounds(35, 27, 56, 38);
		mainPanel.add(lblNewLabel);
		
		
		    addButton.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
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
					
		            model.setRowCount(0);

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
		    				model.addRow(registro);
		    			}
		    		} catch (SQLException e2) {
		    			e2.printStackTrace();
		    		}
		         
		          txtConcierto.setText("IdConcierto");
		          txtPrecio.setText("Precio");
		          txtSesion.setText("Sesion");
		          model.fireTableDataChanged();
		        }
		    });
	    }
	    public JComponent getComponent() {
	        return mainPanel;
	    }
	    public static void main(String[] args) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                JFrame f = new JFrame("Update a Row in JTable");
	                try {
						f.getContentPane().add(new TicketWindow().getComponent());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                f.setSize(340,250);
	                f.setLocationRelativeTo(null);
	                f.setVisible(true);
	            }
	        });
	    }
}