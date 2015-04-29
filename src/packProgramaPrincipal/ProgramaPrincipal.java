package packProgramaPrincipal;

import packInterfazGrafica.*;
import packPasaPalabra.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		final String FICH_USUARIOS = "users.txt";
		final String FICH_PALABRAS = "Texto.txt";
		VentanaInicial ventanaInicial = VentanaInicial.getVentanaInicial();
		ventanaInicial.mostrar();
		GeneradorPalabras gPal = GeneradorPalabras.getGeneradorPalabras();
		ListaUsuarios listaUsuarios = ListaUsuarios.getListaUsuarios();
		try {
			try {
				ListaUsuarios.getListaUsuarios().inicializar(FICH_USUARIOS);
			} catch (ErrorFormato e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gPal.inicializar(ventanaInicial.getNumLetras(), FICH_PALABRAS);
			VentanaPalabra ventanaPalabra = VentanaPalabra.getVentanaPalabra();
			ventanaPalabra.mostrar();
			listaUsuarios.addUsuario(new Usuario(ventanaInicial.getNombre(),
					ventanaPalabra.getPuntos()));
			try {
				listaUsuarios.guardar(FICH_USUARIOS);
			} catch (ErrorGuardarDatos e) {
				VentanaMensaje.getVentanaMensaje().mostrar("Error al guardar el fichero de usuarios");
			}
			VentanaPuntuaciones.getVentanaPuntuaciones().mostrar();
		} catch (ErrorSeleccionFichero e1) {
			VentanaMensaje.getVentanaMensaje().mostrar(
					"Debes crear el fichero llamado \"Texto.txt\"");
		} catch (ErrorLongitudNoValida e) {
		}

	}
}
