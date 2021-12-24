/** \file 
 * Breve descripción de test CarteleraTest.java. Oct 23, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdo.Concierto;
import jdo.Cartelera;

/**
 * @author jonib 
 *
 */
/**
 * Clase test Cartelera
 *
 */
public class CarteleraTest {

	private Cartelera c;
	private Concierto con;

	/**
	 * Metodo para construir objeto Cartelera con sus atributos correspondientes.
	 *
	 */
	@BeforeEach
	public void setup() {
		c = new Cartelera(5, "Jon", "descripcion cartelera", 60, "url");
		con = new Concierto(0, "artista", "descripcion", 100, "url");
	}

	/**
	 * Test para obtener el id de una Cartelera
	 *
	 */
	@Test
	public void testSetGetId() {
		assertEquals(5, c.getId());
	}

	/**
	 * Test para obtener el artista de una Cartelera
	 *
	 */
	@Test
	public void testSetGetArtista() {
		assertEquals("Jon", c.getArtista());
	}

	/**
	 * Test para obtener la descripcion de una Cartelera
	 *
	 */
	@Test
	public void testSetGetDescription() {
		assertEquals("descripcion cartelera", c.getDescripcion());
	}

	/**
	 * Test para obtener la capacidad de un Concierto
	 *
	 */
	@Test
	public void testSetGetCapacidad() {
		assertEquals(60, c.getCapacidad());
	}

	/**
	 * Test para obtener el url de una Cartelera
	 *
	 */
	@Test
	public void testSetGetUrl() {
		assertEquals("url", c.getUrl());
	}
	
	

	/**
	 * Test para anadir un concierto a la cartelera
	 *
	 */
	@Test
	public void testSetGetConciertoCartelera() {
		c.setConciertoCartelera(con);
		assertEquals(con.getArtista(), c.getArtista());
		assertEquals(con.getDescripcion(), c.getDescripcion());
		assertEquals(con.getCapacidad(), c.getCapacidad());
		assertEquals(con.getUrl(), c.getUrl());
	}
}
