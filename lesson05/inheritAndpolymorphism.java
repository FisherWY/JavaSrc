package lesson05;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 9:23 PM
 */
public class inheritAndpolymorphism {
    private static class person{
        private String namen,gender,age;
        person(){
            namen="person";
            gender="boy";
            age="20";
        }
        public void say(){
            System.out.println("class person: " + namen + " " + gender + " " + age);
        }
    }
    private static class father extends person{
        father(){
            super();
        }
        public void say(){
            System.out.println("Chinese");
        }
        public void drive(){
            System.out.println("car");
        }
    }
    private static class son extends father{
        son(){
            super();
        }
        public void say(){
            System.out.println("English+Chinese");
        }
        public void drive(){
            System.out.println("airplane");
        }
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入(1)father(2)son:");
        Integer input = scan.nextInt();
        if (input.equals(1)){
            father f1 = new father();
            f1.say();
            f1.drive();
        } else if (input.equals(2)){
            son s1 = new son();
            s1.say();
            s1.drive();
        } else {
            System.out.println("输入了无效数字");
        }
        scan.close();
    }
}
