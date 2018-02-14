package sikidomokOOP;

public class Kor extends Sikidom{
	
	private double sugar;
	
	public Kor(double sugar) {
		this.sugar=sugar;
		teruletSzamol();
		keruletSzamol();
		
		// TODO Auto-generated constructor stub
	}

	private void keruletSzamol() {
		setKerulet(2*sugar*Math.PI);
		
	}
	

	private void teruletSzamol() {
		terulet=sugar*sugar*Math.PI;
		
	}
	public void testKor() {
		System.out.println("Kor vagyok");
	}
	
}
