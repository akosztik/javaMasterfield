package sikidomokOOP;

public class Haromszog extends Sikidom {
	private int a, b, c;

	public Haromszog(int a, int b, int c) {

		this.a = a;
		this.b = b;
		this.c = c;
		keruletSzamol();
		teruletSzamol();
	}
	private void keruletSzamol() {
		setKerulet(a+b+c);
	}
	

	private void teruletSzamol() {
		double s=getKerulet()/2;
		terulet=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
	}
}
