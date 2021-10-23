/** \file 
 * Breve descripción de test UsuarioTest.java. Oct 23, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Usuario;

/**
 * @author jonib
 *
 */
/**
 * Clase test Usuario
 *
 */
public class UsuarioTest {
	private Usuario u;

	/**
	 * Metodo para construir objeto Usuario con sus atributos correspondientes.
	 *
	 */
	@Before
	public void setUp() {
		u = new Usuario(0, "name", "nickname", "mail", "password", 99);
	}

	/**
	 * Test para obtener el id de un Usuario
	 *
	 */
	@Test
	public void testSetGetId() {
		u.setIdUsuario(0);
		assertEquals(0, u.getIdUsuario());
	}

	/**
	 * Test para obtener el nombre de un Usuario
	 *
	 */
	@Test
	public void testSetGetName() {
		u.setNombre("testNombre");
		assertEquals("testNombre", u.getNombre());
	}

	/**
	 * Test para obtener el apodo de un Usuario
	 *
	 */
	@Test
	public void testSetGetNickname() {
		u.setNickname("testNickname");
		assertEquals("testNickname", u.getNickname());
	}

	/**
	 * Test para obtener el email de un Usuario
	 *
	 */
	@Test
	public void testSetGetMail() {
		u.setMail("testMail");
		assertEquals("testMail", u.getMail());
	}

	/**
	 * Test para obtener el password de un Usuario
	 *
	 */
	@Test
	public void testSetGetPassword() {
		u.setPassword("testPassword");
		assertEquals("testPassword", u.getPassword());
	}

	/**
	 * Test para obtener el numero de telefono de un Usuario
	 *
	 */
	@Test
	public void testSetGetPhoneNumber() {
		u.setPhoneNumber(0);
		assertEquals(0, u.getPhoneNumber());
	}

	/**
	 * Test para obtener el ToString del Usuario, saca un string con la estructura
	 * definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("Id = " + "0" + "User: Nombre = " + "name" + "| Username = " + "nickname" + "| Mail = " + "mail"
				+ "| Teléfono = " + "99", u.toString());

	}
}
