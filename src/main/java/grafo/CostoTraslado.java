package grafo;

public class CostoTraslado {
	Double distancia;
	Double tiempo;
	public CostoTraslado(Double distancia, Double tiempo) {
		super();
		this.distancia = distancia;
		this.tiempo = tiempo;
	}
	@Override
	public String toString() {
		return "CostoTraslado [distancia=" + distancia + ", tiempo=" + tiempo + "]";
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getTiempo() {
		return tiempo;
	}
	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

}
