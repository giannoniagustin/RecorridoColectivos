package grafo;

public class Matriz<E> {
	private int cantFilas;
	private int cantColumnas;
	private E[][] matriz;
	public Matriz(int cantFilas, int cantColumnas)
	{
		super();
		this.cantFilas = cantFilas;
		this.cantColumnas = cantColumnas;
		this.matriz= (E[][]) new Object[cantFilas][cantColumnas];
	

}
	public E get(int fila ,int columna)
	{
	return this.matriz[fila][columna];	
		
			}
	
	public void set(int fila ,int columna,E valor)
	{
	 this.matriz[fila][columna]=valor;	
		
			}
}