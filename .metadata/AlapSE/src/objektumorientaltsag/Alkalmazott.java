package objektumorientaltsag;

public class Alkalmazott {
	private String nev;
	private int kor;
	private int fizetes;
	
	public Alkalmazott(String nev, int kor, int fizetes) {
		this.nev = nev;
		this.kor = kor;
		this.fizetes = fizetes;
	}
	
	@Override
	public String toString() {
		return "Alkalmazott [név=" + nev + ", kor=" + kor + ", fizetés=" + fizetes + "]";
	}

	public Alkalmazott() {
		
	}
	
	public void fizetesEmeles() {
		this.fizetes+=5000;
	}
	public void fizetesEmeles(int emeles) {
		this.fizetes+=emeles;
	}
	public void fizetesEmeles(double szazalek) {
		this.fizetes*=(szazalek/100);
	}
	
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getFizetes() {
		return fizetes;
	}
	public void setFizetes(int fizetes) {
		this.fizetes = fizetes;
	}
	
	
}
