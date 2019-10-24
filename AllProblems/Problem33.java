package Algorithm.Offer.AllProblems;

public class Problem33 {
	
	public static void main(String[] args) {
		int[] sequence = {5,7,6,9,11,10,8};
		System.out.println(VerifySquenceOfBST(sequence));
	}

//	public static boolean VerifySquenceOfBST(int[] sequence) {
//        if(sequence.length==0) return false;
//        if(sequence.length==1) return true;
//        return test(sequence,sequence.length);
//    }
//	
//	public static boolean test(int[] sequence,int length) {
//		if(sequence==null || length<=0) return false;
//		int root = sequence[length-1];
//		
//		int i=0;
//		for(;i<length-1;++i) {
//			if(sequence[i]>root)
//				break;
//		}
//		int j=i;
//		for(;j<length-1;++j) {
//			if(sequence[j]<root)
//				return false;
//		}
//		
//		boolean left = true;
//		if(i>0) left = test(sequence, i);
//		boolean right = true;
//		int[] sequenceTest = new int[length-i-1];
//		for (int k = 0; k < sequenceTest.length; k++) {
//			sequenceTest[k] = sequence[k+i];
//		}
//		if(i<length-1) right = test(sequenceTest, length-i-1);
//		
//		return (left && right);
//		
//	}
	
	public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length<1) return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    private static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if(start==end) return true;
        int root = sequence[end];
        int index1 = start;
        for(;index1<end;index1++)
            if(sequence[index1]>root)
                break;
        int index2 = index1;
        for(;index2<end;index2++)
            if(sequence[index2]<root)
                return false;
        boolean left = true, right = true;
        if(index1>0) VerifySquenceOfBST(sequence,start,index1-1);
        if(index2<end) VerifySquenceOfBST(sequence,index1,end-1);
        return left&&right;
    }
	
}
