package lwh.sort;


//https://www.cnblogs.com/eniac12/p/5329396.html
public class ArraySort {

	//冒泡排序,稳定算法
	//外层循环进行n-1趟排序,内层循环用来交换元素,每次选择最大元素将其移至最后
	//最差和平均时间复杂度O(n^2),辅助空间O(1)
	public static void bubbleSort1(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			for(int j = 0; j < a.length - 1 - i; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			SortTest.print(a);
		}
	}
	
	//冒泡排序法改进1
	//置一个标记,若一次内层循环下来没有元素交换,则跳出循环结束排序,
	//因此若数组本身有序情况下,排序一趟就可结束,最好情况下复杂度O(n)
	public static void bubbleSort2(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			boolean flag = false;
			for(int j = 0; j < a.length - 1 - i; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					
					flag = true;
				}
				
			}
			if(!flag){
				break;
			}
			SortTest.print(a);
		}
	}
	
	//冒泡排序改进2
	//记住最后一次交换的下标lastExchange,在每趟扫描中,记住最后一次交换发生的位置lastExchange,
	//(该位置之后的相邻记录均已有序).下一趟排序开始时,R[1..lastExchange-1]是无序区,R[lastExchange..n]是有序区.
	public static void bubbleSort3(int[] a){
		int pos = 0;
		int k = a.length - 1;
		for(int i = 0; i < a.length - 1; i++){
			boolean flag = false;
			for(int j = 0; j < k; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = true;
					pos = j;
				}
			}
			k = pos;
			if(!flag){
				break;
			}
			SortTest.print(a);
		}
	}
	
	//简单选择排序
	//每次选择最小元素放到最前
	//最差最好平均时间复杂度O(n^2),辅助空间O(1),因为每轮找出的最小值元素会与其他元素交换,因此会打乱稳定性
	//比如序列:{ 5, 8, 5, 2, 9 },一次选择的最小元素是2,然后把2和第一个5进行交换,从而改变了两个元素5的相对次序
	//该排序算法不稳定
	//选择排序与冒泡排序的区别:冒泡排序通过依次交换相邻两个顺序不合法的元素位置,从而将当前最小(大)元素放到合适的位置;
	//而选择排序每遍历一次都记住了当前最小(大)元素的位置,最后仅需一次交换操作即可将其放到合适的位置.
	public static void selectSort(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			if(i != min){
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			SortTest.print(a);
		}
	}
	
	//直接插入排序
	//最差是当元素降序排列,时间复杂度O(n^2),最好是数组元素升序排列,时间复杂度O(n),平均时间复杂度O(n^2),算法稳定
	//对于未排序数据(右手抓到的牌),在已排序序列(左手已经排好序的手牌)中从后向前扫描,找到相应位置并插入
	//初始时,元素a[0]有序,将a[1]与a[0]比较并插入使得数组有序,不断循环下去
	public static void insertSort(int[] a){
		for(int i = 1; i < a.length; i++){
			int temp = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > temp){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
			SortTest.print(a);
		}
	}
	
	public static void quickSort(int[] a){
		if(a == null || a.length < 2){
			return;
		}
		quickSort1(a, 0, a.length - 1);
	}
	
	//经典快速排序,每次选择数组最后一个元素作为基准元素
	/*
	 从序列中挑出一个元素,作为"基准"(pivot),
	把所有比基准值小的元素放在基准前面,所有比基准值大的元素放在基准的后面(相同的数可以到任一边),这个称为分区(partition)操作,
	对每个分区递归地进行步骤1~2,递归的结束条件是序列的大小是0或1,这时整体已经被排好序了.
	 */
	//最差时间复杂度,每次选择的基准都是最大或最小,导致每次只划分出了一个分区,需要进行n-1次划分才能结束递归,时间复杂度为O(n^2)
	//最好时间复杂度,每次选取的基准都是中位数,这样每次都均匀的划分出两个分区,只需要logn次划分就能结束递归,时间复杂度为O(nlogn)
	// 平均时间复杂度 ---- O(nlogn)
	// 所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量),取决于递归树的深度,一般为O(logn),最差为O(n)       
	// 稳定性 ---------- 不稳定
	//快速排序是不稳定的排序算法,不稳定发生在基准元素与A[tail+1]交换的时刻
	//比如序列:{ 1, 3, 4, 2, 8, 9, 8, 7, 5 },基准元素是5,一次划分操作后5要和第一个8进行交换,从而改变了两个元素8的相对次序
	private static void quickSort1(int[] a, int left, int right){
		if(left >= right){
			return;
		}
		int pivotIndex = partition1(a,left,right);
		quickSort1(a,left,pivotIndex-1);
		quickSort1(a,pivotIndex+1,right);
	}

	private static int partition1(int[] a, int left, int right) {
		int pivot = a[right];
		int tail = left - 1;
		for(int i = left; i < right; i++){
			if(a[i] <= pivot){
				tail++;
				int temp = a[tail];
				a[tail] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[tail+1];
		a[tail+1] = a[right];
		a[right] = temp;
		return tail+1;
	}
	
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//随机快速排序
	private static void quickSort2(int[]a, int left, int right){
		if(left >= right){
			return;
		}
		int[] mid = partition2(a, left, right);
		quickSort2(a, left, mid[0]);
		quickSort2(a, mid[1], right);
	}
	
	private static int[] partition2(int[] a, int left, int right){
		int arrayLen = right - left + 1;
		int randomIndex = (int)(Math.random() * arrayLen) + left;
		int num = a[randomIndex];
		int less = left - 1;
		int more = right + 1;
		int i = left;
		while(i < more){
			if(a[i] < num){
				swap(a, ++less, i++);
			}else if(a[i] == num){
				i++;
			}else{
				swap(a, --more, i);
			}
		}
		return new int[]{less, more};
	}
	
	//堆排序http://www.cnblogs.com/dolphin0520/archive/2011/10/06/2199741.html
	//最差最优和平均时间复杂度都是O(nlogn),算法不稳定 
	public static void heapSort(int[] a){
		//建堆
		bulidHeap(a);
		int heapSize = a.length;
		while(heapSize > 1){
			heapSize--;
			int temp = a[heapSize];
			a[heapSize] = a[0];
			a[0] = temp;
			
			//将最大值(堆顶元素)与堆最后元素交换之后,可能不满足最大堆性质,重新调整最大堆
			heapify(a,0,heapSize);
		}
	}

	//初始化堆
	private static void bulidHeap(int[] a) {
		int heapSize = a.length;
		for(int i = heapSize / 2 - 1; i >= 0; i--){
			heapify(a,i,heapSize);
		}
	}

	//调整堆
	private static void heapify(int[] a, int i, int heapSize) {
		int lChild = 2 * i + 1;
		int rChild = 2 * i + 2;
		int max = i;
		if(lChild < heapSize && a[lChild] > a[max]){
			max = lChild;
		}
		if(rChild < heapSize && a[rChild] > a[max]){
			max = rChild;
		}
		if(max != i){
			int temp = a[max];
			a[max] = a[i];
			a[i] = temp;
			heapify(a,max,heapSize);
		}
	}
	
	//归并排序
	//最好最差及平均时间复杂度O(nlogn),所需辅助空间O(n)
	//算法稳定
	public static void mergeSort(int[] a){
		if(a == null || a.length < 2){
			return;
		}
		mergeSortRecursion(a, 0, a.length - 1);
	}
	
	private static void mergeSortRecursion(int[] a, int left, int right){
		if(left >= right){
			return;
		}
		int mid = (left + right) / 2;
		mergeSortRecursion(a, left, mid);
		mergeSortRecursion(a, mid + 1, right);
		merge(a, left, mid, right);
	}
	
	private static void merge(int[] a, int left, int mid, int right){
		int len = right - left + 1;
		int[] temp = new int[len];
		int i = left;
		int j = mid + 1;
		int index = 0;
		while(i <= mid && j <= right){
			temp[index++] = a[i] < a[j] ? a[i++] : a[j++];
		}
		while(i <= mid){
			temp[index++] = a[i++];
		}
		while(j <= right){
			temp[index++] = a[j++];
		}
		for(int k = 0; k < len; k++){
			a[left++] = temp[k];
		}
	}

}
