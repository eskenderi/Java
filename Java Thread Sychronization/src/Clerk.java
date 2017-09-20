
public class Clerk extends Thread {
	private int cId;
	public Clerk(int clerkId) {
		cId = clerkId;
		setName("Clerk "+clerkId);
	}
	public void run(){
		while(Main.adventurers[0].isAlive()){//Enter this loop whenever the first adventurer with id 0 is still alive
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(Main.serveToAnAdv() == false){
				yield();//Probably there were no adv to be served
			}else{
				msg(" Served an adventurer.");
			}
		}
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-Main.startTime)+"] "+getName()+":"+m);
	}
}
