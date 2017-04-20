package grafo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

import filtros.Filtro;
import filtros.FiltroAlturaIgual;
import filtros.FiltroAlturaMayor;
import filtros.FiltroAlturaMenor;
import filtros.FiltroAnd;
import filtros.FiltroCalleIgual;
import filtros.FiltroOr;
import parser.Parser;
import recorrido.Recorrido;



public class Trayecto extends ElementoUbicacion {
	ArrayList<Punto> puntos;
	Double largo;
	Double duracion;
	Parser parser;
	
	
	
	public Trayecto() {
		super();
		this.parser= new Parser();
	}


	public ArrayList<Punto> getPuntos() {
		return puntos;
	}


	public void setPuntos(ArrayList<Punto> puntos) {
		this.puntos = puntos;
	}


	public Double getDuracion() {
		return duracion;
	}


	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}


	public Trayecto(ArrayList<Punto> puntos, Double largo, Double duracion) {
		super();
		this.puntos = puntos;
		this.largo = largo;
		this.duracion = duracion;
		this.parser= new Parser();
	}


	private long calcularLargo()
	{
	  	long largoParcial=0;
		for (int i=0;i < puntos.size()-1;i++)
		{
		   largoParcial+=puntos.get(i).distancia(puntos.get(i+1));
		}
		
		return largoParcial;
	}
	public Double getLargo() {
		return largo;
	}


	public void setLargo(Double largo) {
		this.largo = largo;
	}


	public void agregarPunto(Punto punto)
	{
		puntos.add(punto);

	}

/*	public boolean peretenece (Punto punto)
	{
		Punto pComienzo= puntos.get(0);
		Punto pFin = puntos.get(puntos.size()-1);
		ComparadorPuntoCalle comparadorCalle= new ComparadorPuntoCalle();
		ComparadorPuntoAltura comparadorAltura= new ComparadorPuntoAltura();
		
		int calle=comparadorCalle.compare(pComienzo, pFin);
		int alturMenor=comparadorAltura.compare(pComienzo, punto);
		int alturamayor=comparadorAltura.compare(pFin, punto);
		int alturaIgual1=comparadorAltura.compare(pComienzo, punto);
		int alturaIgual2=comparadorAltura.compare(pFin, punto);
		
		if ( (comparadorCalle.compare(pComienzo, pFin)== 0) &&
				((comparadorAltura.compare(pComienzo, punto)==-1   && 
				comparadorAltura.compare(pFin, punto)==1)||( comparadorAltura.compare(pComienzo, punto)==0 ||comparadorAltura.compare(pFin, punto)==0 )))
		{
			return true;
			
		}
		return false;
		
	

		
		
	}*/




	@Override
	public boolean cumple(Filtro f) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		return "Trayecto [puntos=" + puntos + ", largo=" + largo + ", duracion=" + duracion + "]";
	}


	public boolean pertenece(Punto p)
	{
		ZonaPuntoCircular zonaPunto;
		zonaPunto = new ZonaPuntoCircular(p);
		Coordinate[] coordenadasRuta = parser.coordenadasRuta(puntos);			
		Geometry g;
		GeometryFactory factory = new GeometryFactory();
		LineString caminoNuevo = null;
		caminoNuevo = factory.createLineString(coordenadasRuta);
		g = zonaPunto.cortaRuta(caminoNuevo);	
		return (g.getNumPoints() > 0);
			
	}

}
