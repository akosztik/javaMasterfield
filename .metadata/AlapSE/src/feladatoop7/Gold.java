package feladatoop7;

public class Gold extends Silver {
	
	protected int ingyenPerc;
	
	public Gold() {
		init(4000,12,15);
		ingyenSMS=20;
		ingyenPerc=30;
	}
	@Override
	public int getHaviDij(int percek,int smsek) {
		percek-=ingyenPerc;
		if (percek<0) {
			percek=0;
		}
		return super.getHaviDij(percek, smsek);
	}
}
