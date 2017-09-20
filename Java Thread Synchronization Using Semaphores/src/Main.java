
import java.util.concurrent.Semaphore;

public class Main {
	public static int NUM_ADV = 6, FORTUNE_SIZE = 5, NUM_CLERKS = 2, NUM_TABLES = 3;
	public static Adventurer adventurers[];
	public static Clerk clerks[];
	public static Dragon dragon;
	public static Semaphore shopTurn;
	public static Semaphore exitSemaphore;
	public static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		if(args.length == 4){
			NUM_ADV = Integer.parseInt(args[0]);
			FORTUNE_SIZE = Integer.parseInt(args[1]);
			NUM_CLERKS = Integer.parseInt(args[2]);
			NUM_TABLES = Integer.parseInt(args[3]);
		}
		adventurers = new Adventurer[NUM_ADV];
		clerks = new Clerk[NUM_CLERKS];
		dragon = new Dragon(NUM_TABLES);
		
		shopTurn = new Semaphore(0);//Initialize the clerk serving semaphore
		exitSemaphore = new Semaphore(0);//Initialize the adv exiting semaphore
		
		System.out.println("Starting dragon...");
		dragon.start();
		System.out.println("Starting adventurers...");
		for(int i=0; i<NUM_ADV; i++){
			adventurers[i] = new Adventurer(i);
			adventurers[i].start();
		}
		System.out.println("Starting clerks...");
		for(int i=0; i<NUM_CLERKS; i++){
			clerks[i] = new Clerk(i);
			clerks[i].start();
		}
		
	}
	synchronized public static boolean serveToAnAdv(){
		if(Main.shopTurn.hasQueuedThreads()){
			Main.shopTurn.release();
			return true;
		}else{
			return false;
		}
	}
}
