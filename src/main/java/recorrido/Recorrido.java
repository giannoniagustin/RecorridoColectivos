package recorrido;

import java.util.ArrayList;

import grafo.Grafo;

public class Recorrido 
{
	public  static final Double  INVALIDO=null;
	int paradas;
	private Double[][] distanciaParadas;
	private Double[][] tiempoParadas;
	private Grafo grafo;

	public Recorrido(Grafo grafo, ArrayList<Colectivo> colectivos)
	{
		this.paradas=grafo.getVertices().size()-1;
		distanciaParadas= new Double[paradas][paradas];
		tiempoParadas= new Double[paradas][paradas];
		this.grafo=grafo;
		
		cargarMatrizDistancia();
		
		// TODO Auto-generated constructor stub
	}

	private void cargarMatrizDistancia()
	{
		inicializarMatrizDistancia();
		
		for (int j=0; j < paradas;j++)
		{
			for(int i=0; i < paradas;i++)
			{
				//if (distanciaParadas[i][j] != INVALIDO )
				{
					if ( i == j)
					{
						distanciaParadas[i][j]=grafo.getAristas().get(i).getTrayecto().getLargo();;
						tiempoParadas[i][j]= grafo.getAristas().get(i).getTrayecto().getDuracion();
					}
					else
					{
						if (j < i)
						{
							distanciaParadas[i][j]=distanciaParadas[i-1][j]+ grafo.getAristas().get(i).getTrayecto().getLargo();
							tiempoParadas[i][j]=tiempoParadas[i-1][j]+ grafo.getAristas().get(i).getTrayecto().getDuracion();
							
						}
						
						
					}
					
						
					
				}
				
			}
			
		}
		// TODO Auto-generated method stub
		this.imprimirMatrizDistancias();
		
	}

	private void inicializarMatrizDistancia()
	{
		for (int i=0; i < paradas;i++)
		{
			for (int j=0; j < paradas;j++)
			{
				distanciaParadas[i][j]=null;
			}
		}
		// TODO Auto-generated method stub
		
	}
	public void imprimirMatrizDistancias()
	{
		for (int i=0; i< paradas;i++)
		{
			System.out.println("");
			for (int j=0; j < paradas;j++)
			{
				System.out.print(distanciaParadas[i][j]+" ");
			}
			
		}
	}
	public double distanciaEntreTramos(int tramoInicio,int tramoFin)
	{
		
		return distanciaParadas[tramoInicio][tramoFin];
		
	}

}
