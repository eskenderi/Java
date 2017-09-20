
public class CountingSort {

	private static int[] C;
	private static int[] B;
	public static int counter = 0;
	public static int[] Sort(int[] array, int max){
		counter = 0;
		C = new int[max+1];
		B = new int[array.length];
		for(int i : array){
			C[i] ++ ;
		}
		for(int i = 1; i<C.length; i++){
			C[i] += C[i-1];
		}
		for(int j = B.length-1; j>=0; j--){
			B[C[array[j]]-1] = array[j];//Counter
			C[array[j]] -- ;
			counter++;
		}
		
		return B;
	}
}
