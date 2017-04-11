package grafo;

public class ComparadorPuntoEntreAltura extends ComparadorPuntoCompuesto 
{
	
	private Punto punto;
	
	public ComparadorPuntoEntreAltura(ComparadorPunto comparadorPunto1, ComparadorPunto comparadorPunto2,Punto punto) {
		super(comparadorPunto1, comparadorPunto2);
		this.punto=punto;
		// TODO Auto-generated constructor stub
	}


	@Override
	public int compare(Punto o1, Punto o2)
	{
		// TODO Auto-generated method stub
		if ((ComparadorPunto1.compare(punto, o1) ==1) && (ComparadorPunto2.compare(punto, o2) ==-1) )
		{
			
			return 0;
		}
		return -1;
			
	}

}
