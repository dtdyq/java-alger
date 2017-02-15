package alger.dtdyq.sort;

public class HeapSort {
	public static void sink(int[] a,int k,int N){
		while(k*2<=N){
			int j=2*k;
			if(j<N && a[j]<a[j+1])		j++;
			if(a[k]>=a[j])		break;
			else{
				swap(a,k,j);
			}
			k=j;
		}
	}
	public static void Heap(int[] a,int N){
		for(int k=N/2;k>=1;k--){
			sink(a,k,N);
		}
		while(N>1){
			swap(a, 1, N--);
			sink(a,1,N);
		}
	}
	private static void swap(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		
		int[] a={99,7,3,1,6,4,9,5,8,10};
		Heap(a,9);
		for(int k=0;k<10;k++){
			System.out.print(a[k]+" ");
		}

	}

}
