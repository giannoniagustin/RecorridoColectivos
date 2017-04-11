package recorrido;

import java.util.ArrayList;
import java.util.Date;

import archivo.ManangerArchivos;
import google.ApiGoogle;
import grafo.Grafo;


public class ManangerRecorrido {
	private static final String RECORRIDO_505_A = "D:\\Google Drive\\Proyecto AsisTAn\\Colectivos\\";
	private static final String NOMBRE_RECORRIDO_505_A = "Recorrido505-AExportJson";
	Recorrido recorridoMarronA;
	ArrayList<Colectivo> colectivosMarron;
	 ApiGoogle apiGoogle;
	 ManangerArchivos mArchivos;
	
	public void cargarRecorridos()
	{
		
		recorridoMarronA= new Recorrido(new Grafo(apiGoogle, mArchivos,RECORRIDO_505_A,NOMBRE_RECORRIDO_505_A), colectivosMarron);
		
		
	}
	
	public void procesarColectivos(String contenido, String linea)
	{
		 try {
	            ArrayList<Colectivo> coles =  new ArrayList<Colectivo>();
	          
	            if (contenido.contains("L.marker")){
	                String[] colectivos = contenido.split("L.marker");

	                for (int i = 1; i < colectivos.length; i++){
	                    try{
	                        String coordenadas = colectivos[i].split("\\]")[0];
	                        coordenadas = coordenadas.replace("([", "");
	                        coordenadas = coordenadas.replace(" ","");
	                        String datos = colectivos[i].split("title: \\'\\[")[1];
	                        String ident = datos.split("]")[0];
	                        String time = datos.split(" ")[1];
	                        String vel = datos.split(" ")[2].replace("K/h", "");
	                    /*    Colectivo c1 = new Colectivo(ident,
	                                Double.parseDouble(coordenadas.split(",")[0]),
	                                Double.parseDouble(coordenadas.split(",")[1]),
	                                time,
	                                "Movil " + ident + " hora " + time + " Vel. " + vel,   // CAMBIAR
	                                linea        //Dependera del colectivoa  ver
	                                );*/
	                        String[] url=colectivos[i].split("iconUrl:")[1].split(",");
	                        String sentido=url[0].split("/")[6].split("-")[1].replaceAll(".png", "").replace("\"","" );
	                        Colectivo c1= new Colectivo(Double.parseDouble(coordenadas.split(",")[0]),
	                        		Double.parseDouble(coordenadas.split(",")[1]),
	                        		ident, linea, linea, Double.parseDouble(vel), new Date(),
	                        		sentido);

	                        coles.add(c1);
	                    }
	                    catch(Exception e){
	                        e.printStackTrace();
	                    }
	                }
	                //System.out.println("--------------------------------------------------------------");
	            }

         

	     
	        } catch (Exception e) {
	           e.toString();
	        }
		
		
		
	}

}
