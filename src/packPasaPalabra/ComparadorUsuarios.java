package packPasaPalabra;

import java.util.Comparator;

/**
 * 
 * @version 1.0, 27/03/10
 * @author Rubén de Celis
 *
 */
public class ComparadorUsuarios implements Comparator<Usuario> {

	public int compare(Usuario pUsuario1, Usuario pUsuario2) {
		if(pUsuario1.getPuntos() - pUsuario2.getPuntos()==0){
			return pUsuario2.getNombre().compareToIgnoreCase(pUsuario1.getNombre());
		}
		else{
			return pUsuario1.getPuntos() - pUsuario2.getPuntos();
		}		
	}

}
