/** \file 
 * Breve descripción de jdo ProductoTest.java. Oct 24, 2021
 */
package test;

import jdo.Producto;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author jonib
 *
 */
/**
 * Clase test Producto
 *
 */
public class ProductoTest {
	private Producto p;
	
	/**
	 * Metodo para construir objeto Producto con sus atributos correspondientes.
	 *
	 */
	@BeforeEach
	public void setup() {
		p = new Producto(0, "nombre", "descripcion", 10, "url");
	}
	
	/**
	 * Test para obtener el nombre de un Producto
	 *
	 */
	
	@Test
	public void testGetSetNombre() {
		assertEquals("nombre", p.getNombre());
	}
	/**
	 * Test para obtener la descripcion de un Producto
	 *
	 */
	@Test
	public void testGetSetDescripcion() {
		assertEquals("descripcion", p.getDescripcion());
	}
	
	/**
	 * Test para obtener el precio de un Producto
	 *
	 */
	@Test
	public void testGetSetPrecio() {
		assertEquals(10, p.getPrecio());
	}
	
	/**
	 * Test para obtener el id de un Producto
	 *
	 */
	@Test
	public void testGetId() {
		assertEquals(0, p.getId());
	}
	
	/**
	 * Test para obtener la url de la imagen de un Producto
	 *
	 */
	@Test
	public void testSetGetUrl() {
		assertEquals("url", p.getUrl());
	}
	/**
	 * Test para obtener el ToString de el Producto, saca un string con la
	 * estructura definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("nombre" + ":descripcion" + ", Precio:10 |", p.toString());
	}

}
