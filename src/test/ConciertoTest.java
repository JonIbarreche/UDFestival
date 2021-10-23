/** \file 
 * Breve descripción de test ConciertoTest.java. Oct 23, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Concierto;

/**
 * @author jonib
 *
 */

/**
 * Clase test Concierto
 *
 */
public class ConciertoTest {
	private Concierto c;

	/**
	 * Metodo para construir objeto Concierto con sus atributos correspondientes.
	 *
	 */
	@Before
	public void setup() {
		c = new Concierto(5, "CTangana", "Evento Especial", 100, "url");
	}

	/**
	 * Test para obtener el id de un Concierto
	 *
	 */
	@Test
	public void testSetGetId() {
		c.setId(5);
		assertEquals(5, c.getId());
	}

	/**
	 * Test para obtener el artista de un Concierto
	 *
	 */
	@Test
	public void testSetGetArtista() {
		c.setArtista("CTangana");
		assertEquals("Ctangana", c.getArtista());
	}

	/**
	 * Test para obtener la descripcion de un Concierto
	 *
	 */
	@Test
	public void testSetGetDescripcion() {
		c.setDescripcion("Evento Especial");
		assertEquals("Evento Especial", c.getDescripcion());
	}

	/**
	 * Test para obtener la capacidad de un Concierto
	 *
	 */
	@Test
	public void testSetGetCapacidad() {
		c.setCapacidad(100);
		assertEquals(100, c.getCapacidad());
	}

	/**
	 * Test para obtener el url de un Concierto
	 *
	 */
	@Test
	public void testSetGetUrl() {
		c.setUrl("url");
		assertEquals("url", c.getUrl());
	}

	/**
	 * Test para obtener el ToString del Concierto, saca un string con la estructura
	 * definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("CTangana " + "+" + "100", c.toString());
	}
}
