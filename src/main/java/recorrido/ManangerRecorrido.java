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
	public static final String NOMBRE_RECORRIDO_505_A_JSON = "Recorrido505-AExportJson";
	public static final String NOMBRE_RECORRIDO_505_A_PARADAS_JSON = "Recorrido505-AExportJsonParadas";
	public static final String NOMBRE_RECORRIDO_505_A_PARADAS = "Recorrido505-AParadas";
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
		recorridoMarronA= new Recorrido(new Grafo(apiGoogle, mArchivos,RECORRIDO_505_A,NOMBRE_RECORRIDO_505_A_PARADAS_JSON), colectivosMarron);	
	}
	
	public void procesarColectivos(String contenido, String linea)
	{
		 try 
		 {
	           colectivosMarron=this.parser.parsearColectivos(contenido, linea);
	            recorridoMarronA.setColectivos(colectivosMarron);
	            recorridoMarronA.trayectoColectivo();

	        } catch (Exception e) {
	           e.toString();
	        }
		
		
		
	}

}
