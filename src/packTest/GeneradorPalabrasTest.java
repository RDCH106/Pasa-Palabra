package packTest;

import packPasaPalabra.ErrorLongitudNoValida;
import packPasaPalabra.ErrorPalabrasAgotadas;
import packPasaPalabra.ErrorSeleccionFichero;
import packPasaPalabra.GeneradorPalabras;
import packPasaPalabra.Palabra;
import junit.framework.TestCase;

/**
 * Test de prueba de la clase GeneradorPalabras
 * @author Rubén de Celis
 *
 */

public class GeneradorPalabrasTest extends TestCase {

	private GeneradorPalabras gp;
	
	/**
	 * Constructor 
	 * @param pName
	 */
	
	public GeneradorPalabrasTest(String pName) {
		super(pName);
	}

	/**
	 * Inicializacion de variables
	 * @throws Exception
	 */
	
	protected void setUp() throws Exception {
		super.setUp();
		gp = GeneradorPalabras.getGeneradorPalabras();		
		try{
			gp.inicializar(4, "text.txt" );
		}catch(ErrorSeleccionFichero ex){
			fail("Error Seleccion de Fichero");
		}catch(ErrorLongitudNoValida ex){
			fail("Error Longitud No Valida");
		}
		
	}

	public void testGetGeneradorPalabras() {
		assertNotNull(gp);
	}
	
	/**
	 * El test comprueba si la carga de palabras al iniciar el juego es correcta 
	 */

	public void testInicializar() {
			
		
		 /** Lista interna esperada tras la carga(inicilizar)
		 * GULA
		 * GULO
		 * TUKI
         * GULON
         * LIRIO
         * PASPAN
         * GUSANILLO
         * GUSANILLA*/
		 
		
		/*assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );*/
		
		
		/** Lista interna esperada tras la carga(inicilizar)
		 * TUKI
		 * GULO
		 * GULA
		 * GULON
		 * LIRIO
		 * PASPAN
		 * GUSANILLA
		 * GUSANILLO*/
		
		
		/*assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );*/
		
		/** Lista interna esperada tras la carga(inicilizar)
		 * GULA
		 * GULO
		 * TUKI
		 * LIRIO
		 * GULON
		 * PASPAN
		 * GUSANILLO
		 * GUSANILLA*/
		
		try{
			assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );		
			assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );	
			assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );
		}catch(ErrorPalabrasAgotadas ex){
			System.out.println("Palabras Agotadas");
		}
						
	}
	
	public void testInicializar1() {
		try{
			gp.inicializar(4, "text.txt" );
			System.out.println("testInicializar1 OK");
		}catch(ErrorSeleccionFichero ex){
			fail();
		}catch(ErrorLongitudNoValida ex){
			fail();
		}
	}
	
	public void testInicializar2() {
		try{
			gp.inicializar(4, "Laura-Ruben.txt" );
			fail();
		}catch(ErrorSeleccionFichero ex){
			System.out.println("testInicializar2 OK");
		}catch(ErrorLongitudNoValida ex){
			fail();
		}
	}
	
	public void testInicializar3() {
		try{
			gp.inicializar(1, "text.txt" );	
			fail();
		}catch(ErrorSeleccionFichero ex){
			fail();
		}catch(ErrorLongitudNoValida ex){
			System.out.println("testInicializar3 OK");
		}
	}
	
	public void testInicializar4() {
		try{
			gp.inicializar(1, "Laura-Ruben.txt" );
			fail();
		}catch(ErrorSeleccionFichero ex){
			System.out.println("testInicializar4 OK");
		}catch(ErrorLongitudNoValida ex){
			System.out.println("testInicializar4 OK");
		}
	}

	/**
	 * Este test es para el control de las palabras q se van suministrando al juego
	 */
	public void testDarPalabra() {
		
		
		 /** Lista interna esperada tras la carga(inicilizar)
		 * GULA
		 * GULO
		 * TUKI
         * GULON
         * LIRIO
         * PASPAN
         * GUSANILLO
         * GUSANILLA*/
		 
		/*assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );*/
		
		
		/** Lista interna esperada tras la carga(inicilizar)
		 * TUKI
		 * GULO
		 * GULA
		 * GULON
		 * LIRIO
		 * PASPAN
		 * GUSANILLA
		 * GUSANILLO*/
		
		
		/*assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
		assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );	
		assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );*/
		
		/** Lista interna esperada tras la carga(inicilizar)
		 * GULA
		 * GULO
		 * TUKI
		 * LIRIO
		 * GULON		 
		 * PASPAN
		 * GUSANILLO
		 * GUSANILLA*/
		
		try{
			assertEquals( new Palabra("GULA").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("GULO").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("TUKI").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("LIRIO").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("GULON").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("PASPAN").getPalabra() , gp.darPalabra().getPalabra() );
			assertEquals( new Palabra("GUSANILLO").getPalabra() , gp.darPalabra().getPalabra() );	
			assertEquals( new Palabra("GUSANILLA").getPalabra() , gp.darPalabra().getPalabra() );
		}catch(ErrorPalabrasAgotadas ex){
			System.out.println("Palabras Agotadas");
		}		
		
	}
	
	public void testDarPalabra1() {
		
		try{
			for(int i=1; i<=8; i++){
				gp.darPalabra();
			}
			gp.darPalabra();
			fail();
		}catch(ErrorPalabrasAgotadas ex){
			System.out.println("Palabras Agotadas");			
		}
		
	}

}
