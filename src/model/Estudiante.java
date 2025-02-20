package model;

import java.util.Random;

public class Estudiante {

	private String nombre;
	private String casa;
	private int vida;
	private int ataque;
	private int defensa;
	private int nivel;

	// CONSTRUCTORES

	// Constructor vacío con NPC por defecto
	public Estudiante() {
		nombre = "Anette";
		casa = "Blue Lions";
		// Generamos un valor aleatorio entre 40 y 60 (Max - Min + 1) + Max
		vida = this.generateRandom(40, 60);
		ataque = this.generateRandom(7, 12);
		defensa = this.generateRandom(4, 7);
		nivel = 1;
	}

	// Constructor con valores básicos para enemigo
	public Estudiante(String nombre, int vida, int ataque, int defensa) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	// Constructor completo - nivel ya que siempre será 1.
	public Estudiante(String nombre, String casa, int vida, int ataque, int defensa) {
		this.nombre = nombre;
		this.casa = casa;
		this.vida = vida;
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

	public void atacar(Estudiante defensor) {

		if (vida > 0) {
			if (defensor.getVida() > 0) {
				int resultado = defensor.getVida() - (this.ataque - defensor.getDefensa());

				defensor.setVida(resultado);

				defensor.imprimirInfo();

			} else {
				System.out.println(defensor.getNombre() + " está muerto/a");
			}
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

}
