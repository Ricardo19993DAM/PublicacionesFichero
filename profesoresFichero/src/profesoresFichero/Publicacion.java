package profesoresFichero;

import java.io.Serializable;
import java.time.LocalDate;

public class Publicacion implements Serializable {
	protected LocalDate fechaPubli;
	protected String titulo;
	public LocalDate getFechaPubli() {
		return fechaPubli;
	}
	public void setFechaPubli(LocalDate fechaPubli) {
		this.fechaPubli = fechaPubli;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Publicacion(LocalDate fechaPubli, String titulo) {
		super();
		this.fechaPubli = fechaPubli;
		this.titulo = titulo;
	}
	public Publicacion() {
		super();
	}
	public void setDatos() {
		fechaPubli=Util.leerFecha("Introduce fecha de publicacion con formato (dd/mm/aaaa): ");
		titulo=Util.introducirCadena("Introduce titulo: ");
	}
	public void getDatos() {
		System.out.println(titulo+" publicado en"+fechaPubli.getDayOfMonth()+"/"+fechaPubli.getMonthValue()+"/"+fechaPubli.getYear());
		
	}
	
}
