package controller;

import model.*;

public class Main {

	public static void main(String[] args) {

		GameManager gm = new GameManager();

		gm.bienvenida();
		// Hacer como otra parte de asignacion de enemigos, combate y final...
		gm.setNOfEnemies();
		
		gm.assignEnemiesToFight();
	}

}
