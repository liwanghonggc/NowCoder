package lwh.codeguide.video;

import java.util.Stack;

/**
 * 将栈按从顶到底从大到小的顺序排序,只允许申请一个栈,不能申请其他数据结构
 * @author lwh
 *
 */
public class SortStackByStack1 {

	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();
	
	public void sort(){
		int len = s1.size();
		for(int i = 0; i < len - 1; i++){
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < len - i; j++){
				int temp = s1.pop();
				min = temp < min ? temp : min;
				s2.push(temp);
			}
			s1.push(min);
			boolean flag = false;
			while(!s2.isEmpty()){
				int num = s2.pop();
				if(num == min && flag == false){
					flag = true;
					continue;
				}
				s1.push(num);
			}
		}
	}
	
	public void printS1(){
		while(!s1.isEmpty()){
			System.out.print(s1.pop() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SortStackByStack1 s = new SortStackByStack1();
		s.s1.push(4);
		s.s1.push(2);
		s.s1.push(4);
		s.s1.push(4);
		s.s1.push(2);
		s.s1.push(7);
		s.s1.push(9);
		s.s1.push(8);
		s.s1.push(1);
		s.s1.push(4);
		
		s.sort();
		
		s.printS1();
	}

}
