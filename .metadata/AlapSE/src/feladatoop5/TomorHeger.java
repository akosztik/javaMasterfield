package feladatoop5;

public class TomorHeger extends Henger {
	private double suruseg;

	public TomorHeger(double magassag, double sugar, double suruseg) {
		super(magassag, sugar);
		this.suruseg = suruseg;
	}
	public double getTomeg() {
		return getTerfogat()*suruseg;
		
	}
}
