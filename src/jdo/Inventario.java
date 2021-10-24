/** \file 
 * Breve descripción de jdo Inventario.java. Oct 24, 2021
 */
package jdo;

import java.util.HashSet;
import java.util.Set;
/**
 * @author jonib
 *
 */
/**
 * Clase base Inventario.
 *
 */
public class Inventario {
	protected String nombre = null;
	protected Set<Producto> productos = new HashSet<>();
	/**
	 * Construir objeto Inventario con sus atributos correspondientes.
	 */
	public Inventario(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtener el nombre de un Inventario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establecer el nombre de un Inventario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtener los productos de un Inventario
	 */
	public Set<Producto> getProductos() {
		return productos;
	}
	/**
	 * ToString del Inventario, saca un string con la estructura definida en el
	 * propio método.
	 */
	@Override
	public String toString() {
		return "Inventario" + nombre;
	}
	
}
