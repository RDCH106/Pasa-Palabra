package packTest;

import java.util.Iterator;

import packPasaPalabra.ErrorFormato;
import packPasaPalabra.ErrorGuardarDatos;
import packPasaPalabra.ListaUsuarios;
import packPasaPalabra.Usuario;
import junit.framework.TestCase;


/**
 * Test de prueba de la clase ListaUsuarios
 * @author Rubén de Celis
 *
 */

public class ListaUsuariosTest extends TestCase {

	private ListaUsuarios lu;
	
	public ListaUsuariosTest(String pName) {
		super(pName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		lu = ListaUsuarios.getListaUsuarios();
		lu.inicializar("usuarios.txt");
		
	}

	public void testGetListaUsuarios() {
		assertNotNull(lu);		
	}

	/**
	 * En este test se debe comprobar ademas de si se insertan en la Lista,
	 * si se insertan de manera ordenada teniendo en cuenta la puntuacion (mayor puntuacion primero),
	 * y si existe el usuario actualiza la puntuacion de dicho jugador.
	 */
	public void testAddUsuario() {
		Usuario asier = new Usuario("Asier",180);
		Usuario gloria = new Usuario("Gloria",85);
				
		lu.addUsuario(asier);
		lu.addUsuario(gloria);

		Iterator<Usuario> itr = lu.getIterador();
		
		Usuario usu;
		
		usu=itr.next();		
		assertEquals("Asier",usu.getNombre());
		assertEquals(180,usu.getPuntos());
		usu=itr.next();
		assertEquals("Ruben",usu.getNombre());
		assertEquals(170,usu.getPuntos());
		usu=itr.next();
		assertEquals("Lara",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Laura",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Mariano",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Gloria",usu.getNombre());
		assertEquals(85,usu.getPuntos());
		usu=itr.next();
		assertEquals("TUKI",usu.getNombre());
		assertEquals(40,usu.getPuntos());
		
		asier = new Usuario("Asier",140);
		gloria = new Usuario("Gloria",185);
		
		lu.addUsuario(asier);
		lu.addUsuario(gloria);	
		
		itr = lu.getIterador();
				
		usu=itr.next();		
		assertEquals("Gloria",usu.getNombre());
		assertEquals(185,usu.getPuntos());
		usu=itr.next();
		assertEquals("Asier",usu.getNombre());
		assertEquals(180,usu.getPuntos());
		usu=itr.next();
		assertEquals("Ruben",usu.getNombre());
		assertEquals(170,usu.getPuntos());
		usu=itr.next();
		assertEquals("Lara",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Laura",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Mariano",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("TUKI",usu.getNombre());
		assertEquals(40,usu.getPuntos());
						
	}
	
	/**
	 * El test comprueba si la carga de usuarios al iniciar el juego es correcta 
	 */

	public void testInicializar() {		
		
		Iterator<Usuario> itr = lu.getIterador();
		
		Usuario usu;
				
		usu=itr.next();		
		assertEquals("Ruben",usu.getNombre());
		assertEquals(170,usu.getPuntos());
		usu=itr.next();		
		assertEquals("Lara",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Laura",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Mariano",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();		
		assertEquals("TUKI",usu.getNombre());
		assertEquals(40,usu.getPuntos());
				
	}
	
	public void testInicializar1() {
		
		try {
			lu.inicializar("Laura-Ruben.txt");
		} catch (ErrorFormato ex) {
			System.out.println("Error Formato");
		}
		Iterator<Usuario> itr = lu.getIterador();
		assertFalse(itr.hasNext());
		
	}
	
	public void testInicializar2() {
		
		try {
			lu.inicializar("FCorrupto.txt");
		} catch (ErrorFormato ex) {
			System.out.println("Error Formato");
		}
		Iterator<Usuario> itr = lu.getIterador();
		
		Usuario usu;
		
		usu=itr.next();		
		/*assertEquals("Ruben",usu.getNombre());
		assertEquals(333,usu.getPuntos());
		usu=itr.next();*/
		assertEquals("Laura",usu.getNombre());
		assertEquals(111,usu.getPuntos());
		assertFalse(itr.hasNext());		
		
	}	
	
	/**
	 * Este test verifica el guardado de los usuarios
	 */

	public void testGuardar() {
			
		try {
			lu.guardar("usuarios2.txt");
		} catch (ErrorGuardarDatos e) {
			System.out.println("Error al guardar los datos");
		}
		
		Iterator<Usuario> itr = lu.getIterador();
		
		Usuario usu;
				
		usu=itr.next();		
		assertEquals("Ruben",usu.getNombre());
		assertEquals(170,usu.getPuntos());
		usu=itr.next();		
		assertEquals("Lara",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Laura",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();
		assertEquals("Mariano",usu.getNombre());
		assertEquals(110,usu.getPuntos());
		usu=itr.next();		
		assertEquals("TUKI",usu.getNombre());
		assertEquals(40,usu.getPuntos());			
		
	}
	
	public void testGuardar2() {
		
		try {
			lu.guardar("./carpetanoexiste/kk.txt");
			fail();
		} catch (ErrorGuardarDatos e) {
			System.out.println("Error al guardar los datos");
		}
	}
	
	/**
	 * Test de comprobacion del iterador
	 */

	public void testGetIterador() {
		
		Iterator <Usuario> itr = lu.getIterador();
		assertNotNull(itr);
		
	}	

}
