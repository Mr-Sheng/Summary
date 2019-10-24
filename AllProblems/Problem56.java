package Algorithm.Offer.AllProblems;

/**
 * 数组中数字出现的次数
 * @author Administrator
 *
 */
public class Problem56 {

	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<=1) return;
        int length = array.length;
        int result = array[0];
        for(int i=1;i<length;i++)
            result = result ^ array[i]; 
        int indexOf1 = FindFirstBitIs1(result);
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<length;i++){
            if(IsBit1(array[i],indexOf1)!=0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }
    public int FindFirstBitIs1(int result){
        int indexBit = 0;
        while((result & 1)==0  &&  (indexBit<8*Integer.SIZE)){
            result = result >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    public int IsBit1(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1);
    }
	
}
