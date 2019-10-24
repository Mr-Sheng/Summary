package Algorithm.Offer.AllProblems;

/**
 * 二维数组中的查找
 * @author Administrator
 *
 */
public class Problem04 {

    public boolean Find(int target, int [][] array) {
    	
    	if (array!=null && array.length>0) {
    		int rows = array.length;
    		int columns = array[0].length;
    		int row = 0;
    		int column = columns-1;
			while(row<rows && column>=0) {
				if (array[row][column]==target) {
					return true;
				}else if(array[row][column] > target) {
					--column;
				}else {
					++row;
				}
			}
		}
        
//        if(array!=null && array.length>0){
//            int rows = array.length;
//            int columns = array[0].length;
//            int row = rows-1;
//            int column = 0;
//            while(row>=0 && column<columns){
//                if(array[row][column]==target){
//                    return true;
//                }else if(array[row][column]<target){
//                    ++column;
//                }else{
//                    --row;
//                }
//            }
//        }
        return false;
        
    }
	
	public static void main(String[] args) {
		
	}
	
}
