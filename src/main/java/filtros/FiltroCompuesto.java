package filtros;

public abstract class FiltroCompuesto extends Filtro {

protected Filtro f1;
protected Filtro f2;
public FiltroCompuesto(Filtro f1, Filtro f2) {
	super();
	this.f1 = f1;
	this.f2 = f2;
}


}
