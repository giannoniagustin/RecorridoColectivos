package grafo;

public abstract class ComparadorPuntoCompuesto extends ComparadorPunto 
{
	protected ComparadorPunto ComparadorPunto1;
	protected ComparadorPunto ComparadorPunto2;
	public ComparadorPuntoCompuesto(ComparadorPunto comparadorPunto1, ComparadorPunto comparadorPunto2) {
		super();
		ComparadorPunto1 = comparadorPunto1;
		ComparadorPunto2 = comparadorPunto2;
	}
	

}
