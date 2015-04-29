package packPasaPalabra;

import java.util.*;

/**
 * 
 * @version 1.0, 27/03/10
 * @author Rubén de Celis
 * @param <T>
 * 
 */
public class ListaOrdenadaGenerica<T> {
	
	private List<T> listaElementos;
	private Comparator<T> comp;
	
	public ListaOrdenadaGenerica (Comparator<T> pComp) {
		listaElementos = new Vector<T>();
		comp = pComp;
	}
	
	/**
	 * <p>PRE: Dado un elemento</p>
	 * <p>POST: Lo añade en la posición correspondiente de la 
	 * lista según el criterio de ordenación establecido por el comparador</p>	
	 * @param pElemento
	 */
	public void add(T pElemento) {
		if(listaElementos.isEmpty()){
			listaElementos.add(pElemento);
		}
		else{
			int pos=0;
			boolean parar=false;
			while(!parar && pos<listaElementos.size()){
				if(comp.compare(pElemento, listaElementos.get(pos))>0){
					parar=true;
				}
				else{
					pos++;
				}
			}
			listaElementos.add(pos,pElemento);
		}
	}
	
	/**
	 * <p>PRE: Dada una condición de búsqueda (ver la interfaz ICondicion proporcionada)</p>
	 * <p>POST: Devuelve el primer elemento que satisfaga dicha condición,
	 * o null si no existe tal elemento</p>
	 * @param pCond
	 * @return
	 */
	public T getElemento(ICondicion<T> pCond) {
		Iterator<T> itr = getIterador();
		boolean encontrado = false;
		T elemento = null;
		while(itr.hasNext() && !encontrado){
			elemento = itr.next();
			if(pCond.satisfaceCondicion(elemento)){
				encontrado = true;
			}
		}
		if(encontrado){
			return elemento;
		}
		else{
			//return null;
			throw new NoSuchElementException();
		}			
	}
	
	/**
	 * <p>PRE: Dado un elemento</p>
	 * <p>POST: Lo elimina de la lista de elementos</p>
	 * @param pElemento
	 */
	public void remove(T pElemento) {
		listaElementos.remove(pElemento);
	}
	
	/**
	 * <p>PRE: - </p>
	 * <p>POST: Devuelve un Iterador que permite recorrer la lista ordenada</p>
	 * @return
	 */
	public Iterator<T> getIterador() {
		return listaElementos.iterator();
	}

	/**
	 * <p>PRE: - </p>
	 * <p>POST: Elimina todos los elementos de la lista</p>
	 */
	public void removeAllElements() {
		listaElementos.clear();
		((Vector<T>) listaElementos).trimToSize();
	}

	/**
	 * <p>PRE: Dada una posición</p>
	 * <p>POST: Elimina el elemento que ocupa dicha posición en la lista</p>
	 * @param pPos
	 * @return
	 */
	public T remove(int pPos) {
		/*T elemento = null;
		if(pPos<listaElementos.size()){
			elemento = listaElementos.remove(pPos);
		}*/		
		return listaElementos.remove(pPos);
	}

	/**
	 * <p>PRE: Dada una condición de búsqueda (ver la interfaz ICondicion proporcionada)</p>
	 * <p>POST: Devuelve true si existe algún elemento
	 * que cumpla dicha condición y false en caso contrario</p>
	 * @param pCond
	 * @return
	 */
	public boolean contieneElemento(ICondicion<T> pCond) {
		Iterator<T> itr = getIterador();
		boolean encontrado = false;
		T elemento = null;
		while(itr.hasNext()){
			elemento = itr.next();
			if(pCond.satisfaceCondicion(elemento)){
				encontrado = true;
			}
		}
		return encontrado;	
	}
	
	/**
	 * <p>PRE: - </p>
	 * <p>POST: Devuelve una cadena de caracteres que
	 * representa el contenido de la lista ordenada</p>
	 */
	public String toString(){
		return this.listaElementos.toString();
		
	}
}
