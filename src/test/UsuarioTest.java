package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Usuario;

public class UsuarioTest {
	private Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario(0, "name", "nickname", "mail", "password", 99);
	}
	
	@Test
	public void testSetGetId() {
		u.setIdUsuario(0);
		assertEquals(0, u.getIdUsuario());
	}
	@Test
	public void testSetGetName() {
		u.setNombre("testNombre");
		assertEquals("testNombre", u.getNombre());
	}
	@Test
	public void testSetGetNickname() {
		u.setNickname("testNickname");
		assertEquals("testNickname", u.getNickname());
	}
	@Test
	public void testSetGetEmail() {
		u.setMail("testMail");
		assertEquals("testMail", u.getMail());
	}
	@Test
	public void testSetGetPassword() {
		u.setPassword("testPassword");
		assertEquals("testPassword", u.getPassword());
	}
	@Test
	public void testSetGetPhoneNumber() {
		u.setPhoneNumber(0);
		assertEquals(0, u.getPhoneNumber());
	}
	@Test
	public void testToString() {
		assertEquals("Id = "+ "0" +"User: Nombre = " + "name" + "| Username = " + "nickname" + "| Mail = " + "mail" + "| Teléfono = " + "99", u.toString());
		
	}
}
