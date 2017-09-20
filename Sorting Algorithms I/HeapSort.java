
public class HeapSort {
	
	public static int[] arr;
	private static int size=0;
	public static int counter = 0;
	
	public static int[] Sort(int[] array){
		counter = 0;
		arr = array;
		
		size = arr.length;
		
		//System.out.println(arr[Left(3)] +" "+arr[Right(3)]);
		
		return Heap_Sort();
		//return arr;
	}
	private static int[] Heap_Sort(){
		Build_Max_Heap();
		for(int i=size; i>0; i--){
			Swap(0, i-1);
			size --;
			Max_Heapify(0);
		}
		return arr;
	}
	private static void Max_Heapify(int i) {
	
		int l = Left(i),
			r = Right(i), largest=i;
		if( l > -1 && arr[l] > arr[largest]){
			largest = l;
		}
		if(r > -1 && arr[r]>arr[largest]){
			largest = r;
		}
		if(largest != i){
			counter ++;
			Swap(i,largest);
			Max_Heapify(largest);
		}
	}
	private static void Build_Max_Heap(){
		for(int i = (int)Math.floorDiv(arr.length,2)-1; i>=0; i--){
			Max_Heapify(i);
		}
	}
	private static void Swap(int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private static int Left(int i){
		if(2*(i+1)-1 <size)
			return 2*(i+1)-1;
		return -9999;
	}
	private static int Right(int i){
		if(2*(i+1) <size)
			return 2*(i+1);
		return -9999;
	}
}
