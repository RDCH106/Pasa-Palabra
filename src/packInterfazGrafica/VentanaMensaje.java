package packInterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaMensaje extends JDialog {
	private static final long serialVersionUID = -4514747507968832184L;
	private JPanel jContentPane = null;
	private JTextArea jMessageTextArea = null;
	private JPanel jPanelBoton = null;
	private JButton jOKButton = null;
	private JScrollPane jMessageScrollPane = null;
	private Controlador controlador;
	private static VentanaMensaje mVentanaMensaje = new VentanaMensaje();

	// CONSTRUCTORA
	private VentanaMensaje(Frame frame) {
		super(frame, "ERROR", true);
		initialize();
	}

	private VentanaMensaje() {
		this(null);
	}

	public static VentanaMensaje getVentanaMensaje() {
		return mVentanaMensaje;
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(672, 201));
		this.setContentPane(getJContentPane());

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
			jContentPane.add(getJPanelBoton(), BorderLayout.SOUTH);
			jContentPane.add(getJMessageScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jMessageTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJMessageTextArea() {
		if (jMessageTextArea == null) {
			jMessageTextArea = new JTextArea();
			jMessageTextArea.setEditable(false);
		}
		return jMessageTextArea;
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
			jOKButton.addActionListener(getControlador());
		}
		return jOKButton;
	}

	/**
	 * This method initializes jMessageScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJMessageScrollPane() {
		if (jMessageScrollPane == null) {
			jMessageScrollPane = new JScrollPane(getJMessageTextArea());
		}
		return jMessageScrollPane;
	}

	public void mostrar(String pMensaje) {
		getJMessageTextArea().setEditable(true);
		getJMessageTextArea().setText(pMensaje);
		this.setModal(true);
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

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener {

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent pE) {
			setVisible(false);
		}

	}
} // @jve:decl-index=0:visual-constraint="10,10"
