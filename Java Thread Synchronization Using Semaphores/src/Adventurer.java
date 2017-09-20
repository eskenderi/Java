import java.util.Random;

public class Adventurer extends Thread {
	Random rand = new Random();
	private int id;
	public int stones, rings, necklaces, earrings, fortune_size;
	public Adventurer(int id) {
		this.id = id;
		stones = rand.nextInt(4);
		necklaces = rand.nextInt(4);
		earrings = rand.nextInt(4);
		rings = rand.nextInt(4);
		setName("Adventurer "+ this.id);
	}
	public void run(){
		try {
			sleep(500);//Sleep implemented so every thread, including dragon and clerks, will be initialized and run as well
		} catch (InterruptedException e) {}
		while(fortuneAccumulated() == false){
			if(gotMagicalObject()){
				msg(" got new Magical object");
				gotoShop();
				sellJewels();
			}else{//play with the dragon
				getIntoDragonFightList();
				printStatus();
				playWithDragon();
				
				yield();
			}
		}
		goHome();
	}
	public boolean gotMagicalObject(){
		if(stones>0){
			if(rings>0 || necklaces>0 || earrings>0)
				return true;
		}
		return false;
	}
	public void gotoShop(){
		msg(" is on his way to the shop.");
		try {
			sleep(rand.nextInt(1000)+500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg(" is waiting in the shop queue.");
		getIntoShopLine();
	}
	synchronized void getIntoShopLine() {
		try {
			Main.shopTurn.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized void getIntoDragonFightList(){
		try {
			Main.dragon.playWithDragon.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//sit on one of the dragon's tables
		Dragon.sitOnTable(id);
		msg(" got a table to play with dragon.");
	}
	private void playWithDragon() {
		try {
			Dragon.leaveTable.acquire();
		} catch (InterruptedException e) {}		
	}
	public boolean fortuneAccumulated(){
		if (this.fortune_size >= Main.FORTUNE_SIZE){
			msg(" collected all the fortune required...");
			return true;
		}
		return false;
	}
	public void sellJewels(){
		while(gotMagicalObject()){
			this.fortune_size ++;
			stones --;
			if(rings>0)
				rings--;
			else
				if(necklaces>0)
					necklaces--;
				else
					if(earrings>0)
						earrings--;
		}
	}
	public void printStatus(){
		msg(" is waiting to fight the dragon...");
		msg(" got "+fortune_size+" fortunes until now.");
		msg(" has: "+stones+" stones,"+rings+" rings,"+necklaces+" necklaces,"+earrings+" earrings");
	}

	public int rollDices(){
		return rand.nextInt(6)+1;
	}
	public void goHome(){
		msg(" is ready to go home.");
		if(Main.exitSemaphore.getQueueLength() == Main.NUM_ADV-1){
			//This means all the other adventurers (num_adv-1) already got an exiting lock.
			Main.exitSemaphore.release();//Give the right to exit to another adventurer
			//exit naturally
		}else{//acquire an exiting right/lock
			try {
				Main.exitSemaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//release another exit right/lock. 
			Main.exitSemaphore.release();
			//Exit naturally
		}
		
		msg(" went back to his home.");
	}
	public void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-Main.startTime)+"] "+getName()+":"+m);
	}
}
