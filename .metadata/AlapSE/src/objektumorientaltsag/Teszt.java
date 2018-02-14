package objektumorientaltsag;

public class Teszt {
	public static void main(String[] args) {
		Alkalmazott alk1=new Alkalmazott();//üres konstruktor
		alk1.setNev("Kosztik Anett");
		Alkalmazott alk2= new Alkalmazott();
		alk2.setNev("Kardos Istvan");
		System.out.println(alk1.getNev());
		System.out.println(alk2.getNev());
		alk1.setFizetes(1000);
		alk1.fizetesEmeles();
		System.out.println(alk1.getFizetes());
		alk1.fizetesEmeles(4000);
		System.out.println(alk1.getFizetes());
		alk1.fizetesEmeles(5.);
		Alkalmazott alk3= new Alkalmazott("Kiss Edina", 36, 100000);
		alk3.toString();
		
	}
}
