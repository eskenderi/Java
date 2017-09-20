import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Dragon extends Thread {
	Random rand;
	public static Semaphore playWithDragon;
	public static Semaphore leaveTable;
	public static int adventurerToPlayWith = -1;
	private int NUM_GAMES = 3;
	private static LinkedList<Integer> players;
	private int results[];
	public Dragon(int num_tables) {
		rand = new Random();
		playWithDragon = new Semaphore(num_tables);//Initialize the semaphore. We have 1 dragon, this semaphore
								//will take num_tables as an argument
		leaveTable = new Semaphore(0);//Dragon will ask each adv to leave one their game is finished
		players = new LinkedList<Integer>();
		results = new int[num_tables];
		setName("Dragon");
	}
	public void run(){
		try {
			sleep(200);
		} catch (InterruptedException e1) {}
		while(Main.adventurers[0].isAlive()){
			//msg(" is starting a new tournament...");
			int cnt = Main.NUM_TABLES;
			while(cnt-- > 0 && playWithDragon.hasQueuedThreads()){
				playWithDragon.release();
			}
			Arrays.fill(results, 0);//reset the game results to 0
			yield();//Let the chosen adventurers "sit" on their tables
			try {
				sleep(100);
			} catch (InterruptedException e) {}
			if(players.size()>0){
				for(int i=0; i<NUM_GAMES; i++){
					for(int pos = 0; pos<players.size(); pos++){
						int adv_id = 0;
						try {
							adv_id = players.get(pos).intValue();
						}catch(NullPointerException ex) {}
						if(this.rollDices()<Main.adventurers[adv_id].rollDices()){//if adv won a game
							results[pos] ++;
						}
					}
				}
				msg("Game is finished."+players.size());
				//Game is finished. Calculating the winners
				for(int i=0; i<results.length; i++){
					if(results[i]>1){//adv won
						msg(" adventurer "+players.get(i)+" won.");
						givePrize(players.get(i));
					}
				}
				leaveTable.release(leaveTable.getQueueLength());//Let the adventurers to leave the game.
				players.clear();
			}
		}
		
	}
	private void givePrize(int id) {
		switch(rand.nextInt(4)){
		case 0:{
			msg(" adventurer "+id+" won a stone");
			Main.adventurers[id].stones++;
			break;
		}
		case 1:{
			msg(" adventurer "+id+" won a ring");
			Main.adventurers[id].rings++;
			break;
		}
		case 2:{
			msg(" adventurer "+id+" won a necklace");
			Main.adventurers[id].necklaces++;
			break;
		}
		case 3:{
			msg(" adventurer "+id+" won an earing");
			Main.adventurers[id].earrings++;
			break;
		}
	}
		
	}
	public static void sitOnTable(int id){
		players.addLast(id);
	}
	public int rollDices(){
		return rand.nextInt(6)+1;
	}
	public void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-Main.startTime)+"] "+getName()+":"+m);
	}
}
