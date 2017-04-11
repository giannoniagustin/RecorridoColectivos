package grafo;

import java.util.Date;

import com.google.maps.model.LatLng;

public class Punto {


    private Date fechaCreacion;
    private String calle;
    private Integer altura;
    private Integer alturaInicio;
    private Integer alturaFin;
    private LatLng coordenada;
    
    
	public Punto(Date fechaCreacion, String calle, int altura, int alturaIn, int alturaFin, Double latitude, Double longitude) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.calle = calle;
		this.altura = altura;
		this.alturaInicio=alturaIn;
		this.alturaFin=alturaFin;
		this.coordenada=new LatLng(latitude, longitude);
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Double getLatitude() {
		return coordenada.lat;
	}
	public void setLatitude(Double latitude) {
		this.coordenada.lat = latitude;
	}
	public Double getLongitude() {
		return coordenada.lng;
	}
	public void setLongitude(Double longitude) {
		this.coordenada.lng = longitude;
	}
	

	public LatLng getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(LatLng coordenada) {
		this.coordenada = coordenada;
	}
	public double distancia(Punto dest)
	{
		int earthRadius = 6371;
		double lat1 = this.coordenada.lat;
		double lon1 = this.coordenada.lng;
		double lat2 = dest.getLatitude();
		double lon2 = dest.getLongitude();
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = (Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2));
		double c = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
		double d = earthRadius * c * 1000;
		return d;
		
	}
	@Override
	public String toString() {
		return "calle=" + calle + ", altura=" + altura + ", alturaInicio="
				+ alturaInicio + ", alturaFin=" + alturaFin 
				+ ", coordenada=" + coordenada;
	}
	







}
