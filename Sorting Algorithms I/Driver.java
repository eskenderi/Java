import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
			//InsertionSort
			out = new BufferedWriter(new FileWriter("InsertionTest"+arr.length+".txt"));
			int[] sortedArr =  InsertionSort.Sort(arr);
			out.write(InsertionSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
			//MergeSort
			out = new BufferedWriter(new FileWriter("MergeSortTest"+arr.length+".txt"));
			sortedArr =  MergeSort.Sort(arr);
			out.write(MergeSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
			//HeapSort
			out = new BufferedWriter(new FileWriter("HeapSortTest"+arr.length+".txt"));
			sortedArr =  HeapSort.Sort(arr);
			out.write(HeapSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
			//QuickSort
			out = new BufferedWriter(new FileWriter("QuickSortTest"+arr.length+".txt"));
			sortedArr =  QuickSort.Sort(arr);
			out.write(QuickSort.counter+"");
			out.newLine();
			for(int c:sortedArr){
				out.write(c+"");
				out.newLine();
			}
			out.flush();
		}
	}

	private static void loadTestData() throws FileNotFoundException{
		
		for(int i=3; i<=14; i++){
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
