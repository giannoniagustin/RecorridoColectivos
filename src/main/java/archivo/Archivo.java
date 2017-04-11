   package archivo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Archivo {
	
	private String nombre;
	private String path;
	private ManangerArchivos manangerArchivos;
	private File archivo;
	FileInputStream fstream;
	FileOutputStream fOutputStream;
	 BufferedReader buffer ;
	 DataInputStream entrada;

	public Archivo(String path, String nombre, ManangerArchivos manangerArchivos)
    {
        this.nombre = nombre;
        this.path = path;
        this.manangerArchivos=manangerArchivos;
        File dir = new File(path);
        dir.mkdirs();
        archivo = new File(dir, nombre+ManangerArchivos.EXTENSION_TXT);//Extension del archivo ponerla en el nombre del archivo
    }
	
	public void abrirArchivoLectura()
	{
		 // Abrimos el archivo
		try {
			fstream = new FileInputStream(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Creamos el objeto de entrada
         entrada = new DataInputStream(fstream);
        // Creamos el Buffer de Lectura
         buffer = new BufferedReader(new InputStreamReader(entrada));
				
	}
	public void abrirFlujoGrabado()
	{
	      try {
			fOutputStream = new FileOutputStream(archivo, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cerraFlujoGrabado()
	{
	      try {
			fOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void grabar(String linea)
	{
		
		try 
		{
			 fOutputStream.write(linea.getBytes(Charset.forName("UTF-8")));
			 fOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
		
	}
	public void cerrarEntradaLecturaArchivo()
	{
		
	    // Cerramos          el archivo
        try {
		    	entrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String proximaLinea()throws FileNotFoundException, IOException {

	       try{
	          
	           String strLinea;
	           // Leer el archivo linea por linea
	           if ((strLinea = buffer.readLine()) != null)   {
	               
	        	   return strLinea;
	              
	           }
	           else
	           {
	        	   this.cerrarEntradaLecturaArchivo();
	        	   return null;
	           }
	       
	
	       }catch (Exception e){ //Catch de excepciones
	           System.err.println("Ocurrio un error: " + e.getMessage());
	           return null;
	       }

	    }


}
