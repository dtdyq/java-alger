package alger.dtdyq.sort;

public class BubbleSort {
	public static void Sort(int[] a){
		boolean flag=false;
		int N=a.length;
		do{
			flag=false;
			for(int i=0;i<N-1;i++){
				if(a[i]>a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					flag=true;
				}
			}
			N--;
		}while(flag);
	}
	public static void Sort(int[] a,int lo,int hi){
		boolean flag=false;
		int N=hi;
		do{
			flag=false;
			for(int i=0;i<N-1;i++){
				if(a[i]>a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					flag=true;
				}
			}
			N--;
		}while(flag);
	}
	public static void main(String[] args) {
		int[] a={9,10,2,5,3,7,8,6,1,4};
		Sort(a,0,10);
		for(int i=0;i<10;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println(QuickSort.isSort(a));
	}

}
