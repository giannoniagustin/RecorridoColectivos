package filtros;

public abstract class FiltroMayor extends FiltroSimple {



	@Override
	public boolean cumple(Object punto) {
		// TODO Auto-generated method stub
		return ((Integer)this.getAtributo() >(Integer) punto);
	}

}
