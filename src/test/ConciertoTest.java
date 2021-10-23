package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Concierto;

public class ConciertoTest {
	private Concierto c;
	
	@Before
	public void setup() {
		c = new Concierto(5, "CTangana", "Evento Especial", 100, "url");
	}
	@Test
	public void testSetGetId() {
		c.setId(5);
		assertEquals(5, c.getId());
	}
	@Test
	public void testSetGetArtista() {
		c.setArtista("CTangana");
		assertEquals("Ctangana", c.getArtista());
	}
	@Test
	public void testSetGetDescripcion() {
		c.setDescripcion("Evento Especial");
		assertEquals("Evento Especial", c.getDescripcion());
	}
	@Test
	public void testSetGetCapacidad() {
		c.setCapacidad(100);
		assertEquals(100, c.getCapacidad());
	}
	@Test
	public void testSetGetUrl() {
		c.setUrl("url");
		assertEquals("url", c.getUrl());
	}
	
	@Test
	public void testToString() {
		assertEquals("CTangana " + "+" + "100", c.toString());
	}
}
