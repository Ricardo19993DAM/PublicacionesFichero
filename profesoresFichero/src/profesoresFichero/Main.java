package profesoresFichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String fichero="profes4.dat";
		File fich=new File(fichero);
		int opc;
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta(fich);
				break;
			case 2:
				masPubli(fich);
				break;
			case 3:
				mostrarGalardonados(fich);
				break;
			case 4:
				listado(fich);
				break;
			case 5:
				listarProfes(fich);
				break;
			}
		}while(opc!=6);


	}

	private static int menu() {
		System.out.println("//////////M E N U//////////");
		System.out.println("\n1.- Nuevo profesor"
				+ "\n2.- Añadir publicacion"
				+ "\n3.- Libros galadornados"
				+ "\n4.- Lista por departamentos"
				+ "\n5.- Listado de profesores"
				+ "\n6.- Salir");
		return Util.leerInt(1,6);
	}

	private static void alta(File fich) {
		System.out.println("Introduce email");
		String auxEmail=Util.introducirCadena();
		if(comprobar(auxEmail)) {
			if(fich.exists()) {
				int cont=Util.calculoFichero(fich);
				if(!existe(fich,auxEmail,cont)) {
					Profesor auxProfesor=new Profesor();
					auxProfesor.setDatos(auxEmail);
					FileOutputStream fos=null;
					MyObjectOutputStream moos=null;
					try {
						fos = new FileOutputStream(fich,true);
						moos=new MyObjectOutputStream(fos);
						moos.writeObject(auxProfesor);
						moos.close();
						fos.close();
					} catch (IOException e) {
						System.out.println("Error IO e1");
					}
				}else {
					System.out.println("Ya existe");
				}

			}else {
				Profesor auxProfesor=new Profesor();
				auxProfesor.setDatos(auxEmail);
				FileOutputStream fos=null;
				ObjectOutputStream oos=null;
				try {
					fos = new FileOutputStream(fich);
					oos=new ObjectOutputStream(fos);
					oos.writeObject(auxProfesor);
					oos.close();
					fos.close();
				} catch (IOException e) {
					System.out.println("Error IO e2");
				}

			}
		}else {
			System.out.println("El email no es valido");
		}

	}

	private static boolean existe(File fich, String auxEmail,int cont) {
		boolean repe=false;
		Profesor profesores[]=generaArray(fich,cont);
		for(int i=0;i<cont;i++) {
			if(profesores[i].getEmail().equalsIgnoreCase(auxEmail)) {
				repe=true;
				break;
			}
		}
		return repe;
	}

	private static Profesor[] generaArray(File fich,int cont) {
		Profesor profesores[]=new Profesor[cont];
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream(fich);
			ois=new ObjectInputStream(fis);
			for(int i=0;i<cont;i++) {
				profesores[i]=(Profesor) ois.readObject();
			}
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error Class");
		}catch (IOException e) {
			System.out.println("Error IO");
		}
		return profesores;
	}

	private static boolean comprobar(String email) {
		String a,b,c;
		boolean valido=true;
		if(email.indexOf("@")>0 && email.substring(email.indexOf("@"),email.length()).indexOf(".")>0) {
			a=email.substring(0, email.indexOf("@")-1);
			for(int i=0;i<a.length();i++) {
				if(!(Character.isAlphabetic(a.charAt(i)) || Character.isDigit(a.charAt(i))||a.charAt(i)=='_'||a.charAt(i)=='.')) {
					valido=false;
				}
			}
			b=email.substring(email.indexOf("@")+1,email.indexOf(".")-1);
			for(int i=0;i<b.length();i++) {
				if(!(Character.isAlphabetic(b.charAt(i)))) {
					valido=false;
				}
			}
		}else {
			valido=false;
		}


		return valido;
	}

	private static void masPubli(File fich) {
		int cont = Util.calculoFichero(fich);
		ArrayList <Profesor>profesores=gererarArrayList(fich,cont);

	}

	private static ArrayList<Profesor> gererarArrayList(File fich, int cont) {
		ArrayList <Profesor> profesores = new ArrayList <Profesor>();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream(fich);
			ois=new ObjectInputStream(fis);
			for(int i=0;i<cont;i++) {
				profesores.add((Profesor) ois.readObject());
			}
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al generar la coleccion");
		}catch (IOException e) {
			System.out.println("Error al generar la coleccion");
		}
		return profesores;
	}

	private static void mostrarGalardonados(File fich) {
		// TODO Auto-generated method stub
		////asddasdsdaasdasdsadsadsa lolololol
	}

	private static void listado(File fich) {
		// TODO Auto-generated method stub

	}

	private static void listarProfes(File fich) {
		int cont=Util.calculoFichero(fich);
		Profesor profesores[]=generaArray(fich,cont);
		for(Profesor p:profesores) {
			System.out.println(p.getEmail()+" Nombre: "+p.getNombre()+" Depart: "+p.getDepart()+" Publicaciones: "+p.cuantasPubli());
		}

	}

}
