/** \file 
 * Breve descripción de Pedido jdo Pedido.java. Oct 29, 2021
 */
package jdo;

import java.util.Date;

/**
 * @author jonib
 *
 */
/**
 * Clase base Pedido.
 *
 */
public class Pedido {
	
	protected long id;
	private String mail;
	private Date date;
	private int numeroTickets;
	private String tickets;
	private String productos;
	private String metodoPago;
	private long precio = -1;
	
	/**
	 * Construir objeto Pedido con sus atributos correspondientes.
	 */
	public Pedido(long id, String mail, Date date, int numeroTickets, String tickets, String productos,
			String metodoPago, long precio) {
		super();
		this.id = id;
		this.mail = mail;
		this.date = date;
		this.numeroTickets = numeroTickets;
		this.tickets = tickets;
		this.productos = productos;
		this.metodoPago = metodoPago;
		this.precio = precio;
	}

	/**
	 * Obtener el id de un Pedido
	 */
	public long getId() {
		return id;
	}
	/**
	 * Establecer el id de un Pedido
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
	/**
	 * Obtener el email de un Pedido
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * Establecer el email de un Pedido
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Obtener la fecha de un Pedido
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Establecer la fecha de un Pedido
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Obtener el número de tickets de un Pedido
	 */
	public int getNumeroTickets() {
		return numeroTickets;
	}
	/**
	 * Establecer el número de tickets de un Pedido
	 */
	public void setNumeroTickets(int numeroTickets) {
		this.numeroTickets = numeroTickets;
	}
	
	/**
	 * Obtener los tickets de un Pedido
	 */
	public String getTickets() {
		return tickets;
	}
	/**
	 * Establecer los tickets de un Pedido
	 */
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	/**
	 * Obtener los productos de un Pedido
	 */
	public String getProductos() {
		return productos;
	}
	/**
	 * Establecer los productos de un Pedido
	 */
	public void setProductos(String productos) {
		this.productos = productos;
	}
	
	/**
	 * Obtener el método de pago de un Pedido
	 */
	public String getMetodoPago() {
		return metodoPago;
	}
	/**
	 * Establecer el método de pago de un Pedido
	 */
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	/**
	 * Obtener el precio de un Pedido
	 */
	public long getPrecio() {
		return precio;
	}
	/**
	 * Establecer el precio de un Pedido
	 */
	public void setPrecio(long precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PEDIDO CONFIRMADO" + " \r\n " + 
				"-------------------------------" +" \r\n " +
				"Id de pedido: " + id + " \r\n " + 
				"Fecha: " + date +  " \r\n " +
				"Tickets: " + tickets + " \r\n " +
				"Productos: "+ productos + " \r\n " +
				"Método de pago: " + metodoPago + " \r\n " + 
				"Precio: " + precio;
	}
	
	
	
}
