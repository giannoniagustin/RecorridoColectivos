package filtros;

import grafo.Punto;

public abstract class FiltroSimple extends Filtro {
	
	protected Punto punto;
	
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	public abstract Object getAtributo();
	
	

}
