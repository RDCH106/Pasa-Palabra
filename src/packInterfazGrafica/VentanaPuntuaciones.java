package packInterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import packPasaPalabra.ListaUsuarios;
import packPasaPalabra.Usuario;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JScrollPane;

public class VentanaPuntuaciones extends JDialog {

	private static final long serialVersionUID = -9112611032931605058L;
	private static VentanaPuntuaciones mVentanaPuntuaciones = new VentanaPuntuaciones();
	private JPanel jContentPane = null;
	private JList jListaUsuarios = null;
	private JPanel jPanelBoton = null;
	private JButton jOKButton = null;
	private JLabel jLabelPuntuaciones = null;
	private JPanel jPanelTxt = null;
	private Controlador controlador;
	private ListaUsuarios listaJugadores;
	private JScrollPane jScrollPaneUsuarios = null;

	
	/**
	 * This method initializes
	 * 
	 */
	private VentanaPuntuaciones() {
		super();
		initialize();
		listaJugadores = ListaUsuarios.getListaUsuarios();
		//listaJugadores.addObserver(this);
		//update(null, null);
	}

	public static VentanaPuntuaciones getVentanaPuntuaciones() {
		return mVentanaPuntuaciones;
	}

	public void mostrar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		update();
		this.setVisible(true);
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */

	private void update() {
		Vector<String> lista = new Vector<String>();
		Iterator<Usuario> it = listaJugadores.getIterador();
		int cantidad = 0;
		while (it.hasNext() && cantidad < 10) {
			Usuario jugador = it.next();
			String linea = String.format("\t %1$,8d \t\t <--- %2$s", jugador
					.getPuntos(), jugador.getNombre());
			lista.add(linea);
			cantidad++;
		}
		getJListaUsuarios().setListData(lista);
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(350, 330));
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Mejores Puntuaciones");
		this.addWindowListener(getControlador());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(10);
			borderLayout.setHgap(10);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanelBoton(), BorderLayout.SOUTH);
			jContentPane.add(getJPanelTxt(), BorderLayout.NORTH);
			jContentPane.add(getJScrollPaneUsuarios(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JLabel getJLabelPuntuaciones(){
		if (jLabelPuntuaciones == null){
			jLabelPuntuaciones = new JLabel();
			jLabelPuntuaciones.setText("Lista de Puntuaciones:");
			jLabelPuntuaciones.setFont(new Font("Lucida Grande", Font.BOLD, 18));			
		}
		return jLabelPuntuaciones;
	}
	
	/**
	 * This method initializes jScrollPaneUsuarios	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneUsuarios() {
		if (jScrollPaneUsuarios == null) {
			jScrollPaneUsuarios = new JScrollPane(getJListaUsuarios());
		}
		return jScrollPaneUsuarios;
	}

	/**
	 * This method initializes jListaUsuarios
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListaUsuarios() {
		if (jListaUsuarios == null) {
			jListaUsuarios = new JList();
			jListaUsuarios.setFont(new Font("Monospaced", Font.BOLD, 18));
			jListaUsuarios.setToolTipText("Ranking de los mejores jugadores");
			jListaUsuarios
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jListaUsuarios.setVisibleRowCount(10);
			jListaUsuarios.setForeground(Color.blue);
			jListaUsuarios.setAutoscrolls(true);
		}
		return jListaUsuarios;
	}

	/**
	 * This method initializes jPanelBoton
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelBoton() {
		if (jPanelBoton == null) {
			jPanelBoton = new JPanel();
			jPanelBoton.setLayout(new FlowLayout());
			jPanelBoton.add(getJOKButton(), null);
		}
		return jPanelBoton;
	}

	/**
	 * This method initializes jOKButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJOKButton() {
		if (jOKButton == null) {
			jOKButton = new JButton();
			jOKButton.setText("OK");
			jOKButton.setToolTipText("Cerrar la ventana");
			jOKButton.addActionListener(getControlador());
		}
		return jOKButton;
	}

	/**
	 * This method initializes jPanelTxt
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelTxt() {
		if (jPanelTxt == null) {
			jPanelTxt = new JPanel();
			jPanelTxt.setLayout(new GridBagLayout());
			jPanelTxt.add(getJLabelPuntuaciones(), new GridBagConstraints());
		}
		return jPanelTxt;
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador extends WindowAdapter implements ActionListener {

		@Override
		public void windowClosing(WindowEvent e) {
			closing();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			closing();

		}

		private void closing() {
			System.exit(0);
		}

	}

	

} // @jve:decl-index=0:visual-constraint="10,10"
