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
	
	protected long id;
	protected Cartelera cartelera = null;
	protected Concierto concierto = null;
	protected long precio = -1;
	protected Date sesion = null;
	
	/**
	 * Construir objeto Ticket con sus atributos correspondientes.
	 */
	public Ticket(long id, Cartelera cartelera, Concierto concierto, long precio, Date sesion) {
		super();
		this.id = id;
		this.cartelera = cartelera;
		this.concierto = concierto;
		this.precio = precio;
		this.sesion = sesion;
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
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Obtener la Cartelera de un Ticket
	 */
	public Cartelera getCartelera() {
		return cartelera;
	}
	/**
	 * Establecer la Cartelera de un Ticket
	 */
	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
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
	public Date getSesion() {
		return sesion;
	}
	/**
	 * Establecer la sesion de un Ticket
	 */
	public void setSesion(Date sesion) {
		this.sesion = sesion;
	}
	/**
	 * ToString de El Ticket, saca un string con la estructura definida en el propio
	 * método.
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", cartelera=" + cartelera + ", concierto=" + concierto + ", precio=" + precio
				+ ", sesion=" + sesion + "]";
	}
	
	

}
