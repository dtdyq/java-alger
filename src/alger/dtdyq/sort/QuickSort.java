package alger.dtdyq.sort;
import alger.dtdyq.list.Counter;

public class QuickSort {
	private static int pivot(int[] a,int left,int right){
		int mid=(left+right)/2;
		if(a[left]>a[mid]){
			Swap(a,left,mid);
		}
		if(a[left]>a[right]){
			Swap(a,left,right);
		}
		if(a[mid]>a[right]){
			Swap(a,mid,right);
		}
		Swap(a,mid,right-1);
		return a[right-1];
	}
	private static void Swap(int[] a,int i,int j){
		int k=a[i];
		a[i]=a[j];
		a[j]=k;
	}
	public static void Sort(int[] a){
		Sort(a,0,a.length);
	}
	private static void Sort(int[] a,int lo,int hi){
		int i,j,temp;
		if(lo+3>=hi){
			temp=pivot(a,lo,hi);
			i=lo;
			j=hi-1;
			while(true){
				while(a[++i]<temp);
				while(a[--j]>temp);
				if(i>j){
					break;
				}
				else{
					Swap(a,i,j);
				}
			}
			Swap(a,i,hi-1);
			Sort(a,lo,i-1);
			Sort(a,i+1,hi);
		}
		else{
			BubbleSort.Sort(a,lo,hi);
		}
	}
	public static boolean isSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			if(a[i]>a[i+1]){
				return false;
			}
		}
		return true;
	}
	public static void Sort(int[] a,int k,int lo,int hi){
		int i,j,temp;
		if(lo+10>=hi){
			temp=pivot(a,lo,hi);
			i=lo;
			j=hi-1;
			while(true){
				while(a[++i]<temp);
				while(a[--j]>temp);
				if(i>j){
					break;
				}
				else{
					Swap(a,i,j);
				}
			}
			Swap(a,i,hi-1);
			if(k<=i)
				Sort(a,k,lo,i-1);
			else if(k>i+1)
				Sort(a,k,i+1,hi);
		}
		else{
			BubbleSort.Sort(a,lo,hi);
		}
	}
	static void test(){
		int count=0;
		int[] a=new int[10];
		for(int i=0;i<100;i++){
			for(int j=0;j<10;j++){
				a[j]=(int)Math.floor((Math.random()*100+1));
			}
			Sort(a,0,10);
			if(isSort(a)){
				count++;
			}
		}
		System.out.println(count);
	}
	static void TimeTest(int len){
		Counter c1=new Counter("QuickSort");
		Counter c2=new Counter("BubbleSort");
		int[] a=new int[len];
		for(int i=0;i<10;i++){
			for(int j=0;j<len;j++){
				a[j]=(int)Math.floor((Math.random()*1000+1));
			}
			long t1=System.currentTimeMillis();
			Sort(a,0,len);
			long t2=System.currentTimeMillis()-t1;
			for(int j=0;j<len;j++){
				a[j]=(int)Math.floor((Math.random()*1000+1));
			}
			long t3=System.currentTimeMillis();
			BubbleSort.Sort(a);
			long t4=System.currentTimeMillis()-t3;
			if(t2>t4){
				c2.increase();
			}
			if(t4>t2){
				c1.increase();
			}
		}
		System.out.println("====TimeTest====");
		System.out.println(c1);
		System.out.println(c2);
	}
	public static void main(String[] args){
//		int[] a=new int[10];
//		for(int i=0;i<10;i++){
//			a[i]=(int)Math.floor((Math.random()*100+1));
//		}
//		Sort(a,0,10);
//		for(int i=0;i<10;i++){
//			System.out.print(a[i]+" ");
//		}
//		System.out.println("\n"+isSort(a)+"\n");
//		int[] b=new int[10];
//		for(int i=0;i<10;i++){
//			b[i]=(int)Math.floor((Math.random()*100+1));
//		}
//		Sort(b,2,0,10);
//		for(int i=0;i<10;i++){
//			System.out.print(a[i]+" ");
//		}
//		System.out.println("\n");
//		test();
	}
}










