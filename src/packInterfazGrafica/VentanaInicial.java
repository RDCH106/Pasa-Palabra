package packInterfazGrafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.WindowConstants;

public class VentanaInicial extends JDialog {
	private static final long serialVersionUID = 4055694471082654677L;
	private static VentanaInicial mVentanaInicial = new VentanaInicial();
	private JPanel jContentPane = null;
	private JPanel jPanelJugador = null;
	private JPanel jPanelLongPalabra = null;
	private JPanel jPanelBoton = null;
	private JButton jOKButton = null;
	private JLabel jLabelJugador = null;
	private JTextField jTextNombre = null;
	private JLabel jLabelLongPalabra = null;
	private JSlider jSldrLongPalabra = null;
	private Controlador controlador=null;

	/**
	 * This method initializes
	 * 
	 */
	private VentanaInicial() {
		super();
		initialize();
	}

	public static VentanaInicial getVentanaInicial() {
		return mVentanaInicial;
	}

	public void mostrar() {
		mostrar("");
	}

	public String getNombre() {
		return getJTextNombre().getText();
	}

	// Mï¿½todo que devuelve el nï¿½mero de letras solicitado por el usuario
	public int getNumLetras() throws NumberFormatException {
		return getJSLongPalabra().getValue();
	}

	public void mostrar(String pNomUs) {
		getJTextNombre().setText(pNomUs);
		getJSLongPalabra().setValue(2);
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
		this.setModal(true);
		this.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(591, 313));
		this.setResizable(false);
		this.setModal(true);
		this.setTitle("PasaPalabra - Inicio de Juego");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(3);
			gridLayout.setColumns(1);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getJPanelJugador(), null);
			jContentPane.add(getJPanelLongPalabra(), null);
			jContentPane.add(getJPanelBoton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelJugador
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelJugador() {
		if (jPanelJugador == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			gridLayout1.setColumns(1);
			jPanelJugador = new JPanel();
			jPanelJugador.setLayout(gridLayout1);
			Border border = BorderFactory.createEmptyBorder(0, 15, 15, 15);
			jPanelJugador.setBorder(border);
			jPanelJugador.add(getJLabelJugador(), null);
			jPanelJugador.add(getJTextNombre(), null);
		}
		return jPanelJugador;
	}

	private JLabel getJLabelJugador() {
		if (jLabelJugador == null) {
			jLabelJugador = new JLabel();
			jLabelJugador.setText("Introduzca su nombre:");
			jLabelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelJugador;
	}

	/**
	 * This method initializes jPanelLongPalabra
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelLongPalabra() {
		if (jPanelLongPalabra == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(2);
			gridLayout2.setColumns(1);
			Border border = BorderFactory.createEmptyBorder(10, 15, 0, 15);
			jPanelLongPalabra = new JPanel();
			jPanelLongPalabra.setLayout(gridLayout2);
			jPanelLongPalabra.setBorder(border);
			jPanelLongPalabra.add(getJLabelLongPalabra(), null);
			jPanelLongPalabra.add(getJSLongPalabra(), null);
		}
		return jPanelLongPalabra;
	}

	private JLabel getJLabelLongPalabra() {
		if (jLabelLongPalabra == null) {
			jLabelLongPalabra = new JLabel();
			jLabelLongPalabra.setText("¿Con cuántas letras desea comenzar?");
		}
		return jLabelLongPalabra;
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
			Border border = BorderFactory.createEmptyBorder(10, 0, 10, 0);
			jPanelBoton.setBorder(border);
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
			jOKButton.setText("Aceptar");
			jOKButton.addActionListener(getControlador());
		}
		return jOKButton;
	}

	private JSlider getJSLongPalabra() {
		if (jSldrLongPalabra == null) {
			jSldrLongPalabra = new JSlider(JSlider.HORIZONTAL, 2, 14, 2);
			jSldrLongPalabra.setMajorTickSpacing(2);
			jSldrLongPalabra.setMinorTickSpacing(1);
			jSldrLongPalabra.setPaintLabels(true);
			jSldrLongPalabra.setPaintTicks(true);
		}
		return jSldrLongPalabra;
	}

	/**
	 * This method initializes jTextNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextNombre() {
		if (jTextNombre == null) {
			jTextNombre = new JTextField();
		}
		return jTextNombre;
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			processExit();
		}

		private void processExit() {
			if (getNombre().equalsIgnoreCase(""))
				VentanaMensaje.getVentanaMensaje().mostrar(
						"Teclee el nombre de usuario");
			else
				setVisible(false);

		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
