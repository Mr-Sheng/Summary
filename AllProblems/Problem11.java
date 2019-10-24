package Algorithm.Offer.AllProblems;

/**
 * 旋转数组的最小数字
 * @author Administrator
 *
 */
public class Problem11 {
	
	public static void main(String[] args) {
//		int[] array = {1,0,1,1,1};
//		System.out.println(minNumberInRotateArray(array));
		int[] array = {7,8,9,1,3,4,5,6};
		System.out.println(search(array, 8));
	}

	//旋转数组的最小数字(数组中可以包含重复数字 leetcode-153,154)
	public static int minNumberInRotateArray(int [] array) {
        if(array==null||array.length<=0) return 0;
        int index1 = 0;
        int index2 = array.length-1;
        int indexMid = index1;       
        while(array[index1]>=array[index2]){
            if(index2-index1==1){
                indexMid = index2;
                break;
            }
            indexMid = (index2+index1)/2;
            if(array[index1]==array[index2] && array[indexMid]==array[index1]){
                int result = array[index1];
                for(int i=index1+1;i<=index2;i++){
                    if(result>array[i])
                        result = array[i];
                }
                return result;
            }
            if(array[indexMid]>=array[index1]){
                index1 = indexMid;
            }else if(array[indexMid]<=array[index2]){
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }
	
	//搜索旋转排序数组(无重复数字 leetcode-33)
	public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start<=end) {
        	int mid = (start+end)/2;
        	if(target==nums[mid]) {
        		return mid;
        	}else if(nums[start]<=nums[mid]) {
        		if(nums[start]<=target && target<nums[mid]) {
        			end = mid-1;
        		}else {
        			start = mid+1;
        		}
        	}else {
        		if(nums[mid]<target && target<=nums[end]) {
        			start = mid+1;
        		}else {
        			end = mid-1;
        		}
        	}
        }
        return -1;
    }
	
	//搜索旋转排序数组(无重复数字  leetcode-81)
	public boolean search2(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return true;
            if(nums[start]==nums[mid]){
                start++;
                continue;
            }
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
	
}
