package model;

public class Enemigo extends Estudiante {

	private Destrezas destreza;

	private final int VIDA_DEBIL = 30;
	private final int VIDA_FUERTE = 50;

	private final int ATAQUE_FUERTE = 10;
	private final int ATAQUE_DEBIL = 8;

	private final int DEFENSA_FUERTE = 4;
	private final int DEFENSA_DEBIL = 2;

	// CONSTRUCTORES

	// Constructor Vacío
	public Enemigo() {
		super("Enemigo básico", 30, 30, 8, 2);
		destreza = Destrezas.DEBIL;
	}

	// Constructor Completo
	public Enemigo(String nombre, int vida, int maxVida, int ataque, int defensa, Destrezas destreza) {
		super(nombre, vida, maxVida, ataque, defensa);
		this.destreza = destreza;
	}

	// Constructor específico para facilitar el uso en el código.
	public Enemigo(String nombre, Destrezas destreza) {
		// Siempre hay que llamar primero al super constructor
		super("Paquito", 30, 30, 8, 2);
		if (destreza.equals(Destrezas.DEBIL)) {
			this.setVida(VIDA_DEBIL);
			this.setMaxVida(VIDA_DEBIL);
			this.setAtaque(ATAQUE_DEBIL);
			this.setDefensa(DEFENSA_DEBIL);
		} else {
			this.setVida(VIDA_FUERTE);
			this.setMaxVida(VIDA_FUERTE);
			this.setAtaque(ATAQUE_FUERTE);
			this.setDefensa(DEFENSA_FUERTE);
		}
		this.setNombre(nombre);
		this.destreza = destreza;
	}

	// GETTERS && SETTERS

	public Destrezas getDestreza() {
		return destreza;
	}

	public void setDestreza(Destrezas destreza) {
		this.destreza = destreza;
	}

	// MÉTODOS DE IMPRESIÓN.

	@Override
	public String toString() {
		String infoEnemigo = "Enemigo: " + this.getNombre() + "\nVida: " + this.getVida() + "\nAtaque: "
				+ this.getAtaque() + "\nDefensa: " + this.getDefensa() + "\nDestreza: " + this.getDestreza() + "\n";
		return infoEnemigo;
	}

	@Override
	public void imprimirInfo() {

		System.out.println(toString());
	}

}
