package packPasaPalabra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 
 * Una clase para almacenar los usuarios del juego.
 * De Cada usuario queda guardado su nombre y su puntuacion.
 * @author Rubén de Celis
 *
 */
public class ListaUsuarios {
	
	private static ListaUsuarios mListaUsuarios = new ListaUsuarios();
	/*private Vector<Usuario> usuarios;*/
	private ListaOrdenadaGenerica<Usuario> usuarios;
	
	/**
	 * Constructor de la lista de Usuarios
	 */
	private ListaUsuarios() {
		/*usuarios = new Vector<Usuario>(1,1);*/
		usuarios = new ListaOrdenadaGenerica<Usuario>(new ComparadorUsuarios());
	}
	
	/**
	 * Devuelve la lista
	 * @return mListaUsuarios
	 */

	public static ListaUsuarios getListaUsuarios() {
		return mListaUsuarios;
	}

	/**
	 * <p>PRE: Dado un usuario</p>
	 * <p>POST: Queda insertado en la lista</p>
	 * @param pUsuario
	 */
	public void addUsuario(Usuario pUsuario) {
				
		/*int i=0;
		int k=0;
		boolean parar = false;
		int estado = 0;*/
		/*
		 * estado = 0 --> nuevo usuario
		 * estado = 1 --> existe jugador con mejor puntuacion
		 * estado = 2 --> existe jugador con menor puntuacion
		 */
		/*if(!usuarios.isEmpty()){
			while(k<usuarios.size() && !parar){
				
				if(usuarios.elementAt(k).esMismoUsuario(pUsuario)){
					if(!usuarios.elementAt(k).masPuntos(pUsuario)){
						usuarios.remove(k);
						estado= 1;						
					}else{
						estado =2;
					}
					parar=true;					
				}
				k++;
			}			
			if(estado!=2){
				while (i<usuarios.size() && usuarios.elementAt(i).masPuntos(pUsuario)){
					i++;
				}				
			}			
		}
		if(estado!=2){
			usuarios.insertElementAt(pUsuario, i);
		}*/
		
			/*Usuario usu;
			if(usuarios.contieneElemento(new MismoUsuario(pUsuario))){
				
				usu = usuarios.getElemento(new MismoUsuario(pUsuario));
							
				if(pUsuario.getPuntos() > usu.getPuntos()){
					
					usuarios.remove(usu);
					usuarios.add(pUsuario);
					
				}			
			}
			else{
				usuarios.add(pUsuario);			
			}*/
		
		Usuario usu;
		
			try{
				usu = usuarios.getElemento(new MismoUsuario(pUsuario));
				
				if(pUsuario.getPuntos() > usu.getPuntos()){
					
					usuarios.remove(usu);
					usuarios.add(pUsuario);
					
				}	
			}catch(NoSuchElementException ex){
				usuarios.add(pUsuario);
			}
					
		
	}
	
	/**
	 * <p>PRE: Dado un fichero</p>
	 * <p>POST: Se carga en la lista</p>
	 * @param pFichero
	 * @throws ErrorFormato 
	 * @throws FileNotFoundException
	 */

	public void inicializar(String pFichero) throws ErrorFormato /*throws FileNotFoundException*/{
		
		//////////////////////
		/*usuarios.clear();
		usuarios.trimToSize();*/
		usuarios.removeAllElements();
		//////////////////////
		
		try{
			File fichero = new File (pFichero);
			FileReader fr = new FileReader (fichero);
			Scanner sc =new Scanner(fr);
			
			String delim = "[\\s|\\p{Punct}]";
			sc.useDelimiter(delim);
			
			/*while (sc.hasNext()){
				
				try {
					String linea = sc.nextLine();

					Pattern pattern = Pattern.compile("^(\\d)+\\b\\s(.+\\b)(\\s.+\\b)*$");

					Matcher matcher = pattern.matcher(linea);

					if (!matcher.matches()) {
						throw new ErrorFormato();
					}

					String splitado[] =  sc.nextLine() linea.split(" ");
					int puntos = Integer.parseInt(splitado[0]);
					int i = 1;
					String nombre = "";
					while (i < splitado.length) {
						nombre = nombre + splitado[i];
						i++;
						if (i != splitado.length) {
							nombre = nombre + " ";
						}
					}
					addUsuario(new Usuario(nombre, puntos));

					
					 * int puntos = sc.nextInt(); addUsuario(new
					 * Usuario(sc.nextLine(),puntos));
					 

				} catch (ErrorFormato ex) {
					System.out.println("Error Formato");
				}*/
			
			
			
				while (sc.hasNext()){
					
					String linea = sc.nextLine();

					Pattern pattern = Pattern.compile("^(\\d)+\\b\\s(.+\\b)(\\s.+\\b)*$");

					Matcher matcher = pattern.matcher(linea);

					if (!matcher.matches()) {
						throw new ErrorFormato();
					}

					String splitado[] = /* sc.nextLine() */linea.split(" ");
					int puntos = Integer.parseInt(splitado[0]);
					int i = 1;
					String nombre = "";
					while (i < splitado.length) {
						nombre = nombre + splitado[i];
						i++;
						if (i != splitado.length) {
							nombre = nombre + " ";
						}
					}
					addUsuario(new Usuario(nombre, puntos));

					/*
					 * int puntos = sc.nextInt(); addUsuario(new
					 * Usuario(sc.nextLine(),puntos));
					 */
				
				}			
			
		}
		catch(FileNotFoundException ex){
			/*throw new FileNotFoundException(); */			
		}
		catch(ErrorFormato ex){
			throw new ErrorFormato();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * <p>PRE: Dado el nombre de un fichero</p>
	 * <p>POST: Queda guardada la lista de usuarios en el fichero</p>
	 * @param pFichero
	 */

	public void guardar(String pFichero) throws ErrorGuardarDatos{
		
		try{
			File fichero = new File (pFichero);
			FileWriter fw = new FileWriter (fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			/*for (int i =0; i<usuarios.size();i++){
				
				pw.println(usuarios.elementAt(i).getPuntos()+ " " + usuarios.elementAt(i).getNombre());
				
			}*/
			
			Iterator<Usuario> itr = usuarios.getIterador();
			Usuario usu = null;
			while (itr.hasNext()){
				usu = itr.next();
				pw.println(usu.getPuntos()+ " " + usu.getNombre());				
			}
			
			pw.close();
			bw.close();
		}
		catch(IOException ex){
			throw new ErrorGuardarDatos();
		}
	}
	
	/**
	 * <p>PRE: -</p>
	 * <p>POST: Nos devuelve el iterador de la lista de usuarios</p>
	 * @return iterator
	 */
	
	public Iterator<Usuario> getIterador() {
		/*return usuarios.iterator();*/
		return usuarios.getIterador();
	}

}
