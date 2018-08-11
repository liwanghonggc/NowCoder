package lwh.sort;

public class ArraySort1 {

	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	//冒泡排序,复杂度O(n^2),可以做到稳定
	public static void bubbleSort(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			for(int j = 0; j < a.length - i; j++){
				if(a[j] > a[j+1]){
					swap(a, j, j+1);
				}
			}
		}
	}
	
	//插入排序,复杂度O(n^2),可以做到稳定
	public static void insertSort(int[] a){
		for(int i = 1; i < a.length; i++){
			int temp = a[i];
			int j = i - 1;
			while(j >= 0 && temp < a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	//选择排序, 复杂度O(n^2),不稳定
	public static void selectSort(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			if(i != min){
				swap(a, i, min);
			}
		}
	}
	
	//归并排序,算法稳定,时间复杂度O(nlogn)
	public static void mergeSort(int[] a){
		mergeSortRecursive(a, 0, a.length - 1);
	}
	
	private static void mergeSortRecursive(int[] a, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			mergeSortRecursive(a, left, mid);
			mergeSortRecursive(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	private static void merge(int[] a, int left, int mid, int right) {
		int len = right - left + 1;
		int i = left;
		int j = mid + 1;
		int[] temp = new int[len];
		int k = 0;
		while(i <= mid && j <= right){
			temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
		}
		while(i <= mid){
			temp[k++] = a[i++];
		}
		while(j <= right){
			temp[k++] = a[j++];
		}
		for(i = 0; i < len; i++){
			a[left++] = temp[i];
		}
	}
	//快速排序
	public static void quickSort(int[] a){
		fastQuickSort(a, 0, a.length - 1);
	}

	private static void fastQuickSort(int[] a, int left, int right) {
		if(left < right){
			int pivotIndex = partion(a, left, right);
			fastQuickSort(a, left, pivotIndex-1);
			fastQuickSort(a, pivotIndex+1, right);
		}
	}

	private static int partion(int[] a, int left, int right) {
		int pivot = a[right];
		int tail = left - 1;
		for(int i = left; i < right; i++){
			if(a[i] <= pivot){
				tail++;
				swap(a, tail, i);
			}
		}
		swap(a, tail+1, right);
		return tail+1;
	}
	
	
	//堆排序
}
