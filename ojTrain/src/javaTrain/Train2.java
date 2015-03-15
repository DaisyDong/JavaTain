/*
 * ���ڣ�leetcode �ڶ��� ���������ź�������飬�ҵ����ǵ���λ����Ҫ��ʱ�临�Ӷ�o(log(m+n));
 * ���Σ��ҵ�k����
 * ������1.������ʱ�临�Ӷ�Ϊo(m+n),��ͷ��ʼ�ֱ������������������մ�С������ֱ����k����
 * 		2.�ݹ飬��Ϊ�����������ź���ģ������ȸ�ȡ��k/2�����Ƚϣ�С��һ�߱�Ȼȫ���ڵ�k����֮ǰ����֤����
 * ���һ������ܲ�ȫ��kǰ�����ǵݹ�����ʣ�µ�k/2������
 * 		����������1.һ������Ϊ��ʱ��ֱ�ӷ�����һ�������k����
 * 				2.k=1������min(A[0],B[0])
 * 				3.A[k/2-1] == B[k/2-1],��������һ����ֵ
 */
package javaTrain;

public class Train2 {
	public double findMedianSortedArrays(int A[], int B[]) {
		int n = A.length;
		int m = B.length;
		int total = n+m;
		if(total%2 == 1){	//�����������ĸ��������������������total&0x1�жϡ���
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
		if(A[a-1] < B[b-1]){		//java����ֱ����A+a����ָ�롣�������б�ķ����𣿣���
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
