package lwh.other;

import java.util.Scanner;

public class PrintDiamond {

    public static void main(String[] args) {
        int rows = 0;    //菱形的行数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入菱形行数：");
        rows = input.nextInt();

        while (rows % 2 == 0) {
            System.out.print("请输入奇数：");
            rows = input.nextInt();
        }

        int n = (rows + 1) / 2;
        //打印菱形的上半部分
        for (int i = 1; i <= n; i++) {//外层循环变量i控制行数
            for (int j = 1; j <= n - i; j++) {//内层循环变量j控制该行空格数
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {//内层循环变量k控制该行*号数
                System.out.print("*");
            }
            System.out.print("\n");
        }
        //打印菱形的下半部分
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}
