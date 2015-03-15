/**
 * 关于：leetcode 第一题 给定一个数组，和一个目标值，在数组中找到两个数相加和为目标值，并返回这两个数的下标
 * 方法：将数组排序，左右夹逼，但是因为要返回下标，所以先将数组变为对象数组，保存好相应值原先的下标
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
