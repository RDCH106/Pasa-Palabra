package packTest;

import packPasaPalabra.Palabra;
import junit.framework.TestCase;

/**
 * Test de prueba de la clase Palabra
 * @author Rubén de Celis
 *
 */

public class PalabraTest extends TestCase {

	private Palabra p1;
	private Palabra p2;
	
	/**
	 * Constructor 
	 * @param pName
	 */
	
	public PalabraTest(String pName) {
		super(pName);
	}

	/**
	 * Inicializacion de variables
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		p1=new Palabra("Ruben");
		p2=new Palabra("Laura");
	}

	public void testPalabra() {
		assertNotNull(p1);
		assertNotNull(p2);
	}

	public void testGetPalabra() {
		assertEquals("Ruben",p1.getPalabra());
		assertEquals("Laura",p2.getPalabra());
	}

	public void testGetLongitud() {
		assertEquals("Ruben".length(),p1.getLongitud());
		assertEquals("Laura".length(),p2.getLongitud());
	}

	public void testGetPalabraDesordenada() {		
		assertFalse(p1.getPalabra().equalsIgnoreCase(p1.getPalabraDesordenada()));
		assertFalse(p2.getPalabra().equalsIgnoreCase(p2.getPalabraDesordenada()));			
	}

	public void testEsMenor() {		
		assertFalse(p1.esMenor(new Palabra("Ru")));
		assertTrue(p2.esMenor(new Palabra("Lauraaa")));		
	}

	public void testEsIgual() {		
		assertTrue(p1.esIgual(new Palabra("Ruben")));
		assertFalse(p2.esIgual(new Palabra("Lau")));		
	}

}
