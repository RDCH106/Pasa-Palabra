package packPasaPalabra;

/**
 * 
 * @version 1.0, 27/03/10
 * @author Rubén de Celis
 *
 */
public class MismaPalabra implements ICondicion<Palabra> {
	
	private Palabra pal;
	
	public MismaPalabra(Palabra pPal) {
		pal = pPal;
	}

	public boolean satisfaceCondicion(Palabra pPalabra) {
		return pal.esIgual(pPalabra);
	}

}
