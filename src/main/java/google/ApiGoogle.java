package google;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;

import grafo.Punto;
import grafo.Trayecto;

public class ApiGoogle {
	
	private static String clave_api="AIzaSyDkVC2m6GYsNlduZ3QPxs-Wk50Nm4FSlDI";
	private static String idioma="es-ES";
	private static String region="AR";
	private static String indefinida="-1";
	GeoApiContext context;

	public ApiGoogle() {
		super();
		// TODO Auto-generated constructor stub
		 context = new GeoApiContext();
				 context.setApiKey(clave_api);
	   
	}
	
	 public DistanceMatrix camino()
	{
		 try {
		        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
		        DistanceMatrix trix = req.origins("Tandil")
		                .destinations("Buenos Aires")
		                .transitModes(TransitMode.BUS)		                
		                .avoid(RouteRestriction.HIGHWAYS)
		                .language(idioma)
		                .await();
		      
		    	return trix;
		
		    } catch(ApiException e)
		 {
		    return null;     
		    } catch(Exception e){
		        System.out.println(e.getMessage());
		        return null;
		    }   
		
	
	}
	 public Punto direccion(LatLng coordenada)
	 {
		
		 AddressComponent[] componenteDireccion;
		 String[] altura;
		 String alturaInicio,alturaFin,calle;
		 
		 try 
		 {
			GeocodingResult[] results;
			results = GeocodingApi.reverseGeocode(context, coordenada).language(idioma).await();
	        
			componenteDireccion= 	results[0].addressComponents;
			if (componenteDireccion[0].longName.contains("-"))
			{
			altura= componenteDireccion[0].longName.split("-");
			alturaInicio=altura[0];
			alturaFin=altura[1];
			calle =componenteDireccion[1].longName;
			
			}
			else
			{
				alturaInicio=indefinida;
				alturaFin=indefinida;
				calle=componenteDireccion[0].longName;
																
			}
			
	
			Punto punto= new Punto(new Date(), calle, Integer.parseInt(alturaInicio), Integer.parseInt(alturaInicio),Integer.parseInt(alturaFin), coordenada.lat, coordenada.lng);
			return punto;
	
		 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		 
	 }
	 public Trayecto caminoEntrePuntos(Punto origen,Punto destino)
	 {
		 DirectionsApiRequest  request=DirectionsApi.newRequest(context);
		 try 
		 {
			DirectionsResult caminoResponse = request.origin(origen.getCoordenada()).destination(destino.getCoordenada()).transitMode(TransitMode.BUS).await();
		
			//Ruta
			DirectionsRoute[] rutas = caminoResponse.routes;
			EncodedPolyline rutasCodificada = rutas[0].overviewPolyline;
			List<LatLng> puntos = rutasCodificada.decodePath();
			Vector<Punto> camino=new Vector<>();
			for (int i=0;i < puntos.size();i++)
			{
				
				camino.add(new Punto(new Date(), null, -1, -1, -1, puntos.get(i).lat, puntos.get(i).lng));
			}
			//Tiempo en hacer ruta
			DirectionsLeg[] legs = rutas[0].legs;
			Distance distancia = legs[0].distance;
			Long metros = distancia.inMeters;
			Long tiempoSeg = legs[0].duration.inSeconds;
	       
			Trayecto trayecto= new Trayecto(camino,metros.doubleValue(), tiempoSeg.doubleValue());
	       
	       return trayecto;
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
		 
	 }
	
}
