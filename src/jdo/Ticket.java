/** \file 
 * Breve descripción de Ticket jdo Ticket.java. Oct 30, 2021
 */
package jdo;

import java.util.Date;

/**
 * @author jonib
 *
 */
/**
 * Clase base Ticket.
 *
 */
public class Ticket {
	
	protected int id;
	protected Concierto concierto = null;
	protected long precio = -1;
	protected String sesion = null;
	
	/**
	 * Construir objeto Ticket con sus atributos correspondientes.
	 */
	public Ticket(int id, Concierto concierto, long precio, String sesion) {
		super();
		this.id = id;
		this.concierto = concierto;
		this.precio = precio;
		this.sesion = sesion;
	}
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Obtener el Id de un Ticket
	 */
	public long getId() {
		return id;
	}
	/**
	 * Establecer el Id de un Ticket
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtener el Concierto de un Ticket
	 */
	public Concierto getConcierto() {
		return concierto;
	}
	/**
	 * Establecer el Concierto de un Ticket
	 */
	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}
	/**
	 * Obtener el precio de un Ticket
	 */
	public long getPrecio() {
		return precio;
	}
	/**
	 * Establecer el precio de un Ticket
	 */
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	/**
	 * Obtener la sesion de un Ticket
	 */
	public String getSesion() {
		return sesion;
	}
	/**
	 * Establecer la sesion de un Ticket
	 */
	public void setSesion(String sesion) {
		this.sesion = sesion;
	}
	/**
	 * ToString de El Ticket, saca un string con la estructura definida en el propio
	 * método.
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", concierto=" + concierto + ", precio=" + precio
				+ ", sesion=" + sesion + "]";
	}
	
	

}
