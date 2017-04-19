package grafo;



import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.util.GeometricShapeFactory;

public class ZonaPuntoCircular extends ZonaPunto{

	private GeometricShapeFactory gsf;
	private com.vividsolutions.jts.geom.Polygon circle;
	private LineString exteriorRing;
	
	public ZonaPuntoCircular(Punto punto /*,radio*/) {
		super(punto);
		gsf = new GeometricShapeFactory();
	    gsf.setCentre(new Coordinate(punto.getLatitude(),punto.getLongitude()));
		gsf.setSize(0.002);//RADIO 
		circle = gsf.createCircle();
		circle.setSRID( 6371);
		exteriorRing = circle.getExteriorRing();
	}

	@Override
	public Geometry cortaRuta(LineString camino) {
		return exteriorRing.intersection(camino);
		
	}

}
