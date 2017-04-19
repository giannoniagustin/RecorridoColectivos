package filtros;

public class FiltroOr extends FiltroCompuesto {

	public FiltroOr(Filtro f1, Filtro f2) {
		super(f1, f2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean cumple(Object punto) {
		// TODO Auto-generated method stub
		return (f1.cumple(punto) || f2.cumple(punto));
	}

}
