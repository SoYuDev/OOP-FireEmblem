package model;

import java.util.Random;

public class Estudiante {

	private String nombre;
	private String casa;
	private int vida;
	private int ataque;
	private int defensa;
	private int nivel;
	private int maxVida;

	private final int VIDA_LVLUP = 5;
	private final int ATAQUE_LVLUP = 2;
	private final int DEFENSA_LVLUP = 1;

	private final int N_ATTACKS_PJ = 3;

	// CONSTRUCTORES

	// Constructor vacío con NPC por defecto
	public Estudiante() {
		nombre = "Anette";
		casa = "Blue Lions";
		// Generamos un valor aleatorio entre 40 y 60 (Max - Min + 1) + Max
		vida = this.generateRandom(40, 60);
		maxVida = vida;
		ataque = this.generateRandom(7, 12);
		defensa = this.generateRandom(4, 7);
		nivel = 1;
	}

	// Constructor con valores básicos para enemigo
	public Estudiante(String nombre, int vida, int maxVida, int ataque, int defensa) {
		this.nombre = nombre;
		this.vida = vida;
		this.maxVida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	// Constructor completo - nivel ya que siempre será 1.
	public Estudiante(String nombre, String casa, int vida, int maxVida, int ataque, int defensa) {
		this.nombre = nombre;
		this.casa = casa;
		this.vida = vida;
		this.maxVida = maxVida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = 1;
	}

	// GETTERS && SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	// MÉTODOS VARIOS

	public void atacar(Enemigo defensor) {

		if (vida > 0) {

			for (int i = 0; i < N_ATTACKS_PJ; i++) {
				if (defensor.getVida() > 0) {
					int resultado = defensor.getVida() - (this.ataque - defensor.getDefensa());

					System.out.println(nombre + " Ataca a " + defensor.getNombre() + " quitandole " + resultado
							+ " puntos de vida.");
					System.out.println("Ataque número: " + i + " de " + N_ATTACKS_PJ);
					if (resultado < 0) {
						resultado = 0;
					}
					defensor.setVida(resultado);
					defensor.imprimirInfo();

				} else {
					System.out.println(defensor.getNombre() + " está muerto/a");
				}
			}
			checkDestreza(defensor);
		}
	}

	public void checkDestreza(Enemigo enemy) {
		if (enemy.getDestreza() == Destrezas.DEBIL && enemy.getVida() <= 0) {
			subirNivel(1);
		} else if (enemy.getDestreza() == Destrezas.FUERTE && enemy.getVida() <= 0) {
			subirNivel(2);
		}
	}

	public void subirNivel(int index) {
		switch (index) {

		case 1:
			vida += VIDA_LVLUP;
			ataque += ATAQUE_LVLUP;
			defensa += DEFENSA_LVLUP;
			printSubidaNivel();
			break;

		case 2:
			for (int i = 0; i < 2; i++) {
				vida += VIDA_LVLUP;
				ataque += ATAQUE_LVLUP;
				defensa += DEFENSA_LVLUP;
				printSubidaNivel();
			}

			break;

		default:
			System.out.println("Error");
		}
	}

	public int generateRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;

	}

	// MÉTODOS DE IMPRESIÓN
	public String toString() {
		String info = "Estudiante: " + nombre + "\nCasa: " + casa + "\nVida: " + vida + "\nAtaque: " + ataque
				+ "\nDefensa: " + defensa + "\nNivel: " + nivel;
		return info;
	}

	public void imprimirInfo() {

		System.out.println(toString());
	}

	public void printSubidaNivel() {
		System.out.println("Has subido de nivel!\n" + "Vida: " + vida + "/" + maxVida + " +" + VIDA_LVLUP + "\n"
				+ "Ataque: " + ataque + " +" + ATAQUE_LVLUP + "\n" + "Defensa: " + ataque + " +" + ATAQUE_LVLUP + "\n");
	}

}
