package feladatoop7;

public class Bronze implements Csomag{

	protected int elofizetesiDij;
	protected int percDij;
	protected int smsDij;
	
	public Bronze() {
		init(2000,18,25);
	}

	protected void init(int elofizetesiDij, int percDij, int smsDij) {
		this.elofizetesiDij=elofizetesiDij;
		this.percDij=percDij;
		this.smsDij=smsDij;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	public int getHaviDij(int percek, int smssek) {
		int haviDij= percDij*percek+smsDij*smssek;
		if (haviDij< elofizetesiDij) {
			haviDij=elofizetesiDij;
		}
		return haviDij;
	}	
	
}
