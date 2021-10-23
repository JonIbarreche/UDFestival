/** \file 
 * Breve descripción de Concierto jdo Concierto.java. Oct 23, 2021
 */
package jdo;

import jdo.Cartelera;

/**
 * @author jonib
 *
 */
/**
 * Clase base Concierto.
 *
 */
public class Concierto {
	protected long id;
	protected String artista = null;
	protected String descripcion = null;
	protected int capacidad = -1;
	protected String url = null;

	/**
	 * Construir objeto Concierto con sus atributos correspondientes.
	 */
	public Concierto(long id, String artista, String descripcion, int capacidad, String url) {
		super();
		this.id = id;
		this.artista = artista;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.url = url;
	}

	public Concierto() {
		super();
		this.id = -1;
		artista = "";
		descripcion = "";
		capacidad = -1;
		url = "";
	}

	/**
	 * Establecer un Concierto en una Cartelera
	 *
	 */
	public Concierto(Cartelera c) {
		this.artista = c.getArtista();
		this.descripcion = c.getDescripcion();
		this.capacidad = c.getCapacidad();
		this.url = c.getUrl();

	}

	/**
	 * Obtener el id del Concierto
	 */
	public long getId() {
		return id;
	}

	/**
	 * Establecer el id del Concierto
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtener el Artista del Concierto
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * Establecer el Artista del Concierto
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Obtener la descripcion del Concierto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establecer la descripcion del Concierto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtener la capacidad del Concierto
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establecer la capacidad del Concierto
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtener el url del Concierto
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establecer el url del Concierto
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ToString del Concierto, saca un string con la estructura definida en el
	 * propio método.
	 */
	@Override
	public String toString() {
		return artista + "" + "+" + capacidad + "";
	}

}
