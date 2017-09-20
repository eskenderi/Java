
public class QuickSort {

	public static int[] arr;
	public static int counter = 0;
	
	public static int[] Sort(int[] array){
		counter = 0;
		arr = array;
		Quick_Sort( 0, arr.length-1);
		return arr;
	}
	private static void Quick_Sort(int l, int r){
		if( l < r){
			int m = Partition( l, r);
			Quick_Sort(l, m-1);
			Quick_Sort(m, r);
		}
	}
	private static int Partition(int l, int r){
		int key = arr[r],
			i = l - 1;
		for(int j = l; j<r; j++){
			counter++;
			if( arr[j] <= key) {
				i ++;
				Swap( i, j);
			}
		}
		Swap( i+1, r);
		
		return i+1;
	}
	private static void Swap(int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
