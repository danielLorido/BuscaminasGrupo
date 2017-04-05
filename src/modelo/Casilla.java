package modelo;

public class Casilla {

	private boolean velada = true;
	private boolean marcada = false;
	private boolean mina = false;
	private int minasAlrededor = 0;

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public int getminasAlrededor() {
		return minasAlrededor;
	}

	public void setminasAlrededor(int minasAdyacentes) {
		this.minasAlrededor = minasAdyacentes;
	}

	/**
	 * Añade uno en caso de que tenga una mina alrededor
	 */
	public void sumarAlrededor() {
		minasAlrededor += 1;

	}
}
