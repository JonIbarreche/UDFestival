package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jdo.Administrador;

public class AdministradorTest {
	private Administrador a;
	
	@Before
	public void setUp() {
		a = new Administrador(0, "name", "nickname", "email", "password", 99, 0, 1);
	}
	
	@Test
	public void testSetGetId() {
		a.setId(0);
		assertEquals(0, a.getId());
	}
	
	@Test
	public void testSetGetNivel() {
		a.setNivel(0);
		assertEquals(0, a.getNivel());
	}
	@Test
	public void testToString() {
		assertEquals("Administrator [id=0" + ", nivel=1" + ", idUsuario=0" +", name=name" + ", nickname=nickname" + ", email=email"
				+ ", password=password" + ", phoneNumber=99" + "]", a.toString());
	}

}
