
public class RadixSort {
	
	public static int counter = 0;
	private static int[] C;
	private static int[] B;
	
	public static int[] Sort(int[] arr, int digits){
		counter = 0;
		for(int i=1; i<=digits; i++){
			arr = CountingDigitSort(arr, i);
		}
		return arr;
	}
	
	public static int[] CountingDigitSort(int[] array, int digit){
		C = new int[9+1];
		B = new int[array.length];
		
		for(int i : array){
			C[(int) ((i%(Math.pow(10, digit))) / (Math.pow(10, digit-1)))] ++ ;
		}
		for(int i = 1; i<C.length; i++){
			C[i] += C[i-1];
		}
		
		for(int j = B.length-1; j>=0; j--){
			B[C[(int) ((array[j]%(Math.pow(10, digit))) / (Math.pow(10, digit-1)))]-1] = array[j];//Counter
			counter ++;
			C[(int) ((array[j]%(Math.pow(10, digit))) / (Math.pow(10, digit-1)))] -- ; 
		}
		return B;
	}
}

