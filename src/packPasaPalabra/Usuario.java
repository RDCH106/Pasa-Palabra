package packPasaPalabra;

/**
 * Una clase para representar los usuarios del juego.
 * Cada usuario queda determinado por su nombre y su puntuacion.
 * @version 1.0, 27/03/10
 * @author Rubén de Celis
 */
public class Usuario {
	
	private String nombre;
	private int puntos;
	
	/**
	 * Constructor de la clase Usuario
	 * @param pNombre
	 * @param pPuntos
	 */
	
    public Usuario(String pNombre, int pPuntos) {
    	
    	this.nombre=pNombre;
    	this.puntos=pPuntos;
    	
    }

   /**
    *<p>PRE: - </p> 
    *<p>POST: Devuelve el nombre</p>
    * @return nombre
    */
    public String getNombre() {
		return nombre;
    }

    /**
     *<p>PRE: - </p> 
     *<p>POST: Devuelve los puntos del jugador</p>
     *@return puntos
     */
    public int getPuntos() {
		return puntos;
    }

    /**
     *<p>PRE: Dado un usuario</p>
     *<p>POST: Devuelve si el usuario tiene mas puntos que el usuario que se pasa por parametro</p>
     *@param pUsuario
     *@return boolean
     */
    public boolean masPuntos(Usuario pUsuario) {
    	
    	if(this.puntos > pUsuario.getPuntos()){
    		return true;
    	}
    	else{
    		return false;
    	}		
    }

    /**
     *<p>PRE: Dado un usuario</p>
     *<p>POST: Devuelve si el usuario es el mismo que el usuario que se pasa por parametro</p>
     *@param pUsuario
     *@return boolean
     */
    public boolean esMismoUsuario(Usuario pUsuario) {
    	
    	if(this.nombre.equalsIgnoreCase(pUsuario.getNombre())){
    		return true;
    	}
    	else{
    		return false;
    	}
		
    }
    
    public String toString(){    	
    	return this.getClass().getSimpleName() + " " + this.nombre + " " + this.puntos;    	
    }
    
}
