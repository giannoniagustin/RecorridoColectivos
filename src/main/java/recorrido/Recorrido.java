package recorrido;

import java.util.ArrayList;

import google.ApiGoogle;
import grafo.Arista;
import grafo.Grafo;
import grafo.Trayecto;
import grafo.Vertice;

public class Recorrido 
{
	int paradas;
	private Double[][] distanciaParadas;
	private Double[][] tiempoTeoricoParadas;
	private Double[][] tiempoAParadasActual;
	private Grafo grafo;
	private ArrayList<Colectivo> colectivos;
	ApiGoogle apiGoogle;
	

	public Recorrido(Grafo grafo, ArrayList<Colectivo> colectivos)
	{
		grafo.importarGrafo();
		cargarMatrizDistancia();
		this.paradas=grafo.getVertices().size()-1;
		distanciaParadas= new Double[paradas][paradas];
		tiempoTeoricoParadas= new Double[paradas][paradas];
		inicializarMatriz(paradas,paradas,this.distanciaParadas);
		inicializarMatriz(paradas,paradas,this.tiempoTeoricoParadas);
		this.grafo=grafo;
		apiGoogle= new ApiGoogle();
	
		
		
		// TODO Auto-generated constructor stub
	}

	private void cargarMatrizDistancia()
	{
		
		
		for (int j=0; j < paradas;j++)
		{
			for(int i=0; i < paradas;i++)
			{
				
					if ( i == j)
					{
						distanciaParadas[i][j]=grafo.getAristas().get(i).getTrayecto().getLargo();;
						tiempoTeoricoParadas[i][j]= grafo.getAristas().get(i).getTrayecto().getDuracion();
					}
					else
					{
						if (j < i)
						{
							distanciaParadas[i][j]=distanciaParadas[i-1][j]+ grafo.getAristas().get(i).getTrayecto().getLargo();
							tiempoTeoricoParadas[i][j]=tiempoTeoricoParadas[i-1][j]+ grafo.getAristas().get(i).getTrayecto().getDuracion();
							
						}
						
					}
					
			}
			
		}
		// TODO Auto-generated method stub
		
		
	}

	private void inicializarMatriz(int filas ,int columnas,Object[][] matriz)
	{
		for (int i=0; i < filas;i++)
		{
			for (int j=0; j < columnas;j++)
			{
				matriz[i][j]=null;
			}
		}
		// TODO Auto-generated method stub
		
	}
	public void imprimirMatriz(int filas, int columnas,Object[][] matriz)
	{
		for (int i=0; i< filas;i++)
		{
			System.out.println("");
			for (int j=0; j < columnas;j++)
			{
				System.out.print(matriz[i][j]+" ");
			}
			
		}
	}
	public double distanciaEntreTramos(int tramoInicio,int tramoFin)
	{
		
		return distanciaParadas[tramoInicio][tramoFin];
		
	}
	
	public void trayectoColectivo()
	{
		this.tiempoAParadasActual= new Double [colectivos.size()][paradas];
		Arista arista=null;
		
		for (int i=0; i < colectivos.size();i++)
		{
			
		 arista=	grafo.getTrayecto(colectivos.get(i));
		 if (arista != null)
		 {
			 actualizarTiemposAParadas(arista,colectivos.get(i));
		/*	 System.out.println("Colectivo "+colectivos.get(i).toString());
			 System.out.println("Trayecto "+ arista.toString());*/
			
			 
		 }
		 else
		 {
			 System.out.println("Trayecto no encontrado");
				
		 }
		}
		
		
		
	}

	private void actualizarTiemposAParadas(Arista arista, Colectivo colectivo)
	{
	Double tiempoPosicionAParada = tiempoPosicionAParada(colectivo,arista);
	Vertice proximaParada= this.grafo.proximoVertice(arista);
	System.out.println("Colectivo "+colectivo.toString());
	System.out.println("Proxima parada: "+proximaParada.toString());
	System.out.println("Tiempo proxima parada: "+tiempoPosicionAParada);

		for (int paradaActual=0; paradaActual < this.paradas;paradaActual++ )
		{
			if ( paradaActual < arista.getNumero())
			{
				this.tiempoAParadasActual[colectivo.getNroColectivo()][paradaActual]=null;
				
			}
			else
			{
				if (paradaActual > arista.getNumero())
				{
					this.tiempoAParadasActual[colectivo.getNroColectivo()][paradaActual]=this.tiempoTeoricoParadas[colectivo.getNroColectivo()][paradaActual]+tiempoPosicionAParada;
				}
				else
				{
					this.tiempoAParadasActual[colectivo.getNroColectivo()][paradaActual]=tiempoPosicionAParada;
				}
			}
		}
		
	}

	private Double tiempoPosicionAParada(Colectivo colectivo, Arista arista) {
	
		return	apiGoogle.caminoEntrePuntos(colectivo, grafo.proximoVertice(arista).getPunto()).getDuracion();
		// TODO Auto-generated method stub
		
	}

	public void setColectivos(ArrayList<Colectivo> colectivosMarron) {
		// TODO Auto-generated method stub
		this.colectivos=colectivosMarron;
	}


}
