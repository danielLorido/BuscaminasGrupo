package control;

import java.awt.EventQueue;

public class Principal extends ParaBuscaMinasUI {
	private static final long serialVersionUID = -8755342985605075849L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaBuscaMinasUI frame = new ParaBuscaMinasUI();
					frame.setVisible(true);
					frame.setTitle("Buscaminas Dani, Alberto e Ismael");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}