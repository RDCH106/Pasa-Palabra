
package packPasaPalabra;


/**
  *Una clase para representar las palabras del juego.
  *Cada palabra queda determinada por un string que 
  *representa la palabra en cuestion.
  *@version 1.0, 27/03/10
  *@author Rubén de Celis
 */
public class Palabra /*implements Comparable<Object>*/{
	
	private String pal;
	
	/**
	 * Constructor de la clase Palabra
	 * @param pPal
	 */
   public Palabra(String pPal) {
	   
	   this.pal = pPal;
	   
   }

   /**
    *<p>PRE: -</p>
    *<p>POST: Devuelve la palabra</p>
    *@return pal
    */
   
   public String getPalabra() {
     return pal;
   }
   
   /**
    *<p>PRE: -</p>
    *<p>POST: Devuelve la longitud de la palabra</p>
    *@return pal
    */
   public int getLongitud() {
      return pal.length();
   }
   
   /**
    *<p>PRE: -</p>
    *<p>POST: Devuelve la palabra desordenada</p>
    *@return palabraDesordenada
    */
   public String getPalabraDesordenada() {
	   
	   String palDesordenada = pal;
	   //Tecnica del binguero
	   char[] insertadas = new char[pal.length()];
	   int pos;
	   boolean parar = false;
	   
	   while(pal.equals(palDesordenada)){
		   palDesordenada="";
		   for(int i=0;i<pal.length();i++){
			   insertadas[i]='o';
		   }
		   for(int i=0; i<pal.length(); i++){
			   
			   pos=(int) (Math.random()*(pal.length()));
			   		   
			   while(!parar ){
				   
				   if(insertadas[pos]!='x'){
					   palDesordenada = palDesordenada + pal.charAt(pos);
					   insertadas[pos]='x';
					   parar = true;
				   }
				   else{
					   pos=(int) (Math.random()*(pal.length())); 
				   }			   
			   }
			   parar=false;
		   }
	   }
	  
			
	   return palDesordenada.toUpperCase();
   }
   
   

   /**
    *<p>PRE: Dada una palabra</p>
    *<p>POST: Devuelve si la palabra es menor que la palabra que se pasa como parametro</p> 
    *@param pPal
    *@return boolean
    */
   public boolean esMenor(Palabra pPal) {
	  
	   if(this.getLongitud() < pPal.getLongitud()){
		   return true;
	   }
	   else{
		   return false;
	   }
	   
   }

   /**
    *<p>PRE: Dada una palabra</p>
    *<p>POST: Devuelve si la palabra es igual que la palabra que se pasa como parametro </p>
    *@param pPal
    *@return boolean
    */
   public boolean esIgual(Palabra pPal) {

	   if(pPal.getPalabra().equalsIgnoreCase(this.pal)){
		   return true;
	   }
	   else{
		   return false;
	   }
	   
   }

   /*
   @Override
   public int compareTo(Object pObj) {
	   
	   if (pObj instanceof Palabra){
		   
		   if(((Palabra)pObj).getPalabra().compareTo(this.pal)>0){
				return 1;
			}
			else if(((Palabra)pObj).getPalabra().compareTo(this.pal)<0){
				return -1;
			}
			else{
				return 0;
			}			   
	   }
	   else{
		   return 88;
	   }					
	}
	*/
   
   public String toString(){
	   return this.getClass().getSimpleName() + " " + this.pal;
   }
   
}
