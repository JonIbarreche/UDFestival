/** \file 
 * Breve descripción de PedidoTest test PedidoTest.java. Oct 29, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;


import jdo.Cartelera;
import jdo.Concierto;
import jdo.Pedido;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author jonib
 *
 */
/**
 * Clase test Pedido.
 *
 */
import jdo.Producto;
public class PedidoTest {
	
	private Pedido p;
	private List<Producto> productos;
	//private List<Ticket> tickets;
	private Calendar dfd;
	private Date dfd1;
	//private Ticket ticket;
	private Producto producto;
	private Cartelera cartelera;
	private Concierto concierto;
	
	@BeforeEach
	public void setUp() {
		productos = new ArrayList<Producto>();
		//tickets = new ArrayList<Ticket>();
		dfd = Calendar.getInstance();
		dfd.set(Calendar.YEAR, 2020);
		dfd.set(Calendar.MONTH, Calendar.NOVEMBER);
		dfd.set(Calendar.DAY_OF_MONTH, 20);
		dfd.set(Calendar.HOUR, 12);
		dfd.set(Calendar.MINUTE, 00);
		dfd.set(Calendar.SECOND, 00);
		dfd1 = dfd.getTime();
		cartelera = new Cartelera(0, "artistaTest", "descripcionTest", 10, "urltest");
		concierto = new Concierto(0, "ctangana", "concierto", 100, "urlCtangana");
		//ticket = new Ticket();
		// Añadir en la lista de tickets el creado
		//tickets.add(ticket);
		producto = new Producto(0, "nombreTest", "descripcionTest", 10, "urlTest");
		productos.add(producto);
		p = new Pedido(0, "ugalde@gmail.com", dfd1, 1, "ticketsTest", productos.toString(), "En caja", 1);
		
	}
	/**
	 * Test para obtener el id de un Pedido
	 *
	 */
	@Test
	public void testSetGetId() {
		assertEquals(0, p.getId());
	}
	/**
	 * Test para obtener el email de un Pedido
	 *
	 */
	@Test
	public void testSetGetMail() {
		assertEquals("ugalde@gmail.com", p.getMail());
	}
	/**
	 * Test para obtener la fecha de un Pedido
	 *
	 */
	@Test
	public void testSetGetDate() {
		assertEquals(dfd1, p.getDate());
	}
	/**
	 * Test para obtener el precio de un Pedido
	 *
	 */
	@Test
	public void testSetGetPrice() {
		assertEquals(1, p.getPrecio());
	}
	
	/**
	 * Test para obtener los tickets de un Pedido
	 *
	 */
	
	// Pendiente
	
	/**
	 * Test para obtener los productos de un Pedido
	 *
	 */
	@Test
	public void testSetGetProducts() {
		assertEquals(productos.toString(), p.getProductos());
	}
	/**
	 * Test para obtener el metodo de pago de un Pedido
	 *
	 */
	@Test
	public void testSetGetPaymentMethod() {
		assertEquals("En caja", p.getMetodoPago());
	}
	/**
	 * Test para obtener el ToString del Pedido, saca un string con la estructura
	 * definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("PEDIDO CONFIRMADO" + " \r\n " + 
				"-------------------------------" + " \r\n " +
				"Id de pedido: " + "0" + " \r\n " + 
				"Fecha: " + dfd1 +  " \r\n " +
				"Tickets: " + "ticketsTest" + " \r\n " +
				"Productos: "+ productos + " \r\n " +
				"Método de pago: " + "En caja" + " \r\n " + 
				"Precio: " + "1", p.toString());

	}
	// Falta añadir jdo Ticket y TicketTest y despues rellenar esta 
	// clase con lo que falte de tickets
}
