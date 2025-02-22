package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

	// VARIABLES
	private final String[] MAIN_CHARS = { "Edelgard", "Dimitri", "Claude" };
	private final String[] MAIN_HOUSES = { "Aguilas Negras", "Leones Azules", "Ciervos Dorados" };
	private final String[] INFO_FOR_SELECTION = { MAIN_CHARS[0] + " - " + MAIN_HOUSES[0],
			MAIN_CHARS[1] + " - " + MAIN_HOUSES[1], MAIN_CHARS[2] + " - " + MAIN_HOUSES[2] };

	private final int N_MIN_ENEMIES = 2;
	private final int N_MAX_ENEMIES = 5;

	private int nOfEnemies = 0;
	private ArrayList<Enemigo> totalEnemigos = new ArrayList<Enemigo>();
	private ArrayList<Enemigo> enemigosToFight = new ArrayList<Enemigo>();;

	Estudiante pj = new Estudiante();
	Enemigo currentEnemy = new Enemigo();

	Scanner sc = new Scanner(System.in);

	public void bienvenida() {

		System.out.println("Bienvenido al mundo de Fire Emblem Three Houses.\n");

		assignListOfEnemies();

		assignChar();
	}

	// Muestra los elementos de un Array en un menú.
	public void displayMenu(String[] arrayString) {
		System.out.println("Elige entre alguna de las siguientes opciones: ");
		for (int i = 0; i < arrayString.length; i++) {
			System.out.println((i + 1) + ".-" + arrayString[i] + "\n");
		}
	}

	// Devuelve el indice el personaje seleccionado.
	public int selectChar() {

		int index = 0;

		displayMenu(INFO_FOR_SELECTION);
		do {
			index = sc.nextInt();
			sc.nextLine();

			if (index < 1 || index > MAIN_CHARS.length) {
				System.out.println("Error, por favor introduce un valor entre " + 1 + " y " + MAIN_CHARS.length + "\n");
			}
		} while (index < 1 || index > MAIN_CHARS.length);
		return index;

	}

	// Asigna al personaje y crea una instancia en función de la elección.
	public void assignChar() {
		int indexSelectedChar = selectChar();
		switch (indexSelectedChar) {

		case 1:
			// La resta se hace para acceder al verdadero elemento del Array. Ya que para el
			// usuario empezamos por 1 y no 0
			setNameAndHouse(indexSelectedChar - 1);
			printPjSelection();
			break;

		case 2:
			setNameAndHouse(indexSelectedChar - 1);
			printPjSelection();

		case 3:
			setNameAndHouse(indexSelectedChar - 1);
			printPjSelection();

		default:
			System.out.println("Error");

		}
	}

	public void setNOfEnemies() {

		int n = 0;

		do {
			System.out.println(
					"Selecciona cuantos enemigos quieres entrenar, de: " + N_MIN_ENEMIES + " a " + N_MAX_ENEMIES);
			n = sc.nextInt();
			sc.nextLine();
		} while (n < N_MIN_ENEMIES || n > N_MAX_ENEMIES);
		nOfEnemies = n;
		System.out.println("Perfecto, has seleccionado " + nOfEnemies + " enemigos con los que combatir.");
	}

	public void setNameAndHouse(int index) {
		pj.setNombre(MAIN_CHARS[index]);
		pj.setCasa(MAIN_HOUSES[index]);
	}

	public int generateRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;

	}

	public void assignListOfEnemies() {

		Enemigo enemCabOro = new Enemigo("Caballero Oro", Destrezas.DEBIL);
		totalEnemigos.add(enemCabOro);

		Enemigo enemVestal = new Enemigo("Vestal", Destrezas.FUERTE);
		totalEnemigos.add(enemVestal);

		Enemigo enemBalrog = new Enemigo("Balrog", Destrezas.FUERTE);
		totalEnemigos.add(enemBalrog);

		Enemigo enemBruja = new Enemigo("Bruja", Destrezas.DEBIL);
		totalEnemigos.add(enemBruja);

		Enemigo enemMagoArcano = new Enemigo("Mago Arcano", Destrezas.DEBIL);
		totalEnemigos.add(enemMagoArcano);

	}

	public void assignListOfEnemiesToFight() {
		setNOfEnemies();
		for (int i = 0; i < nOfEnemies; i++) {
			enemigosToFight.add(totalEnemigos.get(i));
			System.out.println("Se ha añadido el enemigo: " + totalEnemigos.get(i).getNombre() + " a la lista");
		}
	}
	
	public void assignCurrentEnemy() {
		// Generamos un valor aleatorio entre 0 y el número de enemigos especificado
		// Le restamos - 1 porque este número irá al índice de un Array.
		int random = generateRandom(0, nOfEnemies - 1);
		currentEnemy = enemigosToFight.get(random);
		System.out.println("Se ha asignado el siguiente enemigo: \n");
		currentEnemy.imprimirInfo();
	}
	
	public void combate() {
		while(pj.getVida() > 0 && currentEnemy.getVida() > 0) {
			pj.atacar(currentEnemy);
			currentEnemy.atacar(pj);
			pj.imprimirInfo();
			currentEnemy.imprimirInfo();
		}
		}
		

	public void printEnemies(ArrayList<Enemigo> enemiesToPrint) {
		for (Enemigo enem : enemiesToPrint) {
			enem.imprimirInfo();
		}
	}
	
	public void printPjSelection() {
		System.out.println("Has seleccionado a: ");
		pj.imprimirInfo();
	}
}
