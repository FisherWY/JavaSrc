package lesson04;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 2:52 PM
 */
public class guess {
    public static int MakeNum(){
        int sum = 0;
        for (int i=0;i<3;i++){
            int add = 1 + (int)(Math.random()*6);
            sum += add;
        }
        return sum;
    }

    public static void main(String args[]){
        String regex = "(^[bs])";
        Scanner scan = new Scanner(System.in);
        int UserScore = 5000;
        int AiScore = 10000;
        do {
            //显示当前分数
            System.out.println("当前玩家分数：" + UserScore);
            System.out.println("当前AI分数：" + AiScore);
            //判断下注分数是否合法
            System.out.println("下注多少(0-" + UserScore + "):");
            int buy = scan.nextInt();
            System.out.println("你的输入：" + buy);
            if (buy>UserScore || buy<=0){
                System.out.println("输入有误，重新开始一轮");
                continue;
            }
            //买大买小，判读输入是否合法
            System.out.println("买大买小(b/s)：");
            String input = scan.next();
            System.out.println("你的输入：" + input);
            if (!input.matches(regex)){
                System.out.println("输入有误，重新开始一轮");
                continue;
            }
            //随机产生点数，判断输赢
            int point = MakeNum();
            //用户必输情况
            if (buy>=1000 && AiScore<UserScore) {
                if (input.equals("b"))
                    point = 3 + (int)(Math.random()*7);
                else
                    point = 10 + (int)(Math.random()*8);
            }
            //分数结算
            System.out.println("三个骰子的分数之和：" + point);
            if ((input.equals("b") && point>=10) || (input.equals("s") && point<10)){
                System.out.println("你赢了");
                UserScore += buy;
                AiScore -= buy;
            } else {
                System.out.println("你输了");
                UserScore -= buy;
                AiScore += buy;
            }
            //一轮之后的分数
            System.out.println("当前玩家分数：" + UserScore);
            System.out.println("当前AI分数：" + AiScore);
            //玩家或电脑的分数够不够下一轮
            if (UserScore <= 0 || AiScore <= 0){
                System.out.println("游戏无法继续，有个人破产了");
                break;
            }
            //退出
            System.out.println("继续吗？(任意字符继续，输入exit退出):");
        } while (!scan.next().equals("exit"));
        System.out.println("游戏结束");
        scan.close();
    }
}
