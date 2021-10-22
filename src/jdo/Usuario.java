package jdo;

public class Usuario {
	protected long idUsuario;
	
	protected String nombre;
	protected String nickname;
	protected String mail;
	protected String password;
	protected int phoneNumber;
	
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
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", nickname=" + nickname + ", mail=" + mail
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
