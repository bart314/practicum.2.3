package state;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		ColaMachine machine = new ColaMachine();
		System.out.println("Welkom bij de awesome cola-machine.");
		System.out.println("Deze geweldige verfrissende drank nu voor slechts twee euro.");
		System.out.println("Dit ding accepteert munten van €0,50 en €1,00");
		System.out.println("Gooi geld in:");

		while (true) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			in = new Scanner(System.in);
			int foo = in.nextInt();

			machine.insertMoney(foo);
		}
	}

}
