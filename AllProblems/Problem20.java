package Algorithm.Offer.AllProblems;

/**
 * 表示数值的字符串
 * @author Administrator
 *
 */
public class Problem20 {

	public static void main(String[] args) {
		String str = "1 ";
		System.out.println(isNumber(str));
	}
	
//	public boolean isNumeric(char[] str) {
//		boolean signal = false;//正负号标志
//		boolean decimal = false;//小数点标志
//		boolean hasE = false;//e或E标志
//		for(int i=0;i<str.length;i++) {
//			if (str[i]=='e' || str[i]=='E') {
//				if(hasE || i==0 || i==str.length-1) return false;
//				hasE = true;
//			}else if (str[i]=='+' || str[i]=='-') {
//				if(signal && str[i-1]!='e' && str[i-1]!='E') return false;
//				if(!signal && i>0 && str[i-1]!='e' && str[i-1]!='E') return false;
//				signal = true;
//			}else if (str[i]=='.') {
//				if(decimal) return false;
//				if(hasE) 
//					for(int j=i;j>0;j--) 
//						if(str[j]=='e' || str[j]=='E')
//							return false;
//				decimal = true;
//			}else if (str[i]<'0' || str[i]>'9') { //注意这个判断条件不可以放在第一个进行判断
//				return false;
//			}
//		}
//		return true;
//	}
	public static boolean isNumber(String s) {
        if(s==null || s.length()<1) return false;
        boolean signal = false;//是否出现过+和-的标志
        boolean decimal = false;//是否出现过.的标志
        boolean hasE = false;//是否出现过e的标志
        int spaceNum = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();
        for(int i=0;i<length;i++){
            if(charArray[i]=='e'||charArray[i]=='E'){
                if(hasE || i==0 || i==length-1) return false; //如果之前已经出现过e或者第一次出现e的位置在最开始或者最末尾，返回false;
                hasE = true;//标志e已经出现过
            }else if(charArray[i]=='+'||charArray[i]=='-'){
                if(signal && charArray[i-1]!='e' && charArray[i-1]!='E') return false;
                if(!signal && i>0 && charArray[i-1]!='e' && charArray[i-1]!='E') return false;
                signal = true;
            }else if(charArray[i]=='.'){
                if(decimal) return false;
                if(i==0) return false;
                if(hasE){
                    for(int j=i;j>0;j--)
                        if(charArray[j]=='e'||charArray[j]=='E')
                            return false;
                }
                decimal = true;
            }else if(charArray[i]<'0' || charArray[i]>'9'){
            	if(charArray[i]==' '){
                    spaceNum++;
                }else {
                	return false;
				}
            }
        }
        if(spaceNum==length) 
        	return false;
        return true;
    }
	
}
