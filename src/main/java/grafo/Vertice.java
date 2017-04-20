package grafo;

public class Vertice {
	private Punto punto;
	private int orden;
	public Vertice(Punto punto, int orden) {
		super();
		this.punto = punto;
		this.orden = orden;
	}
	public Punto getPunto() {
		return punto;
	}
	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	@Override
	public String toString() {
		return "Vertice [punto=" + punto + ", orden=" + orden + "]";
	}
	

}
