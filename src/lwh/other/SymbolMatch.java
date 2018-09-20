package lwh.other;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author lwh
 * @date 2018-09-20
 * @desp 输入一个序列, 判断是否满足括号匹配
 */
public class SymbolMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            stack.push(chs[0]);

            for (int i = 1; i < chs.length; i++) {
                if(stack.isEmpty()){
                    stack.push(chs[i]);
                    continue;
                }
                Character c1 = stack.peek();
                Character c2 = chs[i];
                boolean flag1 = c1.toString().equals("(") && c2.toString().equals(")");
                boolean flag2 = c1.toString().equals("[") && c2.toString().equals("]");
                boolean flag3 = c1.toString().equals("{") && c2.toString().equals("}");
                if(flag1 || flag2 || flag3){
                    stack.pop();
                }else{
                    stack.push(c2);
                }
            }

            System.out.println(str + "是否括号匹配: " + stack.isEmpty());
        }
    }
}
