/*
 * 关于：leetcode 第二题 给定两个排好序的数组，找到它们的中位数，要求：时间复杂度o(log(m+n));
 * 变形：找第k个数
 * 方法：1.遍历，时间复杂度为o(m+n),从头开始分别遍历两数组的数，按照大小计数，直到第k个数
 * 		2.递归，因为两个数组是排好序的，所以先各取第k/2的数比较，小的一边必然全都在第k个数之前（反证法）
 * 大的一边则可能不全在k前，于是递归再找剩下的k/2个数。
 * 		返回条件：1.一个数组为空时，直接返回另一个数组第k个数
 * 				2.k=1，返回min(A[0],B[0])
 * 				3.A[k/2-1] == B[k/2-1],返回其中一个的值
 */
package javaTrain;

public class Train2 {
	public double findMedianSortedArrays(int A[], int B[]) {
		int n = A.length;
		int m = B.length;
		int total = n+m;
		if(total%2 == 1){	//如果两个数组的个数相加是奇数，不能有total&0x1判断。。
			return culMedian(A,n,B,m,total/2+1);
		}
		else
			return (culMedian(A,n,B,m,total/2)+culMedian(A,n,B,m,total/2+1))/2.0;
    }
	public double culMedian(int A[],int n,int B[],int m,int k){
		if(n == 0)
			return B[k-1];
		if(m==0)
			return A[k-1];
		if(k == 1)
			return A[0]<B[0]?A[0]:B[0];
		int a = k/2 < n ? k/2 : n;
		int b = k-a < m ? k-a : m;
		if(A[a-1] < B[b-1]){		//java不能直接用A+a传递指针。。。还有别的方法吗？？？
			int iA[] = new int[n-a]; 
			for(int i = a;i < n;i++)
				iA[i-a] = A[i]; 
			return culMedian(iA,n-a,B,m,k-a);
		}
		else if(A[a-1] > B[b-1]){
			int iB[] = new int[m-b];
			for(int i = b;i < m;i++)
				iB[i-b] = B[i]; 
			return culMedian(A,n,iB,m-b,k-b);
		}
		else 
			return A[a-1]; 		
	}
	public static void main(String args[]){
		int A[] = {2};
		int B[] = {1,3,4};
		Train2 t = new Train2();
		System.out.println(t.findMedianSortedArrays(A,B)); 
	}
}
