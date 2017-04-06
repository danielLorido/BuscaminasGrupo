package modelo;

public class Tablero {
	private Casilla[][] casillas;
	private int tamano;
	private int numMinas = 9;

	public Tablero(int cuadrada) {
		super();
		this.tamano = cuadrada;
		generarTablero(cuadrada);
	}

	/**
	 * Generará el tablero cuadrado con las casillas, las minas y los números
	 * 
	 * @param cuadrada
	 *            Número de filas y columnas
	 */
	// private void generarTablero(int cuadrada) {
	public void generarTablero(int cuadrada) {
		// Inicializo la matriz
		casillas = new Casilla[cuadrada][cuadrada];
		// Lo relleno de Casillas
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
		// Pongo las minas
		colocarMinas(numMinas, cuadrada);
		// Rellenar Numeros
		rellenarNumeros(cuadrada);
	}

	/**
	 * Recorre el tablero buscando las minas y cuando encuentra una le suma uno
	 * a todas sus casillas de alrededor, exceptuando las que sean minas
	 * 
	 * @param dimension
	 */
	// private void rellenarNumeros(int dimension) {
	public void rellenarNumeros(int dimension) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j].isMina()) {
					enumerarMina(i, j);
				}
			}
		}
	}

	/**
	 * Suma uno a todas las casillas validas que estén alrededor de dicha mina
	 * 
	 * @param columna
	 * @param fila
	 */
	// private void enumerarMina(int columna, int fila) {
	public void enumerarMina(int columna, int fila) {
		int[][] adyacentes = { { -1, -1 }, { -1, 0 }, { -1, 1 },

				{ 0, -1 }, /* MINA */ { 0, 1 },

				{ 1, -1 }, { 1, 0 }, { 1, 1 } };

		for (int i = 0; i < adyacentes.length; i++) {
			int columnaNueva = columna + (adyacentes[i][0]);
			int filaNueva = fila + (adyacentes[i][1]);
			if (validarCordenada(columnaNueva, filaNueva)) {
				if (!casillas[columnaNueva][filaNueva].isMina()) {
					casillas[columnaNueva][filaNueva].sumarAlrededor();
				}
			}
		}
	}

	/**
	 * Comprueba que la coordenada está entre los valores validos del tablero
	 * 
	 * @param columna
	 * @param fila
	 * @return true si es valida o false en caso contrario
	 */
	// private boolean validarCordenada(int columna, int fila) {
	public boolean validarCordenada(int columna, int fila) {
		if (columna >= 0 && columna < casillas.length && fila >= 0 && fila < casillas.length) {
			return true;
		}
		return false;
	}

	/**
	 * Coloca las minas por posiciones aleatorias en el tablero vacío
	 * 
	 * @param numMinas
	 *            La cantidad de minas que quieres poner
	 * @param dimension
	 *            El numero de ancho y alto del tablero
	 */
	// private void colocarMinas(int numMinas, int dimension) {
	public void colocarMinas(int numMinas, int dimension) {
		int columna;
		int fila;
		do {
			// Aquí multiplicar esto para que me dé entre 0 y dimension
			columna = (int) (Math.random() * (dimension));
			fila = (int) (Math.random() * (dimension));
			if (!casillas[columna][fila].isMina()) {
				casillas[columna][fila].setMina(true);
				numMinas--;
			}
		} while (numMinas > 0);
	}

	/**
	 * Obtengo una casilla a traves de un objeto de la clase Coordenada
	 * 
	 * @param coordenada
	 *            Coordenada con dos valores x e y
	 * @return Una casilla específica en el tablero
	 */
	public Casilla getCasilla(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()];
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public int getNumMinas() {
		return numMinas;
	}

	public void setNumMinas(int numMinas) {
		this.numMinas = numMinas;
	}

	public int getAlto() {
		return casillas.length;
	}

	public int getAncho() {
		return casillas[0].length;
	}

	public boolean isMarcada(int i, int j) {
		return casillas[i][j].isMarcada();
	}
}
