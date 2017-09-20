import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver {
	
	public static LinkedList<int[]> testingSets = new LinkedList<int[]>();
	private static Scanner in;
	private static BufferedWriter out;
	
	public static void main(String[] args) throws IOException {
		loadTestData();
		
		ComputeAndOutput();
		
	}
	private static void ComputeAndOutput() throws IOException{
		for(int[] arr:testingSets){
			//Counting Sort
			out = new BufferedWriter(new FileWriter("CountingSort"+arr.length+".txt"));
			int[] sortedArr =  CountingSort.Sort(arr,arr.length);//send max as an argument
			out.write(CountingSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
			
			//Radix Sort
			out = new BufferedWriter(new FileWriter("RadixSort"+arr.length+".txt"));
			sortedArr =  RadixSort.Sort(arr,numberOfDigits(arr.length));//send nr of digits as an argument
			out.write(RadixSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
			//Bucket Sort
			out = new BufferedWriter(new FileWriter("BucketSort"+arr.length+".txt"));
			sortedArr =  BucketSort.Sort(arr, arr.length);//send max as an argument
			out.write(BucketSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
		}
	}
	private static int numberOfDigits(int n){
		int cnt=1;
		while(n>=1){
			cnt++;
			n/=10;
		}
		return cnt;
	}
	private static void loadTestData() throws FileNotFoundException{
		
		for(int i=3; i<=8; i++){
			int size = (int)Math.pow(2,i);
			in = new Scanner(new File("input"+size+".txt"));
			int[] tmp = new int[size];
			for(int cnt=0; cnt<size; cnt++){
				tmp[cnt] = Integer.parseInt(in.nextLine());
			}
			testingSets.add(tmp);
			
			System.out.println("loaded: "+(int)Math.pow(2,i));
		}
	}
}
