package feladatoop5;

public class Henger {
	protected double magassag;
	private double sugar;
	public Henger(double magassag, double sugar) {
		this.magassag = magassag;
		this.sugar = sugar;
	}
	public double getFelszin() {
		return Math.pow(sugar, 2)*Math.PI*2+2*sugar*Math.PI*magassag;
	}
	public double getTerfogat() {
		return Math.pow(sugar, 2)*Math.PI*magassag;
	
	}
	
}
