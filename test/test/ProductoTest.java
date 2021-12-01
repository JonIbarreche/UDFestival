/** \file 
 * Breve descripción de jdo ProductoTest.java. Oct 24, 2021
 */
package test;

import jdo.Producto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


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
	@Before
	public void setup() {
		p = new Producto(0, "nombre", "descripcion", 10, null);
	}
	
	/**
	 * Test para obtener el nombre de un Producto
	 *
	 */
	
	@Test
	public void testGetSetNombre() {
		p.setNombre("testNombre");
		assertEquals("testNombre", p.getNombre());
	}
	/**
	 * Test para obtener la descripcion de un Producto
	 *
	 */
	@Test
	public void testGetSetDescripcion() {
		p.setDescripcion("testDescripcion");
		assertEquals("testDescripcion", p.getDescripcion());
	}
	
	/**
	 * Test para obtener el precio de un Producto
	 *
	 */
	@Test
	public void testGetSetPrecio() {
		p.setPrecio(10);
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
		p.setUrl("url");
		assertEquals("url", p.getUrl());
	}
	/**
	 * Test para obtener el ToString de el Producto, saca un string con la
	 * estructura definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("nombre" + ": descripcion" + ", Precio: 10 |", p.toString());
	}

}
