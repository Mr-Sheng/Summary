package Algorithm.Offer.AllProblems;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author Administrator
 *
 */
public class Problem29 {

	public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix==null || matrix.length<=0) return list;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while(rows>start*2 && columns>start*2){
            printMatrix(matrix,list,rows,columns,start);
            ++start;
        }
        return list;
    }
    public void printMatrix(int [][] matrix,ArrayList<Integer> list,int rows,int columns,int start){
        int endX = columns-1-start;
        int endY = rows-1-start;
        
        //从左到右打印
        for(int i=start;i<=endX;i++)
            list.add(matrix[start][i]);
        
        //从上到下打印
        if(start<endY){
            for(int i=start+1;i<=endY;i++)
                list.add(matrix[i][endX]);
        }
        
        //从右到左打印
        if(start<endX && start<endY){
            for(int i=endX-1;i>=start;i--)
                list.add(matrix[endY][i]);
        }
        
        //从下到上打印
        if(start<endX && start<endY-1){
            for(int i=endY-1;i>=start+1;i--)
                list.add(matrix[i][start]);
        }
    }
	
}
