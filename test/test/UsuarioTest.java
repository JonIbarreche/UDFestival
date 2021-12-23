/** \file 
 * Breve descripción de test UsuarioTest.java. Oct 23, 2021
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import jdo.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	private Usuario u1;

	/**
	 * Metodo para construir objeto Usuario con sus atributos correspondientes.
	 *
	 */
	@BeforeEach
	public void setUp() {
		u = new Usuario(0, "Jon", "Ibarreche", "jon@gmail.com", "1234", 9821, 0);
		u1 = new Usuario();
	}

	/**
	 * Test para obtener el id de un Usuario
	 *
	 */
	@Test
	public void testGetId() {
		assertEquals(0, u.getIdUsuario());
	}

	
	/**
	 * Test para obtener el nombre de un Usuario
	 *
	 */
	
	@Test
	public void testGetName() {
		assertEquals("Jon", u.getNombre());
	}

	/**
	 * Test para obtener el apodo de un Usuario
	 *
	 */
	@Test
	public void testSetGetNickname() {
		assertEquals("Ibarreche", u.getNickname());
	}

	/**
	 * Test para obtener el email de un Usuario
	 *
	 */
	@Test
	public void testSetGetMail() {
		assertEquals("jon@gmail.com", u.getMail());
	}

	/**
	 * Test para obtener el password de un Usuario
	 *
	 */
	@Test
	public void testSetGetPassword() {
		assertEquals("1234", u.getPassword());
	}

	/**
	 * Test para obtener el numero de telefono de un Usuario
	 *
	 */
	@Test
	public void testSetGetPhoneNumber() {
		assertEquals(9821, u.getPhoneNumber());
	}

	/**
	 * Test para obtener el ToString del Usuario, saca un string con la estructura
	 * definida en el propio método.
	 *
	 */
	@Test
	public void testToString() {
		assertEquals("Usuario [idUsuario=0, nombre=Jon, nickname=Ibarreche,"
				+ " mail=jon@gmail.com, password=1234, phoneNumber=9821, isAdmin=0]", u.toString());

	}
}
