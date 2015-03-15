/**
 * ���ڣ�leetcode ��һ�� ����һ�����飬��һ��Ŀ��ֵ�����������ҵ���������Ӻ�ΪĿ��ֵ�������������������±�
 * �������������������Ҽбƣ�������ΪҪ�����±꣬�����Ƚ������Ϊ�������飬�������Ӧֵԭ�ȵ��±�
 */
package javaTrain;

import java.util.Arrays;
 

public class Train1 {
	static class Node implements Comparable<Node>{
    	int val,index;
    	public Node(int v,int i){
    		val = v;
    		index = i; 
    	}
    	public int compareTo(Node o){
    		return this.val - o.val;
    	}
    }
    public int[] twoSum(int[] numbers,int target){
    	int[] xy = new int[2];
    	Node[] nodes = new Node[numbers.length];
    	for(int i = 0;i < numbers.length;i++){
    		nodes[i] = new Node(numbers[i],i+1);
    	}
    	Arrays.sort(nodes);
    	int i = 0,j = numbers.length-1;
    	while(i < j){
    		if(nodes[i].val+nodes[j].val == target){
    			break; 
    		}
    		else if(nodes[i].val+nodes[j].val < target)
    			i++;
    		else
    			j--;
    	}
    	xy[0] = nodes[i].index;
    	xy[1] = nodes[j].index; 
    	return xy;
    }
}
