package grafo;

public class ComparadorPuntoAltura extends ComparadorPuntoSimple {

	@Override
	public int compare(Punto o1, Punto o2) {
		// TODO Auto-generated method stub
		 if (o1.getAltura() ==o2.getAltura())
		 {
			 return 0;
			 
		 }
		 if (o1.getAltura() < o2.getAltura())
		 {
			 return -1;
			 
		 }
		 if (o1.getAltura() > o2.getAltura())
		 {
			 return 1;
			 
		 }
		 return 0;
	}

}
