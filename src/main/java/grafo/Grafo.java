package grafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.model.LatLng;

import archivo.Archivo;
import archivo.ManangerArchivos;
import google.ApiGoogle;
import recorrido.ManangerRecorrido;


public class Grafo {
	private  DirectedGraph<Vertice, Arista> g;
	ArrayList<Vertice> vertices;
	ArrayList<Arista> aristas;
	ManangerArchivos mArchivo;
	String ubicacion;
	String nombre;
	ApiGoogle apiGoogle;
	
	public Grafo(ApiGoogle apiGoogle,ManangerArchivos mArcvhivos,String ubicacion,String nombre) {
		super();
		// TODO Auto-generated constructor stub
		g = new  DefaultDirectedGraph<Vertice, Arista>(Arista.class);
		this.apiGoogle=apiGoogle;
		this.mArchivo=mArcvhivos;
		vertices=new  ArrayList<>();
		aristas= new ArrayList<>();
		this.ubicacion=ubicacion;
		this.nombre=nombre;
	//	this.importarGrafo();
		
			
		/*
		mArchivo= mArcvhivos;
		
		Archivo arch= new Archivo("D:\\Google Drive\\Proyecto AsisTAn\\Colectivos\\", "Recorrido505-A", mArchivo);
		arch.abrirArchivoLectura();
		String linea;
		int orden=0;
		Vertice v=null;
		try {
			while    ((linea= arch.proximaLinea()) != null)
			{
				Punto p=api.direccion(new LatLng(Double.parseDouble(linea.split(",")[0]),Double.parseDouble(linea.split(",")[1])));		
				v=new Vertice(p, orden);
			 	vertices.add(v);
			 	g.addVertex(v);
			 	orden++;
			
			}
			
			Trayecto trayecto=null;
			for(int i=0; i < vertices.size()-1;i++)
			{
				trayecto=api.caminoEntrePuntos(vertices.elementAt(i).getPunto(), vertices.elementAt(i+1).getPunto());
				Arista arista= new Arista(i, trayecto);
				aristas.addElement(arista);		
				g.addEdge(vertices.elementAt(i), vertices.elementAt(i+1), arista);
							
			}
	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	*/
		
	}

	 public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	public void guardarGrafo()
	{
		Archivo archGrabar= new Archivo("D:\\Google Drive\\Proyecto AsisTAn\\Colectivos\\", "Recorrido505-AExportJsonParadas", mArchivo);
		archGrabar.abrirFlujoGrabado();
		Gson gson = new Gson();
		archGrabar.grabar("["+	gson .toJson(vertices)+","+"\n");
		archGrabar.grabar(gson.toJson(aristas)+"]");
		archGrabar.cerraFlujoGrabado();
		
	}
	public void importarGrafo()
	{
		Gson gson = new Gson();	
		Archivo archImpportar= new Archivo(ubicacion, nombre, mArchivo);
		archImpportar.abrirArchivoLectura();
		String lineaArch = null;	
		try 
		{
			lineaArch= 	archImpportar.proximaLinea();		
			Type listType = new TypeToken<ArrayList<Vertice>>(){}.getType();
			vertices= gson.fromJson(lineaArch, listType);
			lineaArch= 	archImpportar.proximaLinea();	
			listType = new TypeToken<ArrayList<Arista>>(){}.getType();
			aristas = gson.fromJson(lineaArch, listType);
			
			cargarEstructura();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	private void cargarEstructura()
	{
		for (int i =0;i < vertices.size();i++)
		{
			g.addVertex(vertices.get(i));
		}
         
		for(int i=0; i < vertices.size()-1;i++)
		{
			g.addEdge(vertices.get(i), vertices.get(i+1), aristas.get(i));						
		}
	
	}
	public void generarRecorrido()
	{
		
		Archivo arch= new Archivo(ManangerRecorrido.RECORRIDO_505_A, ManangerRecorrido.NOMBRE_RECORRIDO_505_A_PARADAS, mArchivo);
		arch.abrirArchivoLectura();
		String linea;
		int orden=0;
		Vertice v=null;
		try {
			while    ((linea= arch.proximaLinea()) != null)
			{
				Punto p=apiGoogle.direccion(new LatLng(Double.parseDouble(linea.split(",")[0]),Double.parseDouble(linea.split(",")[1])));		
				v=new Vertice(p, orden);
			 	vertices.add(v);
			 	g.addVertex(v);
			 	orden++;
			
			}
			
			Trayecto trayecto=null;
			for(int i=0; i < vertices.size()-1;i++)
			{
				trayecto=apiGoogle.caminoEntrePuntos(vertices.get(i).getPunto(), vertices.get(i+1).getPunto());
				Arista arista= new Arista(i, trayecto);
				aristas.add(arista);		
				g.addEdge(vertices.get(i), vertices.get(i+1), arista);
							
			}
	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public Arista getTrayecto(Punto p)
	{
		boolean encontro=false;
		for (int i=0; i < aristas.size() && !encontro;i++)
		{
			if (aristas.get(i).getTrayecto().pertenece(p))
			{
				encontro=true;
				return aristas.get(i);
				
			}
			
			
		}
	
		return null;
	}

	public Vertice proximoVertice(Arista arista) {
		// TODO Auto-generated method stub
		Vertice destino = g.getEdgeTarget(arista);
		return destino;
	}
	

}
