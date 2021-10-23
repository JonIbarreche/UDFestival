/** \file 
 * Breve descripción de test AdministradorTest.java. Oct 23, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Administrador;

/**
 * @author jonib
 *
 */
/**
 * Clase test Administrador
 *
 */
public class AdministradorTest {
	private Administrador a;

	/**
	 * Metodo para construir objeto Administrador con sus atributos
	 * correspondientes.
	 *
	 */
	@Before
	public void setUp() {
		a = new Administrador(0, "name", "nickname", "email", "password", 99, 0, 1);
	}

	/**
	 * Test para obtener el id de un Administrador
	 *
	 */
	@Test
	public void testSetGetId() {
		a.setId(0);
		assertEquals(0, a.getId());
	}

	/**
	 * Test para obtener el nivel de un Administrador
	 *
	 */
	@Test
	public void testSetGetNivel() {
		a.setNivel(0);
		assertEquals(0, a.getNivel());
	}

	/**
	 * Test para obtener el ToString del Administrador, saca un string con la
	 * estructura definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("Administrator [id=0" + ", nivel=1" + ", idUsuario=0" + ", name=name" + ", nickname=nickname"
				+ ", email=email" + ", password=password" + ", phoneNumber=99" + "]", a.toString());
	}

}
