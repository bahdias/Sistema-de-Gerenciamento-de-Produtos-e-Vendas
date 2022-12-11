package Visao;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		new Menu().showMenu(scanner);
		scanner.close();

	}

}
