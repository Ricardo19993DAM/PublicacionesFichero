package profesoresFichero;

import java.io.Serializable;
import java.time.LocalDate;

public class Articulo extends Publicacion implements Serializable{
	private String medio;

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public Articulo(LocalDate fechaPubli, String titulo, String medio) {
		super(fechaPubli, titulo);
		this.medio = medio;
	}

	public Articulo(LocalDate fechaPubli, String titulo) {
		super(fechaPubli, titulo);
	}

	public Articulo() {
		super();
	}
	public void setDatos() {
		super.setDatos();
		medio=Util.introducirCadena("Introduce el medio: ");
	}
}
