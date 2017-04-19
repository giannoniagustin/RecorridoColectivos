package grafo;

import java.util.Date;

import com.google.maps.model.LatLng;

import filtros.Filtro;
import google.ApiGoogle;

public class Punto extends ElementoUbicacion {


    protected LatLng coordenada;
    
    
	public Punto(Date fechaCreacion, String calle, Integer altura, Integer alturaIn, Integer alturaFin, Double latitude, Double longitude) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.calle = calle;
		this.altura = altura;
		this.alturaInicio=alturaIn;
		this.alturaFin=alturaFin;
		this.coordenada=new LatLng(latitude, longitude);
	}
	public Integer getAlturaInicio() {
		return alturaInicio;
	}
	public void setAlturaInicio(Integer alturaInicio) {
		this.alturaInicio = alturaInicio;
	}
	public Integer getAlturaFin() {
		return alturaFin;
	}
	public void setAlturaFin(Integer alturaFin) {
		this.alturaFin = alturaFin;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Punto(Date fechaCreacion,Double latitude, Double longitude)// 
	{
		ApiGoogle apiGoogle= new ApiGoogle();
		this.fechaCreacion=fechaCreacion;
		this.coordenada=new LatLng(latitude, longitude);
		Punto p= apiGoogle.direccion(this.coordenada);
		this.calle= p.getCalle();
		this.altura=p.getAltura();
		this.alturaInicio=p.getAlturaInicio();
		this.alturaFin=p.getAlturaFin();
	
		
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
	@Override
	public boolean cumple(Filtro f) {
		// TODO Auto-generated method stub
		return f.cumple(this);
	}
	







}
