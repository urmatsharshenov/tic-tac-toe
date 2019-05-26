package common;

import common.view.Menu;

public class Game {
	public static void main(String[] args) {

		Menu newgame = new Menu();
		System.out.println(newgame.getTitle() + " " + newgame.getName());
	}
}
