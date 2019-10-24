package Algorithm.Offer.AllProblems;

/**
 * 在排序数组中查找数字
 * @author Administrator
 *
 */
public class Problem53 {

	//暴力遍历法
	public int GetNumberOfK(int [] array , int k) {
       if(array==null) return -1;
        int length = array.length;
        int count = 0;
        for(int i=0;i<length;i++)
            if(array[i]==k)
                count++;
        return count;
    }
	
	//使用二分查找的方式分别找出该数字在排序数组中第一个和最后一个的位置
	public int GetNumberOfK2(int [] array , int k) {
        if(array==null || array.length<0) return -1;
        int length = array.length;
        int number = 0;
        int first = GetFirstK(array,k,0,length-1);
        int last = GetLastK(array,k,0,length-1);
        if(first>-1 && last>-1)
            number = last-first+1;
        return number;
    }
	
	//使用二分查找找到目标值k在数组中第一次出现的位置
	public int GetFirstK(int[] array,int k,int start,int end){
        if(array==null || start>end) return -1;
        int middleIndex = (start+end)>>1;
        int middleData = array[middleIndex];
        if(middleData==k){
            if(middleIndex==0 || (middleIndex>0 && array[middleIndex-1]!=k))
                return middleIndex;
            else
                end = middleIndex-1;
        }else if(middleData<k){
            start = middleIndex+1;
        }else{
            end = middleIndex-1;
        }
        return GetFirstK(array,k,start,end);
    }
    
	//使用二分查找找到目标值k在数组中最后一次出现的位置
    public int GetLastK(int[] array,int k,int start,int end){
    	if(array==null || start>end || array.length<=0) return -1;
    	int length = array.length;
    	int middleIndex = (start+end)>>1;
    	int middleData = array[middleIndex];
    	if(middleData==k){
    	    if(middleIndex==length-1 || (middleIndex<length && array[middleIndex+1]!=k))
    	        return middleIndex;
    	    else
    	        start = middleIndex+1;
    	}else if(middleData<k){
    	    start = middleIndex+1;
    	}else{
    	    end = middleIndex-1;
    	}
    	return GetLastK(array,k,start,end);
    }
    
    
    //投机取巧的方式
    public int GetNumberOfK3(int [] array , int k) {
        if(array==null || array.length<0) return -1;
        return GetNumberOfK(array,k+0.5)-GetNumberOfK(array,k-0.5);
    }
    
    //仍然是使用二分查找的方式,在数组中寻找比target-0.5大和比target+0.5大的数字在数组中出现的位置
    public int GetNumberOfK(int[] array,double num){
        if(array==null) return -1;
        int length = array.length;
        int start=0,end=length-1;
        while(start<=end){
            int mid = (start+end)>>1;
            if(array[mid]<num){
                start = mid+1;
            }else if(array[mid]>num){
                end = mid-1;
            }
        }
        return start;
    }
    
    //自己的使用二分查找的方式
    public int GetNumberOfK4(int [] array , int k) {
        if(array==null || array.length<1) return 0;
        int length = array.length;
        int index = searchNumberIndex(array,0,length-1,k);
        if(index==-1) return 0;
        int index1 = index, index2 = index;
        int indexLeft = index1, indexRight = index1;
        while(index1>-1){
            indexLeft = index1;
            if(index1>0){
                index1 = searchNumberIndex(array,0,index1-1,k);
            }else{
                break;
            }
        }
        while(index2>-1){
            indexRight = index2;
            if(index2<length-1){
                index2 = searchNumberIndex(array,index2+1,length-1,k);
            }else{
                break;
            }
        }
        return indexRight-indexLeft+1;
    }
    
    //使用二分查找的方式在数组中找到目标值所在的位置,但是并不能保证是第一次出现的位置
    private int searchNumberIndex(int[] array, int start, int end, int k){
        if(start>end || k<array[start] || k>array[end]) return -1;
        int mid = (start+end)/2;
        if(k<array[mid]){
            return searchNumberIndex(array,start,mid-1,k);
        }else if(k>array[mid]){
            return searchNumberIndex(array,mid+1,end,k);
        }else{
            return mid;
        }
    }
    
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    private int searchInsert(int[] array, int start, int end, int target) {
    	if(start>end) return -1;
        if(target<array[start]) return start;
        if(target>array[end]) return end+1;
        int mid = (start+end)/2;
        if(target<array[mid]){
            return searchInsert(array,start,mid-1,target);
        }else if(target>array[mid]){
            return searchInsert(array,mid+1,end,target);
        }else{
            return mid;
        }
    }
	
}


