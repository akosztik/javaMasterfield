package sikidomokOOP;

public class Teglalap extends Sikidom {
	private int a,b;

	public Teglalap(int a, int b) {
		this.a = a;
		this.b = b;
		keruletSzamol();
		teruletSzamol();
	};
	private void keruletSzamol() {
		setKerulet((a+b)*2);
	}
	

	private void teruletSzamol() {
		
		terulet=a*b;
		
	}
	
}
