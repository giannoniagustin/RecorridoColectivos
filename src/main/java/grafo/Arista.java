package grafo;



public class Arista {

	int numero;
	Trayecto trayecto;
	public Arista(int numero, Trayecto trayecto) {
		super();
		this.numero = numero;
		this.trayecto = trayecto;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Trayecto getTrayecto() {
		return trayecto;
	}
	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	
}
