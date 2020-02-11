package 排序;

public class Main {
	 public static void main(String[] args) {
		 int[] a = {6,1,2,9,12,45,21,5};

//		 BubbleSort sort = new BubbleSort();
//		 sort.bubbleSort(a);
//		 SelectionSort sort = new SelectionSort();
//		 sort.selectionSort(a);
		 InsertionSort sort = new InsertionSort();
		 sort.insertionSort(a);
		 for (int i = 0; i < a.length; i++) {
			 System.out.println(a[i]);
		}
		 
	 }
}
