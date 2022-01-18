/** \file 
 * Breve descripción de jdo InventarioTest.java. Oct 24, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import jdo.Inventario;
import jdo.Producto;

/**
 * @author jonib
 *
 */
/**
 * Clase test Inventario.
 *
 */
public class InventarioTest {
	private Inventario i;
	private Set<Producto> productos;
	private Producto p;
	
	/**
	 * Metodo para construir objeto Inventario con sus atributos correspondientes. Y
	 * construir objeto Producto con sus atributos correspondientes.
	 */
	@Before
	public void setup() {
		i = new Inventario("nombre");
		productos = new HashSet<Producto>();
		p = new Producto(0, "TestNombre", "TestDescripcion", 10, null);
		productos.add(p);
	}
	/**
	 * Test para establecer el nombre de un Inventario
	 *
	 */
	@Test
	public void testSetGetNombre() {
		i.setNombre("TestNombre");
		assertEquals("TestNombre", i.getNombre());
	}
	/**
	 * Test para obtener el tamaño de los productos
	 *
	 */
	@Test
	public void testSetGetProductos() {
		assertEquals(productos.size(), 1);
	}
	/**
	 * Test para obtener el ToString del Inventario, saca un string con la
	 * estructura definida en el propio método.
	 *
	 
	@Test
	public void testToString() {
		assertEquals("Inventario + nombre", i.toString());
	}*/
}
