package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Concierto;
import jdo.Cartelera;

public class CarteleraTest {

	private Cartelera c;
	private Concierto con;
	
	@Before 
	public void setup() {
		c = new Cartelera(5, "", "", 100, "");
		con = new Concierto(0, "artista", "descripcion", 100, "url");
		c = new Cartelera();
	}
	@Test
	public void testSetGetId() {
		c.setId(5);
		assertEquals(5, c.getId());
	}
	@Test
	public void testSetGetArtista() {
		c.setArtista("testArtista");
		assertEquals("testArtista", c.getArtista());
	}
	@Test
	public void testSetGetDescription() {
		c.setDescripcion("testDescripcion");
		assertEquals("testDescripcion", c.getDescripcion());
	}
	
	@Test
	public void testSetGetUrl() {
		c.setUrl("url");
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
