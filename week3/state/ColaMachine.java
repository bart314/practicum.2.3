package state;

//Context class
public class ColaMachine {
	private State curState;
	
	ColaMachine() {
		setState(new StartState());
	}
	
	void insertMoney(int howMuch) {
		System.out.println("Received " + howMuch);
		if (howMuch==50) curState.insertFiftyCents(this);
		else if (howMuch==100) curState.insertOneEuro(this);
		else System.out.println("Coin rejected.");
	}
	
	void giveStatus(String feedback) {
		System.out.println(feedback);
	}
	
	void giveCola() {
		System.out.println("Lekker veel suiker en cafeïne; enjoy");
		System.out.println("Saldo: weer nul.");
		System.out.println("Werp geld in:");
		
	}
	
	void returnMoney(int amount) {
		System.out.println("Geld terug: " + amount);
	}
	
	void setState (State newState) {
		curState = newState;
	}
	
	State getState() {
		return curState;
	}
	

}
