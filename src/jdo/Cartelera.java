package jdo;
import jdo.Concierto;

public class Cartelera {
	protected long id;
	protected String artista = null;
	protected String descripcion = null;
	protected int capacidad = -1;
	protected String url = null;
	
	public Cartelera(long id, String artista, String descripcion, int capacidad, String url) {
		super();
		this.id = id;
		this.artista = artista;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.url = url;
	}
	public Cartelera() {
		super();
		this.id = -1;
		this.id = -1;
		artista = "";
		descripcion = "";
		capacidad = -1;
		url = "";
	}
	public void setConciertoCartelera(Concierto ConciertoCartelera) {
		this.artista = ConciertoCartelera.getArtista();
		this.descripcion = ConciertoCartelera.getDescripcion();
		this.capacidad = ConciertoCartelera.getCapacidad();
		this.url = ConciertoCartelera.getUrl();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Cartelera [id=" + id + ", artista=" + artista + ", descripcion=" + descripcion + ", capacidad="
				+ capacidad + ", url=" + url + "]";
	}
	
	
}
