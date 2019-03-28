package profesoresFichero;

import java.io.Serializable;
import java.time.LocalDate;

public class Libro extends Publicacion implements Serializable{
	private String isbn;
	private boolean premiado;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isPremiado() {
		return premiado;
	}
	public void setPremiado(boolean premiado) {
		this.premiado = premiado;
	}
	public Libro(LocalDate fechaPubli, String titulo, String isbn, boolean premiado) {
		super(fechaPubli, titulo);
		this.isbn = isbn;
		this.premiado = premiado;
	}
	public Libro(LocalDate fechaPubli, String titulo) {
		super(fechaPubli, titulo);
	}
	
	public Libro() {
		super();
	}
	public void setDatos() {
		super.setDatos();
		isbn=Util.introducirCadena("Introduce ISBN: ");
		System.out.println("El libro esta premiado (S/N)? ");
		char opc=Util.respCharList("SN");
		if(opc=='S') {
			premiado=true;
		}else {
			premiado=false;
		}
	}
	public void getDatos() {
		super.getDatos();
		System.out.println("ISBN: "+isbn+" Premiado: "+((premiado)?"Si":"no"));
	}
}
