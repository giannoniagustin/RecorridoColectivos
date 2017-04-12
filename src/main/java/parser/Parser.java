package parser;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import recorrido.Colectivo;

public class Parser {
	private static final Gson gson=new Gson();
	
	public ArrayList<Colectivo> parsearColectivos(String contenido, String linea)
	{
		ArrayList<Colectivo> coles=new ArrayList<Colectivo>();
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
                       		sentido,Integer.parseInt(ident));

                       coles.add(c1);
                   }
                   catch(Exception e){
                       e.printStackTrace();
                   }
               }
        
           }
		
		
		return coles;
	}

}
