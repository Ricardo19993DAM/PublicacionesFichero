package profesoresFichero;
import java.io.*;
public class MyObjectOutputStream extends ObjectOutputStream {
	//Sobrescribimos el m�todo que crea la cabecera
	protected void writeStreamHeader() throws IOException
	{
		// No hacer nada.
	}
	//Constructores
	public MyObjectOutputStream () throws IOException{
		super();
	}
	public MyObjectOutputStream(OutputStream out) throws IOException
	{
		super(out);
	}
}