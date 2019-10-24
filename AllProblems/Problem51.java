package Algorithm.Offer.AllProblems;

/**
 * 数组中的逆序对
 * @author Administrator
 *
 */
public class Problem51 {
	
	public static void main(String[] args) {
		
	}

//	public static int InversePairs(int [] array) {
//        if(array==null || array.length==0) return 0;
//        int length = array.length;
//        int P = 0;
//        for(int i=0;i<length;i++){
//            for(int j=i+1;j<length;j++){
//                if(array[i]>array[j])
//                    P++;
//            }
//        }
//        return P%1000000007;
//    }
	
	public int InversePairs(int [] array) {
        if(array==null || array.length<=0) return 0;
        int length = array.length;
        int[] copy = new int[length];
        for(int i=0;i<length;i++)
            copy[i] = array[i];
        int count = InversePairsCore(array,copy,0,length-1);
        return count%1000000007;
    }
    
    public int InversePairsCore(int[] array,int[] copy,int start,int end){
        if(start==end){
            copy[start] = array[start];
            return 0;
        }
        int length = (end-start)/2;
        int left = InversePairsCore(copy,array,start,start+length);
        int right = InversePairsCore(copy,array,start+length+1,end);
        int i = start+length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i>=start && j>=start+length+1){
            if(array[i]>array[j]){
                copy[indexCopy--] = array[i--];
                count += j-start-length;
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(;i>=start;i--)
            copy[indexCopy--]=array[i];
        for(;j>=start+length+1;j--)
            copy[indexCopy--]=array[j];
        return count+left+right;
    }
	
}
