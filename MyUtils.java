package Algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyUtils {

	//冒泡排序：
	public void BubbleSort(int[] array) {
		int length = array.length;
		for(int i=0;i<length-1;i++) {
			boolean tag = false;
			for(int j=0;j<length-i-1;j++) {
				if(array[j]>array[j+1]) {
					array[j] = array[j]^array[j+1];
					array[j+1] = array[j]^array[j+1];
					array[j] = array[j]^array[j+1];
					tag = true;
				}
			}
			if (!tag) break;
		}
	}
	
	//对数组插入排序：
	public void InsertSort(int[] array) {
		int length = array.length;
		int temp,j;
		for(int i=1;i<length;i++) {
			temp = array[i];
			j = i-1;
			while(j>=0 && array[j]>temp) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	
	//对链表进行插入排序
	public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode preNode = head;
        ListNode pNode = preNode.next;
        while(pNode!=null) {
        	if(pNode.val>=preNode.val) {
        		preNode = pNode;
        		pNode = pNode.next;
        	}else {
        		ListNode node = pNode;
        		ListNode tempNode = head;
        		ListNode insertNode = null;
        		pNode = pNode.next;
        		preNode.next = pNode;
        		while(tempNode.val<=node.val) {
        			if(tempNode.next.val<=node.val) {
        				tempNode = tempNode.next;
        			}else {
        				insertNode = tempNode;
        				break;
        			}
        		}
        		if(insertNode==null) {
        			node.next = head;
        			head = node;
        		}else {
					node.next = insertNode.next;
					insertNode.next = node;
				}
        	}
        }
        return head;
    }
	
	//快排递归实现：
	public void QuickSort_Recursion(int[] array,int start,int end) {
		if(array==null || array.length<=0) return;
		int left=start,right=end;
		if (left<=right) {
			int temp = array[left];
			while(left!=right) {
				while(left<right && array[right]>=temp) right--;
				array[left] = array[right];
				while(left<right && array[left]<=temp) left++;
				array[right] = array[left];
			}
			array[left] = temp;
			QuickSort_Recursion(array, start, left-1);
			QuickSort_Recursion(array, left+1, end);
		}
	}
	
	//快排非递归实现
	public void QuickSort_NonRecursion(int[] array, int start, int end) {
		Stack<Integer> stack = new Stack<Integer>();
		if(start<end) {
			stack.push(end);
			stack.push(start);
			while(!stack.isEmpty()) {
				int left = stack.pop();
				int right = stack.pop();
				int index = partition(array,left,right);
				if(left<index-1) {
					stack.push(index-1);
					stack.push(left);
				}
				if(right>index+1) {
					stack.push(right);
					stack.push(index+1);
				}
			}
		}
	}
	
	private int partition(int[] array, int start, int end) {
		int temp = array[start];
		while(start<end) {
			while(start<end && array[end]>=temp) end--;
			array[start] = array[end];
			while(start<end && array[start]<=temp) start++;
			array[end] = array[start];
		}
		array[start] = temp;
		return start;
	}

	//选择排序
	public void SelectSort(int[] array) {
		int length = array.length;
		int temp,k;
		for(int i=0;i<length;i++) {
			temp = array[i];
			k = i;
			for(int j=i+1;j<length;j++) {
				if(array[j]<temp) {
					temp = array[j];
					k = j;
				}
			}
			if (k!=i) {
				array[k] = array[i];
				array[i] = temp;
			}
		}
	}
	
	//基数排序
	public void RadixSort(int[] array) {
		if(array==null || array.length<=0) return;
		int length = array.length;
		int maxValue = array[0];
		//计算数组中元素的最大值
		for(int i=1;i<length;i++)
			if(array[i]>maxValue)
				maxValue = array[i];
		//计算数组最大值的位数
		int digit = 0;
		while(maxValue>0) {
			maxValue /= 10;
			digit++;
		}
		//将所有的位数,从低位到高位依次进行排序
		int n = 1;
		for(int i=0;i<digit;i++) {
			for(int j=0;j<length;j++) {
				int num = (array[j]/n)%10;
				for(int k=0;k<j;k++) {
					if(num<((array[k]/n)%10)) 
						Swap(array, j, k);
				}
			}
			n = n*10;
		}
	}
	
	//Shell排序
	public void ShellSort(int[] array) {
		if(array==null || array.length<=0) return;
		int length = array.length;
		int k;
		//对数组进行分组,对每一组中的数据使用直接插入排序,然后改变分组大小
		for(int gap=length/2;gap>0;gap/=2) {
			for(int i=0;i<gap;i++) {
				for(int j=i+gap;j<length;j+=gap) {
					int temp = array[j];
					for(k=j-gap;k>=0&&array[k]>temp;k-=gap) {
						array[k+gap] = array[k];
					}
					array[k+gap] = temp;
				}
			}
		}
	}
	
	//归并排序
	public void MergeSort(int[] array) {
		int[] temp = new int[array.length];
		MergeSort(array,0,array.length-1,temp);
	}
	
	private void MergeSort(int[] array,int left,int right,int[] temp) {
		if (left<right) {
			int mid = (left+right)/2;
			MergeSort(array, left, mid, temp);
			MergeSort(array, mid+1, right, temp);
			Merge(array,left,mid,right,temp);
		}
	}
	
	private void Merge(int[] array,int left,int mid,int right,int[] temp) {
		int i=left,j=mid+1;
		int t=0;
		while(i<=mid && j<=right) {
			if (array[i]<=array[j]) {
				temp[t++] = array[i++];
			}else {
				temp[t++] = array[j++];
			}
		}
		while(i<=mid) temp[t++] = array[i++];
		while(j<=right) temp[t++] = array[j++];
		t=0;
		while(left<=right) array[left++] = temp[t++];
	}
	
	//堆排序
	public void HeapSort(int[] array) {
		if(array==null || array.length<=1) return;
		BuildHeap(array);
		for(int i=array.length-1;i>0;i--) {
			Swap(array, i, 0);
			MaxHeap(array, i, 0);
		}
	}
	
	//数组建堆过程
	private void BuildHeap(int[] array) {
		if(array==null || array.length<=1) return;
		for(int i=array.length/2;i>=0;i--) 
			MaxHeap(array, array.length, i);
	}
	
	//建立当顶对的过程
	private void MaxHeap(int[] array,int heapSize,int index) {
		int left = index*2+1;
		int right = index*2+2;
		int maxValueIndex = index;
		if(left<heapSize && array[left]>array[maxValueIndex]) maxValueIndex = left;
		if(right<heapSize && array[right]>array[maxValueIndex]) maxValueIndex = right;
		if(maxValueIndex!=index) {
			Swap(array, maxValueIndex, index);
			MaxHeap(array, heapSize, maxValueIndex);
		}
	}
	
	//不借助中间变量交换两个数字
	private void Swap(int[] array,int index1,int index2) {
		array[index1] = array[index1]^array[index2];
		array[index2] = array[index1]^array[index2];
		array[index1] = array[index1]^array[index2];
	}
	
	//二分递归查找
	public int BinarySearch(int[] array,int res,int start,int end) {
		if(res<array[start] || res>array[end] || start>end) return -1;
		int mid = (start+end)>>1;
		if (res<array[mid]) {
			return BinarySearch(array, res, start, mid-1);
		}else if(res>array[mid]) {
			return BinarySearch(array, res, mid+1, end);
		}else {
			return mid;
		}
	}
	
	//二分非递归查找
	public int BinarySearch(int[] array,int res) {
		int start=0,end=array.length-1;
		while(start<=end) {
			int mid = (start+end)>>1;
			if (res<array[mid]) {
				end = mid-1;
			}else if (res>array[mid]) {
				start = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	//使用二分法解决开根号问题
	public double sqrtByBinarySearch(int n, double eps) {		
		if(n<0) return 0;		
		double left = 0;	//标记左边
		double right = n;	//标记右边
		double mid = (left+right)/2;	//标记中间
		double last;	//标记上一次计算的值
		do {
			if(mid*mid-n>0)	//表示估计值 mid 比想要的结果大
				right = mid;
			else			//表示估计值 mid 比想要的结果小
				left = mid;
			last = mid;		//记录本次计算出来的估计值
			mid = (left+right)/2;	//再次进行折半计算出估计值
		}while(Math.abs(mid-last)>eps);	//判断所求的估计值的精度是否够用
		return mid;
	}
	
	//使用牛顿插值计算开根号问题
	public double sqrtByNewtonMethod(int n, double eps) {
		if(n<0) return 0;
		double val = n;
		double last;
		do {
			last = val;
			val = (val+n/val)/2;
		}while(Math.abs(val-last)>eps);
		return val;
	}
	
	//判断一个数是不是素数
	public boolean isPrime(int n) {
		double x = sqrtByNewtonMethod(n, 1e-10);
		if(n==1 || n%2==0 && n!=2) return false;
		for(int i=3;i<x;i+=2)
			if(n%i==0)
				return false;
		return true;
	}
	
	//递归实现二叉树的前序遍历
	public void PreOrder_Recursion(TreeNode root, ArrayList<Integer> list){
		if(root!=null) {
			list.add(root.value);
			PreOrder_Recursion(root.left, list);
			PreOrder_Recursion(root.right, list);
		}
	}
	
	//非递归实现二叉树的前序遍历
	public List<Integer> PreOrder_NoRecursion(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		while(pNode!=null || !stack.isEmpty()) {
			if(pNode!=null) {
				list.add(pNode.value);
				stack.push(pNode);
				pNode = pNode.left;
			}else {
				pNode = stack.pop().right;
			}
		}
		return list;
	}
	
	//递归实现二叉树的中序遍历
	public void InOrder_Recursion(TreeNode root, ArrayList<Integer> list){
		if(root!=null) {
			InOrder_Recursion(root.left, list);
			list.add(root.value);
			InOrder_Recursion(root.right, list);
		}
	}
	
	//非递归实现二叉树的中序遍历
	public List<Integer> InOrder_NoRecursion(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		while(pNode!=null || !stack.isEmpty()) {
			if(pNode!=null) {
				stack.push(pNode);
				pNode = pNode.left;
			}else {
				list.add(stack.peek().value);
				pNode = stack.pop().right;
			}
		}
		return list;
	}
	
	//递归实现二叉树的后序遍历
	public void PostOrder_Recursion(TreeNode root, ArrayList<Integer> list) {
		if(root!=null) {
			PostOrder_Recursion(root.left, list);
			PostOrder_Recursion(root.right, list);
			list.add(root.value);
		}
	}
	
	//非递归实现二叉树的后序遍历
	public List<Integer> PostOrder_NoRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while(pNode!=null || !stack.isEmpty()){
            if(pNode!=null){
                stack.push(pNode);
                //一直向左移动指针
                pNode = pNode.left;
            }else{
                //如果当前节点为空,判断父节点的右节点是否为空
                if(stack.peek().right==null){
                    //父节点的右节点为空,将父节点输出,并且判断父节点是爷爷节点的左节点还是右节点
                    list.add(stack.peek().value);
                    TreeNode tempNode = stack.pop();
                    //如果输出父节点之后,栈空了,说明已经结束,返回结果
                    if(stack.isEmpty()){
                        return list;
                    }else if(tempNode==stack.peek().left){ //判断父节点是爷爷节点的左节点
                        pNode = stack.peek().right; //将指针指向爷爷节点的右节点
                    }else if(tempNode==stack.peek().right){ //判断父节点是爷爷节点的右节点
                        while(tempNode==stack.peek().right){ //循环判断曾爷爷节点是否是增增爷爷节点的右节点
                            list.add(stack.peek().value); //如果是,就将结果直接输出,并且栈中的元素依次弹栈
                            tempNode = stack.pop();
                            if(stack.isEmpty()) return list; //如果栈空了,接返回结果
                        } 
                    }
                }else{
                    //从栈中获取的父节点的右节点不为空,将指针指向右节点
                    pNode = stack.peek().right;
                }
            }
        }
        return list;
    }
	
	//层序遍历二叉树
	public List<Integer> SequenceOrder(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			if(queue.peek().left!=null) queue.add(queue.peek().left);
			if(queue.peek().right!=null) queue.add(queue.peek().right);
			list.add(queue.poll().value);
		}
		return list;
	}
	
	//通过前序和中序构建二叉树
    public TreeNode buildTreeByPreOrderAndInOrder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preorder==null || inorder==null || preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        for(int i=0;i<=inEnd;i++){
            if(inorder[i]==preorder[preStart]){
                root.left = buildTreeByPreOrderAndInOrder(preorder,preStart+1,(preStart+1)+(i-inStart)-1,inorder,inStart,i-1);
                root.right = buildTreeByPreOrderAndInOrder(preorder,(preStart+1)+(i-inStart),preEnd,inorder,i+1,inEnd);
            }
        }
        return root;
    }

    //通过中序和后序构建二叉树
    public TreeNode buildTreeByInOrderAndPostOrder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inorder==null || postorder==null || inStart>inEnd || postStart>postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        for(int i=0;i<=inEnd;i++){
            if(inorder[i]==postorder[postEnd]){
                root.left = buildTreeByInOrderAndPostOrder(inorder,inStart,i-1,postorder,postStart,postStart+(i-inStart)-1);
                root.right = buildTreeByInOrderAndPostOrder(inorder,i+1,inEnd,postorder,postStart+(i-inStart),postEnd-1);
            }
        }
        return root;
    }
	
    //递归实现DFS
  	public void DFS_Recursion(TreeNode root, ArrayList<Integer> list) {
  		if(root.left==null && root.right==null) {
  			list.add(root.value);
  			return;
  		}
  		if(root.left!=null) DFS_Recursion(root.left,list);
  		if(root.right!=null) DFS_Recursion(root.right,list);
  	}
    
	//非递归实现DFS
	public List<Integer> DFS_NoRecursion(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.value);
			if(node.right!=null) stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
		}
		return list;
	}
	
	//递归实现BFS
	public List<Integer> BFS(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.value);
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
		}
		return list;
	}
	
	//字符串翻转,字符串中包含一个或多个空格
	public String reverseString(String s) {
		char[] charArray = s.trim().toCharArray();
		reverseCharArray(charArray);
		String[] splitString = String.valueOf(charArray).split("\\s+");
		int len = splitString.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++) {
			char[] tempArray = splitString[i].toCharArray();
			reverseCharArray(tempArray);
			sb.append(String.valueOf(tempArray));
			if(i!=len-1) sb.append(" ");
		}
		return sb.toString();
	}
	
	//字符数组翻转
	public void reverseCharArray(char[] array) {
		if(array==null || array.length<1) return;
		int left = 0, right = array.length-1;
		while(left<right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}
	
	//从数组中找出一些数字,这些数字左面的数字都比自己小,右面的数字都比自己大
	public void findNumbers(int[] array) {
		if(array==null || array.length<1) return;
		int len = array.length;
		int[] rightMin = new int[len];
		rightMin[len-1] = array[len-1];
		for(int i=len-2;i>=0;i--)
			rightMin[i] = Math.min(array[i], rightMin[i+1]);
		int leftMax = 0;
		for(int i=0;i<len;i++) {
			leftMax = Math.max(array[i], leftMax);
			if(leftMax==rightMin[i])
				System.out.println(array[i]);
		}
	}
	
	//判断一棵树是不是二叉搜索树
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root==null) return true;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		if(left-right>1 || left-right<-1) return false;
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}
	
	//删除二叉搜索树中的给定节点
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null) return null;
		if(key<root.value) {
			root.left = deleteNode(root.left, key);
		}else if(key>root.value) {
			root.right = deleteNode(root.right, key);
		}else {
			if(root.left==null && root.right==null) {
				return null;
			}else if (root.left==null) {
				root = root.right;
			}else if (root.right==null) {
				root = root.left;
			}else {
				TreeNode beforeNode = root, afterNode = root.left;
				while(afterNode.right!=null) {
					beforeNode = afterNode;
					afterNode = afterNode.right;
				}
				root.value = afterNode.value;
				if(beforeNode!=root) {
					beforeNode.right = afterNode.left;
				}else {
					root.left = afterNode.left;
				}
			}
		}
		return root;
	}
	
	//计算二叉树的深度
	public int TreeDepth(TreeNode root) {
		if(root==null) return 0;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return (left>right) ? left+1 : right;
	}
	
	//判断二叉树是不是镜像二叉树
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root,root);
	}
	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null || root1.value!=root2.value) return false;
		return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
	}
	
	//寻找数组中的逆序对
	public int InversePairs(int[] array) {
		if(array==null || array.length<1) return 0;
		int len = array.length;
		int[] copy = new int[len];
		for(int i=0;i<len;i++)
			copy[i] = array[i];
		return InversePairs(array,copy,0,len-1);
	}
	private int InversePairs(int[] array, int[] copy, int start, int end) {
		if(start==end) {
			copy[start] = array[start];
			return 0;
		}
		int len = (end-start)/2;
		int count = 0;
		int left = InversePairs(copy,array,start,start+len);
		int right = InversePairs(copy,array,start+len+1,end);
		int i = start+len, j = end, copyIndex = end;
		while(i>=start && j>=start+len+1) {
			if(array[i]>array[j]) {
				copy[copyIndex--] = array[i];
				count = (count+j-start-len)%1000000007;
			}else {
				copy[copyIndex--] = array[j--];
			}
		}
		while(i>=start) copy[copyIndex--] = array[i--];
		while(j>=start+len+1) copy[copyIndex--] = array[j--];
		return (count+left+right)%1000000007;
	}
	
	
	public static void main(String[] args) {
		int[] array = {3,5,1,2,8,9,10,5};
//		BubbleSort(array);
//		MergeSort(array);
//		QuickSort_Recursion(array, 0, array.length-1);
//		QuickSort_NonRecursion(array, 0, array.length-1);
//		HeapSort(array);
//		RadixSort(array);
//		ShellSort(array);
		System.out.println(Arrays.toString(array));
//		System.out.println(BinarySearch(array, 5));
	}
	
	/**
	 *******************************************************************************************************
	 *												Time							Space		Stability
	 *------------------------------------------------------------------------------------------------------
	 *								Average			Best			Worst		AuxiliarySpace		
	 *------------------------------------------------------------------------------------------------------
	 *              InsertSort		O(n^2)			O(n)			O(n^2)			O(1)		Stable
	 * InsertSort 	----------
	 *              ShellSort		O(n^1.3)		O(n)			O(n^2)			O(1)		UnStable
	 * -----------------------------------------------------------------------------------------------------
	 *              SelectSort		O(n^2)			O(n^2)			O(n^2)			O(1)		UnStable
	 * SelectSort 	----------
	 *              HeapSort		O(nLogn)		O(nLogn)		O(nLogn)		O(1)		UnStable
	 * -----------------------------------------------------------------------------------------------------
	 *              BubbleSort		O(n^2)			O(n)			O(n^2)			O(1)		Stable
	 * ExchangeSort	----------
	 *              QuickSort		O(nLogn)		O(nLogn)		O(n^2)			O(nLogn)	UnStable
	 * -----------------------------------------------------------------------------------------------------
	 *        MergeSort    			O(nLogn)		O(nLogn)		O(nLogn) 		O(1)        Stable
	 * -----------------------------------------------------------------------------------------------------
	 *        RadixSort				O(d(r+n))		O(d(r+n))		O(d(r+n))		O(rd+n)		Stable
	 *******************************************************************************************************
	 *	r for keyword radix, d for length, n for keyword number
	 *******************************************************************************************************
	 */
	
}


class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) { val = x;}
}

class TreeNode {
	public int value;
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode(int x) { this.value = x;}
}
