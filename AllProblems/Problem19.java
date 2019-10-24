package Algorithm.Offer.AllProblems;

/**
 * 正则表达式匹配
 * @author Administrator
 *
 */
public class Problem19 {

	public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null) return false;
        return matchCore(str, 0, pattern, 0);
    }
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        int strLength = str.length;
        int patternLength = pattern.length;
        //str到尾，pattern到尾，匹配成功
        if (strIndex == strLength && patternIndex == patternLength) return true;
        //str未到尾，pattern到尾，匹配失败
        if (strIndex != strLength && patternIndex == patternLength) return false;
        //str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
        if (strIndex == strLength && patternIndex != patternLength) {
            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
            if (patternIndex + 1 < patternLength && pattern[patternIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            return false;
        }

        //str未到尾，pattern未到尾
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//*匹配0个,跳过
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//*匹配1个,跳过
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//* 匹配1个,再匹配str中的下一个
            } else {
                //直接跳过*（*匹配到0个）
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }
	
}
