package packInterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import packPasaPalabra.ErrorPalabrasAgotadas;
import packPasaPalabra.GeneradorPalabras;
import packPasaPalabra.Palabra;

public class VentanaPalabra extends JDialog {
	private static final long serialVersionUID = 4150413643656813033L;
	private static VentanaPalabra mVentanaPalabra = new VentanaPalabra();
	private GeneradorPalabras genPalabras = GeneradorPalabras
			.getGeneradorPalabras();
	private Controlador controlador = null;
	private Palabra palabraActual = null;
	private long tiempoInicial;
	private JPanel jContentPane = null;
	private JPanel jPanelBotones = null;
	private JLabel jLabelPuntos = null;
	private JButton jButtonOtra = null;
	private JButton jButtonEmpezar = null;
	private JButton jButtonSalir = null;
	private JPanel jPanelPalabra = null;
	private JLabel jLabelBienvenida = null;
	private JLabel jLabelLetras = null;
	private JTextField jTextPalabra = null;
	private JLabel jLabelMensaje = null;
	
	
	/**
	 * This method initializes
	 * 
	 */
	private VentanaPalabra() {
		super();
		initialize();
	}

	public static VentanaPalabra getVentanaPalabra() {
		return mVentanaPalabra;
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

		this.setVisible(true);
	}

	public int getPuntos() {
		return Integer.parseInt(getJLabelPuntos().getText());
	}

	private void setPuntos(int pPuntos) {
		getJLabelPuntos().setText(String.valueOf(pPuntos));
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(642, 338));
		this.setModal(true);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("PasaPalabra");

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setBorder(BorderFactory
					.createEtchedBorder(EtchedBorder.RAISED));
			jContentPane.add(getJPanelBotones(), BorderLayout.EAST);
			jContentPane.add(getJPanelPalabra(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelBotones
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelBotones() {
		if (jPanelBotones == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setVgap(10);
			gridLayout.setColumns(1);
			jPanelBotones = new JPanel();
			jPanelBotones.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
					BorderFactory.createEmptyBorder(0, 10, 10, 10)));
			jPanelBotones.setLayout(gridLayout);
			jPanelBotones.add(getJLabelPuntos(), null);
			jPanelBotones.add(getJButtonOtra(), null);
			jPanelBotones.add(getJButtonEmpezar(), null);
			jPanelBotones.add(getJButtonSalir(), null);
		}
		return jPanelBotones;
	}

	private JLabel getJLabelPuntos() {
		if (jLabelPuntos == null) {
			jLabelPuntos = new JLabel();
			jLabelPuntos.setForeground(Color.blue);
			jLabelPuntos.setFont(new Font("Dialog", Font.BOLD, 25));
			setPuntos(0);
		}
		return jLabelPuntos;
	}

	/**
	 * This method initializes jButtonOtra
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonOtra() {
		if (jButtonOtra == null) {
			jButtonOtra = new JButton();
			jButtonOtra.setText("Otra");
			jButtonOtra.setEnabled(false);
			jButtonOtra.setActionCommand("Otra");
			jButtonOtra.addActionListener(getControlador());
		}
		return jButtonOtra;
	}

	/**
	 * This method initializes jButtonEmpezar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEmpezar() {
		if (jButtonEmpezar == null) {
			jButtonEmpezar = new JButton();
			jButtonEmpezar.setText("Empezar");
			jButtonEmpezar.setActionCommand("Empezar");
			jButtonEmpezar.addActionListener(getControlador());
		}
		return jButtonEmpezar;
	}

	/**
	 * This method initializes jButtonSalir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setText("Salir");
			jButtonSalir.setActionCommand("Salir");
			jButtonSalir.addActionListener(getControlador());
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jPanelPalabra
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelPalabra() {
		if (jPanelPalabra == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setHgap(20);
			gridLayout1.setVgap(20);
			gridLayout1.setColumns(1);
			jPanelPalabra = new JPanel();
			jPanelPalabra.setBorder(BorderFactory.createEmptyBorder(0, 10, 40,
					10));
			jPanelPalabra.setLayout(gridLayout1);
			jPanelPalabra.add(getJLabelBienvenida(), null);
			jPanelPalabra.add(getJLabelLetras(), null);
			jPanelPalabra.add(getJTextPalabra(), null);
			jPanelPalabra.add(getJLabelMensaje(), null);
		}
		return jPanelPalabra;
	}
	
	private JLabel getJLabelMensaje() {
		if(jLabelMensaje == null){
			jLabelMensaje = new JLabel();
			jLabelMensaje.setText("");
			jLabelMensaje.setForeground(Color.green);
		}
		return jLabelMensaje;
	}

	private JLabel getJLabelBienvenida() {
		if (jLabelBienvenida == null) {
			jLabelBienvenida = new JLabel();
			jLabelBienvenida
					.setText("Pulse \"Empezar\" para comenzar el juego");
			jLabelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelBienvenida.setFont(new Font("SansSerif", Font.BOLD, 12));

		}
		return jLabelBienvenida;
	}

	/**
	 * This method initializes jLabelLetras
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabelLetras() {
		if (jLabelLetras == null) {
			jLabelLetras = new JLabel();
			jLabelLetras.setText("");
			jLabelLetras.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelLetras.setForeground(Color.blue);
			jLabelLetras.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return jLabelLetras;
	}

	/**
	 * This method initializes jTextPalabra
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextPalabra() {
		if (jTextPalabra == null) {
			jTextPalabra = new JTextField();
			jTextPalabra.setColumns(15);
			jTextPalabra.addKeyListener(getControlador());
			jTextPalabra.setEditable(false);
		}
		return jTextPalabra;
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador extends KeyAdapter implements ActionListener {

		@Override
		public void keyReleased(KeyEvent e) {
			Palabra palTecleada = new Palabra(getJTextPalabra().getText());

			if (palTecleada.esIgual(palabraActual)) {
				long tiempoFinal = (new Date()).getTime();
				setPuntos(getPuntos()
						+ (int) (palabraActual.getLongitud() * 100000 / (tiempoFinal - tiempoInicial)));
				getJLabelMensaje().setText("Correcto:\t" + palabraActual.getPalabra());
				getJTextPalabra().setForeground(Color.green);
				getJTextPalabra().setEnabled(false);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase("Salir")) {
				getJButtonEmpezar().setEnabled(true);
				getJButtonOtra().setEnabled(false);
				getJLabelMensaje().setText("");
				setVisible(false);
			} else {
				try {
					getJLabelMensaje().setText("");
					palabraActual = genPalabras.darPalabra();
					getJTextPalabra().setText("");
					getJTextPalabra().setForeground(Color.black);
					getJLabelLetras().setText(
							palabraActual.getPalabraDesordenada());
					getJTextPalabra().setEnabled(true);
					getJTextPalabra().setEditable(true);
					getJTextPalabra().requestFocus();
					tiempoInicial = new Date().getTime();
					if (e.getActionCommand().equalsIgnoreCase("Empezar")) {
						getJButtonEmpezar().setEnabled(false);
						getJButtonOtra().setEnabled(true);
					}

				} catch (ErrorPalabrasAgotadas e1) {
					setVisible(false);
					VentanaMensaje
							.getVentanaMensaje()
							.mostrar(
									"No quedan palabras de longitud mayor o igual a la solicitada");
				}
			}

		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
