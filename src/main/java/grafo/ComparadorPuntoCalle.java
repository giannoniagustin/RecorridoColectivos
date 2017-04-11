package grafo;

import java.util.Comparator;

public class ComparadorPuntoCalle extends ComparadorPuntoSimple{

	@Override
	public int compare(Punto o1, Punto o2) {
		// TODO Auto-generated method stub
		return o1.getCalle().compareTo(o2.getCalle());
	}

}
