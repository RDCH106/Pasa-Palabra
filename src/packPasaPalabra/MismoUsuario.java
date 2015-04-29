package packPasaPalabra;

/**
 * 
 *@version 1.0, 27/03/10
 * @author Rubén de Celis
 *
 */
public class MismoUsuario implements ICondicion<Usuario> {
	
	private Usuario usu;
	
	public MismoUsuario(Usuario pUsuario) {
		usu = pUsuario;
	}

	public boolean satisfaceCondicion(Usuario pUsuario) {
		return usu.esMismoUsuario(pUsuario);
	}

}
