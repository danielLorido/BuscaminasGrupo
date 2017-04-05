package modelo;

public class Coordenada {
	private int x, y;

	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Establece una cadena de cuatro caracteres que reprentará la posicion de
	 * un botón en el tablero
	 * 
	 * @return Una cadena de 4 caracteres
	 */
	public String establecerCoordenadas() {
		String cadena = "";
		if (x <= 9) {
			cadena += "0" + x;
		} else {
			cadena += x;
		}

		if (y <= 9) {
			cadena += "0" + y;

		} else {
			cadena += y;
		}
		return cadena;
	}
}
