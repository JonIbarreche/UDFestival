/** \file 
 * Breve descripción de jdo Producto.java. Oct 24, 2021
 */
package jdo;

/**
 * @author jonib
 *
 */
/**
 * Clase base Producto.
 *
 */
public class Producto {
	protected long id;

	protected String nombre = null;

	protected String descripcion = null;

	protected long precio = 0;

	protected String url = null;
	/**
	 * Construir objeto Producto con sus atributos correspondientes.
	 */
	public Producto(long id, String nombre, String descripcion, long precio, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.url = url;
	}
	/**
	 * Obtener el id de un Producto
	 */
	public long getId() {
		return id;
	}
	/**
	 * Establecer el id de un Producto
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Obtener el nombre de un Producto
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establecer la descripción de un Producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtener la descripcion de un Producto
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Establecer la descripcion de un Producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtener el precio de un Producto
	 */
	public long getPrecio() {
		return precio;
	}
	/**
	 * Establecer el precio de un Producto
	 */
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	/**
	 * Obtener la url de la imagen de un Producto
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Establecer la url de la imagen de un Producto
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return  nombre + ":" + descripcion + ", Precio:" + precio + " |";
	}
	
	
	
	
}
