package recorrido;

import java.util.Date;

import grafo.Punto;

public class Colectivo extends Punto{

	public String getIdCole() {
		return idCole;
	}

	public void setIdCole(String idCole) {
		this.idCole = idCole;
	}

	public Integer getNroColectivo() {
		return nroColectivo;
	}

	public void setNroColectivo(Integer nroColectivo) {
		this.nroColectivo = nroColectivo;
	}

	private String idCole;
	private String Descripcion;
	private String nombreIcono;
	private String sentido;
	private Double velocidad;
	private Date tiempo;
	private Integer nroColectivo;
	
	public Colectivo( Double latitude,
			Double longitude, String idCole,String descripcion,String nombreIcono,Double velocidad,Date tiempo,String sentido,Integer nroColectivo) 
	{
		super(new Date(), latitude, longitude);
		
		this.idCole=idCole;
		this.Descripcion=descripcion;
		this.nombreIcono=nombreIcono;
		this.sentido=sentido;
		this.tiempo=tiempo;
		this.velocidad=velocidad;
		this.nroColectivo=nroColectivo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Colectivo [sentido=" + sentido + ", velocidad=" + velocidad + ", tiempo=" + tiempo + ", nroColectivo="
				+ nroColectivo + ", calle=" + calle + ", altura=" + altura + ", alturaInicio=" + alturaInicio
				+ ", alturaFin=" + alturaFin + ", coordenada=" + coordenada + "]";
	}
	  

}
