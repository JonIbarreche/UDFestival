/** \file 
 * Breve descripción de es.deusto.spq.jdo TicketTest.java. May 21, 2021
 */
package test;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
/**
 * Clase test Ticket
 *
 */
/**
 * @author jonib
 *
 */

import jdo.Cartelera;
import jdo.Concierto;
import jdo.Ticket;
public class TicketTest {
	private Ticket t;
	private Cartelera c;
	private Concierto con;
	private Calendar dfd;
	private Date dfd1;
	/**
	 * Metodo para construir objeto Pelicula y Cine con sus atributos
	 * correspondientes.
	 *
	 */
	@Before
	public void Setup() {
		c = new Cartelera(0, "artistaTest", "descripcionTest", 100, "urlTest");
		con = new Concierto(0, "artistaConcierto", "descripcionConcierto", 50, "urlConcierto");
		dfd = Calendar.getInstance();
		dfd.set(Calendar.YEAR, 2020);
		dfd.set(Calendar.MONTH, Calendar.NOVEMBER);
		dfd.set(Calendar.DAY_OF_MONTH, 20);
		dfd.set(Calendar.HOUR, 12);
		dfd.set(Calendar.MINUTE, 00);
		dfd.set(Calendar.SECOND, 00);
		dfd1 = dfd.getTime();
		
		t = new Ticket(0, c, con, 10, null);
	}
	/**
	 * Test para obtener el id de un Ticket
	 *
	 */
	@Test 
	public void testSetGetId() {
		t.setId(0);
		assertEquals(0, t.getId());
	}
	/**
	 * Test para obtener la cartelera de un ticket
	 */
	@Test
	public void testSetGetCartelera() {
		t.setCartelera(c);
		assertEquals(c, t.getCartelera());
	}
	/**
	 * Test para obtener el concierto de un ticket
	 */
	@Test
	public void testSetGetConcierto() {
		t.setConcierto(con);
		assertEquals(con, t.getCartelera());
	}
	/**
	 * Test para obtener el precio de un ticket
	 */
	@Test
	public void testSetGetPrecio() {
		t.setPrecio(0);
		assertEquals(0, t.getPrecio());
	}
	/**
	 * Test para obtener la sesion de un ticket
	 */
	@Test
	public void testSetGetSesion() {
		t.setSesion(dfd1);
		assertEquals(dfd1, t.getSesion());
	}
	/**
	 * Test para obtener el ToString de El Ticket, saca un string con la estructura
	 * definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("Ticket [id=0" + ", cartelera=" + c + ", concierto=" + con +
				 ", precio=" + 10 + ", sesion=" + null + "]", t.toString());
		
	}
}
