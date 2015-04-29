package packTest;

import packPasaPalabra.Usuario;
import junit.framework.TestCase;

/**
 * Test de prueba de la clase Usuario
 * @author Rubén de Celis
 *
 */

public class UsuarioTest extends TestCase {

	private Usuario u1;
	private Usuario u2;
	
	/**
	 * Constructor 
	 * @param pName
	 */
	public UsuarioTest(String pName) {
		super(pName);
	}

	/**
	 * Inicializacion de variables
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		u1= new Usuario("Ruben",10);
		u2= new Usuario("Laura",11);
		
	}

	public void testUsuario() {
		assertNotNull(u1);
		assertNotNull(u1);
	}

	public void testGetNombre() {
		assertEquals("Ruben",u1.getNombre());
		assertEquals("Laura",u2.getNombre());
	}

	public void testGetPuntos() {
		assertEquals(10,u1.getPuntos());
		assertEquals(11,u2.getPuntos());
	}

	public void testMasPuntos() {
		assertFalse(u1.masPuntos(u2));
		assertTrue(u2.masPuntos(u1));
	}

	public void testEsMismoUsuario() {
		assertTrue(u1.esMismoUsuario(u1));
		assertFalse(u1.esMismoUsuario(u2));
	}

}
