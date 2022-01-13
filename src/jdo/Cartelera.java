/** \file 
 * Breve descripción de Cartelera jdo Cartelera.java. Oct 23, 2021
 */
package jdo;

import jdo.Concierto;

/**
 * @author jonib
 *
 */
/**
 * Clase base Cartelera.
 *
 */
public class Cartelera {
	protected int id;
	protected String artista = null;
	protected String descripcion = null;
	protected int capacidad = -1;
	protected String url = null;

	/**
	 * Construir objeto Cartelera con sus atributos correspondientes.
	 */
	public Cartelera(int id, String artista, String descripcion, int capacidad, String url) {
		super();
		this.id = id;
		this.artista = artista;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.url = url;
	}

	public Cartelera() {
		super();
		this.id = -1;
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
	public void setConciertoCartelera(Concierto ConciertoCartelera) {
		this.artista = ConciertoCartelera.getArtista();
		this.descripcion = ConciertoCartelera.getDescripcion();
		this.capacidad = ConciertoCartelera.getCapacidad();
		this.url = ConciertoCartelera.getUrl();
	}

	/**
	 * Obtener el id de la Cartelera
	 */
	public long getId() {
		return id;
	}

	/**
	 * Establecer el id de la Cartelera
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtener el Artista de la Cartelera
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * Establecer el Artista de la Cartelera
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Obtener la descripcion de la Cartelera
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establecer la descripcion de la Cartelera
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtener la capacidad de la Cartelera
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establecer la capacidad de la Cartelera
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtener la url de la Cartelera
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establecer la url de la Cartelera
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ToString de la Cartelera, saca un string con la estructura definida en el
	 * propio método.
	 */
	@Override
	public String toString() {
		return "Cartelera [id=" + id + ", artista=" + artista + ", descripcion=" + descripcion + ", capacidad="
				+ capacidad + ", url=" + url + "]";
	}

}
