/** \file 
 * Breve descripción de Usuario jdo Usuario.java. Oct 23, 2021
 */
package jdo;

/**
 * @author jonib
 *
 */

/**
 * Clase base Usuario.
 *
 */
public class Usuario {
	protected long idUsuario;

	protected String nombre;
	protected String nickname;
	protected String mail;
	protected String password;
	protected int phoneNumber;

	/**
	 * Construir objeto Usuario con sus atributos correspondientes.
	 */
	public Usuario(long idUsuario, String nombre, String nickname, String mail, String password, int phoneNumber) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nickname = nickname;
		this.mail = mail;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public Usuario() {

	}

	/**
	 * Obtener el id de un Usuario
	 */
	public long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Establecer el id de un Usuario
	 */
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtener el nombre de un Usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establecer el nombre de un Usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener el apodo de un Usuario
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Establecer el apodo de un Usuario
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Obtener el email de un Usuario
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Establecer el email de un Usuario
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Obtener el password de un Usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establecer el password de un Usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtener el número de teléfono de un Usuario
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Establecer el número de teléfono de un Usuario
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * ToString del Usuario, saca un string con la estructura definida en el propio
	 * método.
	 */
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", nickname=" + nickname + ", mail=" + mail
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

}
