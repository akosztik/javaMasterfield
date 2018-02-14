package NKiralyNo;

public class Idozito extends Thread {
	private Vezerek vezerek;
	private boolean futhat=true;
	
	
	public void setFuthat(boolean futhat) {
		this.futhat = futhat;
	}

	public Idozito(Vezerek vezerek) {
		this.vezerek = vezerek;
	}

	@Override
	public void run() {
		while (futhat) {
			
			vezerek.backTrack();
			
			/*try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	
}
