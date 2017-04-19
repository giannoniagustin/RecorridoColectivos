package grafo;

import java.util.Date;

import filtros.Filtro;

public abstract class ElementoUbicacion {
	protected Date fechaCreacion;
    protected String calle;
    protected Integer altura;
    protected Integer alturaInicio;
    protected Integer alturaFin;
    
    public abstract boolean cumple(Filtro f);

}
