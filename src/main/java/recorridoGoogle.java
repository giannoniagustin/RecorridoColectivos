

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;

import archivo.Archivo;
import archivo.ManangerArchivos;
import google.ApiGoogle;
import grafo.Grafo;
import grafo.Punto;
import grafo.Trayecto;
import recorrido.ManangerRecorrido;



/**
 * Servlet implementation class recorridoGoogle
 */
public class recorridoGoogle extends HttpServlet {
	private static final long  serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recorridoGoogle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	   ManangerRecorrido mRec= new ManangerRecorrido();
	   ManangerArchivos manangerArchivos= new ManangerArchivos();

	   mRec.cargarRecorridos();
	      
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ApiGoogle api= new ApiGoogle();
		api.camino();
	
		doGet(request, response);
	}

}