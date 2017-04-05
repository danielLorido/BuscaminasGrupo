package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BuscaMinasUI extends JFrame {
	
	private static final long serialVersionUID = -7308092302593191910L;
	protected JPanel contentPane;
	protected JMenuItem mntmNuevoJuego;
	protected JPanel pnlBotonera;
	public JButton[][] botonera;
	protected JPanel panel;
	protected JLabel lblNumMinas;

	/**
	 * Create the frame.
	 */
	public BuscaMinasUI() {
		setMinimumSize(new Dimension(700, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscaMinasUI.class.getResource("/iconos/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);

		mntmNuevoJuego = new JMenuItem("Nuevo Juego");
		mnJuego.add(mntmNuevoJuego);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblMineSwepper = new JLabel("MineSwepper");
		lblMineSwepper.setForeground(Color.ORANGE);
		lblMineSwepper.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMineSwepper.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMineSwepper, BorderLayout.NORTH);

		pnlBotonera = new JPanel();
		pnlBotonera.setBackground(SystemColor.activeCaption);
		contentPane.add(pnlBotonera, BorderLayout.CENTER);
		pnlBotonera.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbl = new JLabel("N\u00FAmero de Minas");
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		panel.add(lbl, gbc_lbl);
		
		lblNumMinas = new JLabel("");
		lblNumMinas.setForeground(new Color(250, 128, 114));
		lblNumMinas.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNumMinas = new GridBagConstraints();
		gbc_lblNumMinas.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumMinas.gridx = 1;
		gbc_lblNumMinas.gridy = 0;
		panel.add(lblNumMinas, gbc_lblNumMinas);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		GridBagConstraints gbc_lblTiempo = new GridBagConstraints();
		gbc_lblTiempo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTiempo.gridx = 0;
		gbc_lblTiempo.gridy = 1;
		panel.add(lblTiempo, gbc_lblTiempo);
	}

}
