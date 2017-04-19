package filtros;

public abstract  class FiltroIgual extends FiltroSimple{

	@Override
	public boolean cumple(Object punto) {
		// TODO Auto-generated method stub
		return this.getAtributo().equals(punto);
	}
	

	

}
