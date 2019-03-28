package profesoresFichero;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
	private String email;
	private String nombre;
	private String depart;
	ArrayList <Publicacion>publicaciones=new ArrayList <Publicacion>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	public Profesor(String email, String nombre, String depart, ArrayList<Publicacion> publicaciones) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.depart = depart;
		this.publicaciones = publicaciones;
	}
	public Profesor() {
		super();
	}
	public void setDatos(String ema) {
		email=ema;
		nombre=Util.introducirCadena("Introduce nombre: ");
		depart=Util.introducirCadena("Introduce departamento: ");
	}
	public void addPubli(Publicacion p) {
		publicaciones.add(p);
	}
	public int cuantasPubli() {
		return publicaciones.size();
	}
}
