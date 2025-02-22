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

	private final int[] VIDA_LVLUP = { 5, 8 };
	private final int[] ATAQUE_LVLUP = { 2, 3 };
	private final int[] DEFENSA_LVLUP = { 1, 2 };
	private final int CURA_VIDA_LVLUP = 10;

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
				// Compruebo en cada ataque si el defensor está vivo
				if (defensor.getVida() > 0) {
					// Comprobación del daño a hacer
					int dmgToDo = this.ataque - defensor.getDefensa();

					if (dmgToDo <= 0) {
						dmgToDo = 1;
					}
					int resultado = defensor.getVida() - dmgToDo;

					System.out.println(nombre + " Ataca a " + defensor.getNombre() + " quitandole " + dmgToDo
							+ " puntos de vida. - " + "Ataque número: " + (i + 1) + " de " + N_ATTACKS_PJ);
					
					if (resultado < 0) {
						resultado = 0;
					}
					defensor.setVida(resultado);
				}
			}
			// Si el defensor ha sido derrotado...
			if (defensor.getVida() <= 0) {
				System.out.println(defensor.getNombre() + " ha sido debilitado/a!");
				checkDestreza(defensor);
				// Este else lo pongo para la info de la consola.
			} else {
				defensor.imprimirInfo();
			}
		}
	}

	public void checkDestreza(Enemigo enemy) {
		if (enemy.getDestreza() == Destrezas.DEBIL) {
			System.out.println("El enemigo era de destreza: " + enemy.getDestreza() + " subes 1 nivel!");
			subirNivel(1);
		} else if (enemy.getDestreza() == Destrezas.FUERTE) {
			System.out.println("El enemigo era de destreza: " + enemy.getDestreza() + " subes 2 niveles!");
			subirNivel(2);
		}
	}

	public void subirNivel(int index) {
		switch (index) {

		case 1:
			subirStatsMasLvl(index);
			printSubidaNivel(index - 1);
			curarAlSubirLvl();
			break;

		case 2:
			subirStatsMasLvl(index);
			printSubidaNivel(index - 1);
			// Como sube de nivel dos veces dos curas...
			for (int i = 0; i < index; i++) {
				curarAlSubirLvl();
			}
			break;

		default:
			System.out.println("Error");
		}
	}

	public void curarAlSubirLvl() {

		if (vida + CURA_VIDA_LVLUP > maxVida) {
			System.out.println("Al subir de nivel recuperas: " + (maxVida - vida) + " puntos de vida!");
			vida = maxVida;
			
		} else {
			System.out.println("Al subir de nivel recuperas: " + CURA_VIDA_LVLUP + " puntos de vida!");
			vida += CURA_VIDA_LVLUP;

		}
		
		imprimirInfo();
	}

	public void subirStatsMasLvl(int i) {
		maxVida += VIDA_LVLUP[i - 1];
		ataque += ATAQUE_LVLUP[i - 1];
		defensa += DEFENSA_LVLUP[i - 1];
		nivel += i;
	}

	public int generateRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;

	}

	// MÉTODOS DE IMPRESIÓN
	public String toString() {
		String info = "Estudiante: " + nombre + "\nCasa: " + casa + "\nVida: " + vida + "/" + maxVida + "\nAtaque: " + ataque
				+ "\nDefensa: " + defensa + "\nNivel: " + nivel + "\n";
		return info;
	}

	public void imprimirInfo() {

		System.out.println(toString());
	}

	public void printSubidaNivel(int i) {
		System.out.println("Has subido " + (i + 1) + " nivel/es!\n" + "Vida: " + vida + "/" + maxVida + " +"
				+ VIDA_LVLUP[i] + "\n" + "Ataque: " + ataque + " +" + ATAQUE_LVLUP[i] + "\n" + "Defensa: " + ataque
				+ " +" + ATAQUE_LVLUP[i] + "\n");
	}

}
