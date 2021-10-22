package jdo;

public class Administrador extends Usuario {
	protected long id;
	protected int nivel;
	
	public Administrador(long idUsuario, String nombre, String nickname, String mail, String password, int phoneNumber,
			long id, int nivel) {
		super(idUsuario, nombre, nickname, mail, password, phoneNumber);
		this.id = id;
		this.nivel = nivel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nivel=" + nivel + ", idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", nickname=" + nickname + ", mail=" + mail + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	

}
