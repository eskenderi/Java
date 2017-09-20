import java.util.Arrays;

public class MergeSort {
	public static int[] arr;
	public static int counter = 0;
	
	public static int[] Sort(int[] array){
		counter = 0;
		arr = array;
		
		Merge_Sort(0, arr.length);
		
		
		return arr;
	}
	private static void Merge_Sort(int l, int r){
		if( r>l){
			int m = Math.floorDiv(l+r, 2);
			Merge_Sort( l, m);
			Merge_Sort( m+1, r);
			Merge( l, r, m);
		}
	}
	public static void Merge(int l, int r, int m){
		//left - right - middle
		int[] L = Arrays.copyOfRange(arr, l, m), R = Arrays.copyOfRange(arr, m, r);
	
		int i = 0, j = 0, cnt = l;
		while(i < L.length && j < R.length){
			counter++;
			if(L[i] < R[j]){
				arr[cnt++] = L[i++];
			}else{
				arr[cnt++] = R[j++];
			}
		}
		while(i < L.length){
			counter++;
			arr[cnt++] = L[i++];
		}
		while(j < R.length){
			counter++;
			arr[cnt++] = R[j++];
		}
	}
}
