package feladatoop7;

public class Silver extends Bronze {
	protected int ingyenSMS;

	public Silver() {
		init(3000,15,20);
		this.ingyenSMS = 15;
	}

	@Override
	public int getHaviDij(int percek,int smsek) {
		smsek-=ingyenSMS;
		if (smsek<0) {
			smsek=0;
		}
		return super.getHaviDij(percek, smsek);
	}
	
	
	
}
