
public class InsertionSort {
	
	public static int[] arr;
	public static int counter = 0;
	public static int[] Sort(int[] array){
		counter = 0;
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
