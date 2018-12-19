package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/30 11:29 PM
 */
public class t3 {
    public static void main(String args[]){
        t2 t = new t2();
        t.doit();       //可以访问t2中的公有方法
//        System.out.println("t2中的a：" + t.a);       //报错，无法访问t中的私有元素
//        t.my();       //报错，无法访问t中的私有方法
        t.visit();      //t1类可以访问t2中的元素
    }
}
