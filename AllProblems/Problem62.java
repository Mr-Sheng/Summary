package Algorithm.Offer.AllProblems;

import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字
 * @author Administrator
 *
 */
public class Problem62 {

	public int LastRemaining_Solution(int n, int m) {
        if(n<=0 || m<=0) return -1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            list.add(i);
        int index = -1;
        while(list.size()>1){
            index = (index+m)%list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }
	
	
	/**
	 * 	k=(m-1)%n
		f(n,m)=f'(n-1,m)
		定义从f->f'的映射关系p(x)=(x-k-1)%n
		那么从f'->f的映射关系p^(-1)=(x+k+1)%n
		f(n,m)=f'(n-1,m)=[f(n-1,m)+k+1]%n=[f(n-1,m)+(m-1)+1]%n=[f(n-1,m)+m]%n
		f(n,m)=[f(n-1,m)+m]%n
	 * @param n:数字范围
	 * @param m:要删除的数字间隔
	 * @return n=5,m=3:(0,1,2,3,4)->(2,0,4,1,3)
	 */
	public int LastRemaining_Solution2(int n, int m) {
		if(n<=0 || m<=0) return -1;
        if(n==1) return 0;
        else return (LastRemaining_Solution(n-1,m)+m)%n;
	}
	
	public int LastRemaining_Solution3(int n, int m) {
        if(n<=0 || m<=0) return -1;
        int last = 0;
        for(int i=2;i<=n;i++)
            last = (last+m)%i;
        return last;
    }
	
}
