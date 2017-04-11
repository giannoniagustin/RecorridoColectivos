package recorrido;

import java.util.Date;

import grafo.Punto;

public class Colectivo extends Punto{

	private String idCole;
	private String Descripcion;
	private String nombreIcono;
	private String sentido;
	private Double velocidad;
	private Date tiempo;
	
	public Colectivo( Double latitude,
			Double longitude, String idCole,String descripcion,String nombreIcono,Double velocidad,Date tiempo,String sentido) 
	{
		super(null, null, -1, -1, -1, latitude, longitude);
		
		this.idCole=idCole;
		this.Descripcion=descripcion;
		this.nombreIcono=nombreIcono;
		this.sentido=sentido;
		this.tiempo=tiempo;
		this.velocidad=velocidad;
		// TODO Auto-generated constructor stub
	}
	  

}
