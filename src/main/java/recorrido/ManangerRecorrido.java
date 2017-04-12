package recorrido;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import archivo.ManangerArchivos;
import google.ApiGoogle;
import grafo.Grafo;
import parser.Parser;


public class ManangerRecorrido 
{
	public static final String RECORRIDO_505_A = "D:\\Google Drive\\Proyecto AsisTAn\\Colectivos\\";
	private static final String NOMBRE_RECORRIDO_505_A = "Recorrido505-AExportJson";
	Recorrido recorridoMarronA;
	ArrayList<Colectivo> colectivosMarron;
	 ApiGoogle apiGoogle;
	 ManangerArchivos mArchivos;
	 Parser parser;
	 
	
	public ManangerRecorrido(ApiGoogle apiGoogle, ManangerArchivos mArchivos, Parser parser) {
		super();
		this.apiGoogle = apiGoogle;
		this.mArchivos = mArchivos;
		this.parser = parser;
	}

	public void cargarRecorridos()
	{
		
		recorridoMarronA= new Recorrido(new Grafo(apiGoogle, mArchivos,RECORRIDO_505_A,NOMBRE_RECORRIDO_505_A), colectivosMarron);
		
		
	}
	
	public void procesarColectivos(String contenido, String linea)
	{
		 try {
	            ArrayList<Colectivo> coles =  new ArrayList<Colectivo>();
	            colectivosMarron=parser.parsearColectivos(contenido, linea);

	        } catch (Exception e) {
	           e.toString();
	        }
		
		
		
	}

}
