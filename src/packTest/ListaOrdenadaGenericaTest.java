package packTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import packPasaPalabra.ComparadorPalabras;
import packPasaPalabra.ComparadorUsuarios;
import packPasaPalabra.ListaOrdenadaGenerica;
import packPasaPalabra.MismaPalabra;
import packPasaPalabra.MismoUsuario;
import packPasaPalabra.Palabra;
import packPasaPalabra.Usuario;
import junit.framework.TestCase;

/**
 * 
 * @author Rubén de Celis
 *
 */
public class ListaOrdenadaGenericaTest extends TestCase {

	private ListaOrdenadaGenerica<Palabra> logP;
	private ListaOrdenadaGenerica<Usuario> logU;
	
	public ListaOrdenadaGenericaTest(String pName) {
		super(pName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		logP = new ListaOrdenadaGenerica<Palabra>(new ComparadorPalabras());
		logP.add(new Palabra("pichufla"));
		logP.add(new Palabra("percal"));
		logP.add(new Palabra("sombrerero"));
		logU = new ListaOrdenadaGenerica<Usuario>(new ComparadorUsuarios());
		logU.add(new Usuario("Laura",110));
		logU.add(new Usuario("Ruben",170));
		logU.add(new Usuario("Tuki",280));
		
	}

	public void testListaOrdenadaGenerica() {
		assertNotNull(logP);
		assertNotNull(logU);
	}

	public void testAdd() {
		logP.add(new Palabra("guapa"));
		assertEquals("guapa",logP.getElemento(new MismaPalabra(new Palabra("guapa"))).getPalabra());
		logU.add(new Usuario("Asier",100));
		assertEquals("Asier",logU.getElemento(new MismoUsuario(new Usuario("Asier",100))).getNombre());
	}

	public void testGetElemento() {
		assertEquals("pichufla",logP.getElemento(new MismaPalabra(new Palabra("pichufla"))).getPalabra());
		assertEquals("Laura",logU.getElemento(new MismoUsuario(new Usuario("Laura",110))).getNombre());
		
	}

	public void testRemoveT() {
		Palabra pal = new Palabra ("sombrerero");
		logP.remove(logP.getElemento(new MismaPalabra(pal)));
		assertFalse( logP.contieneElemento(new MismaPalabra(pal)));
		Usuario usu = new Usuario("Ruben",170);
		logU.remove(logU.getElemento(new MismoUsuario(usu)));
		assertFalse(logU.contieneElemento(new MismoUsuario((usu))));
	}

	public void testGetIterador() {
		Iterator <Palabra> itrP = logP.getIterador();
		assertNotNull(itrP);
		Iterator <Usuario> itrU = logU.getIterador();
		assertNotNull(itrU);
	}

	public void testRemoveAllElements() {
		logP.removeAllElements();
		assertFalse(logP.getIterador().hasNext());
		logU.removeAllElements();
		assertFalse(logU.getIterador().hasNext());
	}

	public void testRemoveInt() {
		logP.remove(0);
		assertFalse( logP.contieneElemento(new MismaPalabra(new Palabra ("percal"))));
		logU.remove(0);
		assertFalse( logU.contieneElemento(new MismoUsuario(new Usuario ("Tuki",280))));
	}

	public void testContieneElemento() {
		assertFalse( logP.contieneElemento(new MismaPalabra(new Palabra ("tetera"))));
		assertTrue( logP.contieneElemento(new MismaPalabra(new Palabra ("percal"))));
		assertFalse( logU.contieneElemento(new MismoUsuario(new Usuario ("Gloria",100))));
		assertTrue( logU.contieneElemento(new MismoUsuario(new Usuario ("Ruben",170))));
	}
	
	public void testToString() {
		try{
			File fichero = new File ("Bob.txt");
			FileWriter fw = new FileWriter (fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(logP.toString());
			pw.println(logU.toString());
			
			pw.close();
			
			fichero = new File ("Bob.txt");
			FileReader fr = new FileReader (fichero);
			Scanner sc = new Scanner(fr);
			
			String str = sc.nextLine();
			char c1 = '[';
			char c2 = ']';
			
			assertEquals(c1,str.charAt(0));	
			assertEquals(c2,str.charAt(str.length()-1));
			
			str = sc.nextLine();
			
			assertEquals(c1,str.charAt(0));	
			assertEquals(c2,str.charAt(str.length()-1));			
			
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}

}
