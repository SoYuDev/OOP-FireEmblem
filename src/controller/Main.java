package controller;

import model.*;

public class Main {

	public static void main(String[] args) {

		GameManager gm = new GameManager();
		// Bienvenida
		gm.bienvenida();
		// Selección número enemigos y asignación de los mismos
		gm.assignListOfEnemiesToFight();
		// Asignación aleatoria del enemigo.
		gm.assignCurrentEnemy();
		// juego
		gm.juego();
	}

}
