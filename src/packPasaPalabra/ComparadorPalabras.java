package packPasaPalabra;

import java.util.Comparator;

/**
 * 
 *@version 1.0, 27/03/10
 * @author Rubén de Celis
 *
 */
public class ComparadorPalabras implements Comparator<Palabra> {

	public int compare(Palabra pPal1, Palabra pPal2) {
		/*return pPal1.getLongitud() - pPal2.getLongitud();*/
		return pPal2.getLongitud() - pPal1.getLongitud();
	}

}
