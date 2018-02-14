package feladatoop7;

public class Elofizeto {
	private String nev;
	private Bronze csomag;
	private int haviPercek;
	private int haviSMS;
	
	public Elofizeto(String nev, int haviPercek, int haviSMS) {
		super();
		this.nev = nev;
		this.haviPercek = haviPercek;
		this.haviSMS = haviSMS;
		rentable();
	}

	private void rentable() {
		Bronze bronze=new Bronze();
		Silver silver=new Silver();
		Gold gold=new Gold();
		if(bronze.getHaviDij(haviPercek, haviSMS)<silver.getHaviDij(haviPercek, haviSMS)&&bronze.getHaviDij(haviPercek, haviSMS)<gold.getHaviDij(haviPercek, haviSMS)) {
			this.csomag=bronze;
			
		}else {
			if(silver.getHaviDij(haviPercek, haviSMS)<gold.getHaviDij(haviPercek, haviSMS)) {
				this.csomag=silver;
			
			}else {
				this.csomag=gold;
			}
		}
	}

	@Override
	public String toString() {
		return "Elofizeto [nev=" + nev + ", csomag=" + csomag + ", haviPercek=" + haviPercek + ", haviSMS=" + haviSMS
				+ "]";
	}
	
	
	
	
}
