package grafo;



import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;

public abstract class ZonaPunto {

	private Punto Punto;
	

	public ZonaPunto(Punto Punto) {
		super();
		this.Punto = Punto;
	}

	public Punto getPunto(){
		return Punto;
	}
	public void setPunto(Punto c){
		this.setPunto(c);
	}
	
	public abstract Geometry cortaRuta(LineString camino);//ver si retorna String
	
}
	

