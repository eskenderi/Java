import java.util.ArrayList;
import java.util.List;

public class BucketSort {
	
	private static ArrayList<ArrayList<Integer>> list;
	public static int counter = 0;
	
	public static int[] Sort(int[] array, int maxNumber){
		counter++;
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=array.length; i++){
			list.add(new ArrayList<Integer>());
		}
		for(int i=0; i<array.length; i++){
			list.get((int) Math.floor(array[i]*array.length/maxNumber)).add(array[i]);
		}
		int cnt = 0;
		for(List<Integer> l:list){
			for(int n : InsertionSort(toIntArray(l))){
				array[cnt++] = n;
			}
		}		
		return array;
	}	
	static int[] toIntArray(List<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}
	public static int[] InsertionSort(int[] array){
		int tmp,i;
		for(int j=1; j<array.length; j++){
			tmp = array[j];
			i = j-1;
			while(i >= 0 && array[i] > tmp){
				counter ++;
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = tmp;
		}
		return array;
	}
}
