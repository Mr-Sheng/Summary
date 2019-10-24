package Algorithm.Offer.AllProblems;

/**
 * 替换空格
 * @author Administrator
 *
 */
public class Problem05 {

	public static String test(StringBuffer str) {
		if(str!=null){
            int stringNum = str.length();
            int spaceNum = 0;
            
            for(int i=0;i<stringNum;i++){
                if(str.charAt(i)==' ')
                    ++spaceNum;
            }
            
            int replaceNum = stringNum + 2*spaceNum;
            StringBuffer newBuffer = new StringBuffer(replaceNum);
            
            for(int j=stringNum-1; j>-1;j--){
                if(str.charAt(j)==' '){
                    newBuffer.append('0');
                    newBuffer.append('2');
                    newBuffer.append('%');
                }else{
                    newBuffer.append(str.charAt(j));
                }
            }
            return newBuffer.reverse().toString();
        }
        return "";
	}
	
}
