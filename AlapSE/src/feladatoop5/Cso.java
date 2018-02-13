package feladatoop5;

public class Cso extends TomorHeger{
	private double belsoSug;

	public Cso(double magassag, double sugar, double suruseg, double belsoSug) {
		super(magassag, sugar, suruseg);
		this.belsoSug = belsoSug;
	}

	@Override
	public double getFelszin() {
		// TODO Auto-generated method stub
		return super.getFelszin()+new Henger(magassag,belsoSug).getFelszin()-4*belsoSug*belsoSug*Math.PI;
	}

	@Override
	public double getTerfogat() {
		// TODO Auto-generated method stub
		return super.getTerfogat()-new Henger(magassag,belsoSug).getTerfogat();
	}
	
}
