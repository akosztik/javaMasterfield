package feladatoop2;

public class KonyvesPolc {
	private int polcok;
	private int kapacitas=10;
	private int[] konyvek;
	public KonyvesPolc(int polcok) {
		this.polcok = polcok;
		konyvek=new int[polcok];
	}
	
	public KonyvesPolc() {
		polcok = 5;
		konyvek=new int[5];
	}
	public KonyvesPolc(int polcok, int[] konyvek) {
		this.polcok = polcok;
		this.konyvek = konyvek;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < konyvek.length; i++) {
			for (int j = 0; j < kapacitas; j++) {
				String hely=(j<konyvek[i]?"X":"O"); //h�rmas oper�tor
				sb.append(hely);
				
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void add(int polc, int mennyiseg) {
		konyvek[polc]+=mennyiseg;
		if (konyvek[polc]>kapacitas) {
			konyvek[polc]=kapacitas;
		}
	}
	public void add(int mennyiseg) {
		for (int i = 0; i < konyvek.length; i++) {
			add(i,mennyiseg);
		}
	}

	public int countKonyvek() {
		int osszeg=0;
		for (int i = 0; i < konyvek.length; i++) {
			osszeg+=konyvek[i];
		}
		return osszeg;
		
	}
	
	
}
