package archivo;

public class ManangerArchivos {
	
	public static final String EXTENSION_TXT = ".txt";

	public Archivo crearArchivo(String nombre, String path)
	{
		
		return	new Archivo(path, nombre, this);
		
		
		
	}
	
	

}
