/** \file 
 * Breve descripción de Administrador jdo Administrador.java. Oct 23, 2021
 */
package jdo;

/**
 * @author jonib
 *
 */
/**
 * Clase base Administrador.
 *
 */
public class Administrador extends Usuario {
	protected long id;
	protected int nivel;

	/**
	 * Construir objeto Administrador con sus atributos correspondientes.
	 */
	public Administrador(long idUsuario, String nombre, String nickname, String mail, String password, int phoneNumber,
			long id, int nivel) {
		super(idUsuario, nombre, nickname, mail, password, phoneNumber);
		this.id = id;
		this.nivel = nivel;
	}

	/**
	 * Obtener el id de un Administrador
	 */
	public long getId() {
		return id;
	}

	/**
	 * Establecer el id de un Administrador
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtener el nivel de un Administrador
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Establecer el nivel de un Administrador
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * ToString del Administrador, saca un string con la estructura definida en el
	 * propio método.
	 */
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nivel=" + nivel + ", idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", nickname=" + nickname + ", mail=" + mail + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
