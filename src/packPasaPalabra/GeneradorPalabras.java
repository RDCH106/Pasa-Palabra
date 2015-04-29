package packPasaPalabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*import java.util.Collection;*/
import java.util.Scanner;



/**
 * 
 * Una clase para almacenar los usuarios del juego.
 * De Cada usuario queda guardado su nombre y su puntuacion.
 * @author Rubén de Celis
 *
 */
public class GeneradorPalabras {
	
	private static GeneradorPalabras mGeneradorPal = new GeneradorPalabras();
	/*private Vector<Palabra> palabras;*/
	private ListaOrdenadaGenerica<Palabra> palabras;
	
	private GeneradorPalabras() {
		/*palabras = new Vector<Palabra>(1,1);*/
		palabras = new ListaOrdenadaGenerica<Palabra>(new ComparadorPalabras());
	}

	public static GeneradorPalabras getGeneradorPalabras() {
		return mGeneradorPal;
	}

	/**
	 *<P>PRE: Dado un numero de letras y un nombre de fichero</p>
     *<p>POST: Carga en una lista las palabra del fichero dado</p>
	 * @param pNumLetras
	 * @param pNomFich
	 * @throws FileNotFoundException 
	 */
	public void inicializar(int pNumLetras, String pNomFich) throws ErrorSeleccionFichero, ErrorLongitudNoValida{
		
		////////////////////////
		 /*palabras.clear();
		 palabras.trimToSize();*/
		 palabras.removeAllElements();
		 ////////////////////////
		
		try{
			
			if(pNumLetras<2){
				throw new ErrorLongitudNoValida();
			}
			
			File fichero = new File (pNomFich);
			FileReader fr = new FileReader (fichero);
			Scanner sc =new Scanner(fr);
			//String temp = "";
			
			String delim = "[\\s*|\\p{Punct}*|¿|¡]";
			sc.useDelimiter(delim);
			
			/*Vector<Palabra> fich = new Vector<Palabra>(1,1);*/
			
			/*Vector<Palabra> aux = new Vector<Palabra>(1,1);
			int letras = pNumLetras;*/
			
			while (sc.hasNext()){
				
				/*temp=sc.next();
				temp = tratarPalabra(temp);
				Palabra pal = new Palabra(temp);*/
				
				/*Palabra pal = new Palabra(sc.next().toUpperCase());
				if(pal.getLongitud()>=pNumLetras && !estaPalabra(pal.getPalabra(),fich)){
					fich.add(pal);
				}*/	
				
				Palabra pal = new Palabra(sc.next().toUpperCase());
				if(pal.getLongitud()>=pNumLetras && /*!estaPalabra(pal.getPalabra(),palabras*/
						!palabras.contieneElemento(new MismaPalabra(pal))){
					insertaOrdenado(pal);
				}
				
			}
			/*insertaOrdenado(fich);
			fich.clear();*/
			
			/*while (!fich.isEmpty()){
				int i=0;
				while(i<fich.size()){
					if(fich.elementAt(i).getLongitud()==letras){
						if(!estaPalabra(fich.elementAt(i).getPalabra(),aux)){
							aux.add(fich.elementAt(i));							
						}	
						fich.removeElementAt(i);
						i--;
					}
					i++;
				}
				insertaOrdenado(aux);
				letras++;
			}*/
		}
		catch(FileNotFoundException ex){
			throw new ErrorSeleccionFichero();
		}
		catch(ErrorLongitudNoValida ex){
			throw new ErrorLongitudNoValida();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	/**
	 *<P>PRE: Dado un String</p>
     *<p>POST: Devulve dicho String eliminando caracteres no alfabeticos</p>
	 * @param pTemp
	 * @return pTemp
	 */
	/* Hace lo mismo el scanner
	private String tratarPalabra(String pTemp) {
		
		String alf ="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ";
		char first = pTemp.charAt(0);
		char last = pTemp.charAt(pTemp.length()-1);
		String remplazado = "";
		
		if(alf.indexOf(first)== -1){
						
			for(int i=1; i<pTemp.length(); i++){
				remplazado = remplazado + pTemp.charAt(i);
			}
			
			pTemp = remplazado;
			remplazado = "";
			
		}
				
		if(alf.indexOf(last)== -1){
			
			for(int i=0; i<pTemp.length()-1; i++){
				remplazado = remplazado + pTemp.charAt(i);
			}
			
			pTemp = remplazado;
			
		}
		
		return pTemp.toUpperCase();
		
	}
	*/

	/**
	 *<P>PRE: -</p>
     *<p>POST: Devuelve la primera Palabra de la Lista</p>
	 * @return pal
	 */
	public Palabra darPalabra() throws ErrorPalabrasAgotadas {
		/*if(!palabras.isEmpty()){
			Palabra pal = palabras.firstElement();
			palabras.removeElementAt(0);
			return pal;
		}
		else{
			return null;
		}*/
		
		/*Palabra pal = palabras.remove(0);
		
		if(pal==null){
			throw new ErrorPalabrasAgotadas();
		}
		else{
			return pal;
		}*/		
		
		try{
			return palabras.remove(0);
		}catch(IndexOutOfBoundsException ex){
			throw new ErrorPalabrasAgotadas();
		}
		
	}
	
	/**
	 *<P>PRE: Dada una palabra y una Lista</p>
     *<p>POST: Devuelve si la palabra existe en dicha Lista</p>
	 * @param pPal
	 * @param pAux
	 * @return encontrado
	 */
	/*private boolean estaPalabra(String pPal, Vector<Palabra> pAux){
		Palabra pal = new Palabra(pPal);
		int i=0;
		boolean encontrado=false;
		while (!encontrado && i<pAux.size()){
			encontrado = pAux.elementAt(i).esIgual(pal);
			i++;
		}
		return encontrado;
	}*/
	
	/**
	 *<P>PRE: Dado una Lista</p>
     *<p>POST: Inserta los elementos de la lista recibida de manera ordenada en la lista de palabras</p>
	 * @param pPal
	 */	
	private void insertaOrdenado(Palabra pPal) {
		
		/*if ( palabras.isEmpty() )
		{
			palabras.add(pPal);
		}
		else {
					
			int pos = 0;
			boolean parar = false;
			while ( pos < palabras.size() && !parar )
			{
				if ( palabras.get(pos).esMenor(pPal) )
				{
					pos++;
				}
				else
				{
					parar = true;
				}
			}
			
			palabras.add(pos, pPal);
		}*/
		
		palabras.add(pPal);
		
	}	
	
	/*private void insertaOrdenado(Vector<Palabra> pAux){
		
		Collections.sort(pAux,String.CASE_INSENSITIVE_ORDER);
		
		Collections.sort(pAux);
		Collections.reverse(pAux);
		Collection<Palabra> c = pAux;
		lista.addAll(c);
		pAux.clear();
		
		Palabra temp = new Palabra("");
		 for (int i = 0; i < pAux.size()- 1; i++) {
		 	 for (int j = i + 1; j < pAux.size(); j++) {
	 	  	 	 if (pAux.elementAt(i).getLongitud() > pAux.elementAt(j).getLongitud()) {
			  	 	temp = pAux.elementAt(i);
			  	 	pAux.add(i,pAux.elementAt(j));
			  	 	pAux.remove(i+1);
			  	 	pAux.add(j,temp);
			  	 	pAux.remove(j+1);
			     }
			 }		 	 
		 }
		 
		 pAux.trimToSize();
		 Collection<Palabra> c = pAux;		 
		 palabras.addAll(c);
		 pAux.clear();
		
	}*/

}
