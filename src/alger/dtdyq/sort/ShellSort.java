package alger.dtdyq.sort;



public class ShellSort {
    public static void main(String[] args) {
//        int[] a = new int[15];
//        a = stdRandom.random(a);
        int[] a = {2,1,3,4,5,6,0,2};
        for(int i=0;i<a.length;i++)
        	System.out.print(a[i]+" ");
        System.out.println();
        a = Shell_Sort(a);
        for(int i=0;i<a.length;i++)
        	System.out.print(a[i]+" ");
    }

    //对于大规模乱序数组
    //将数组整理成【h有序数组】，==> 即a[0]< a[h]< a[2*h]<...，a[1]< a[h+1]< a[2*h+1]<...
    //h：1, 4, 13, 41, 121, 364, 1093...  3倍的倍数递增。
    public static int[] Shell_Sort(int[] a) {

        int length = a.length;
        int h = 1;     //步长
        while (h < length/3){
            h = 3*h +1;
        }

        while (h>0){
            for (int i = h; i < length; i++) {//将数组整理成【h有序数组】，
                for (int j = i; j >= h && a[j]<a[j-h]; j-=h) {
                    swap(a,j,j-h);
                }
            }
            h = h/3;
        }

        return a;
    }
    private static void swap(int[] a,int i ,int j){
    	int temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }
}
