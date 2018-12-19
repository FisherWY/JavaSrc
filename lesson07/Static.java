package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 10:56 AM
 * 静态类与非静态类的区别
 */
public class Static {
    private static int a = 0;
    private int b = 1;

    //非静态内部类
    class innerclass0 {
//        private static int c = 2;     //错误，非静态类中不能有静态元素
        private int c = 2;
        public void doit(){
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }

    //静态内部类
    static class innerclass1 {
        private static int d = 3;
        private int e = 4;
        public void doit(){
            System.out.println(a);
//            System.out.println(b);    //错误，静态类中不能访问外部非静态元素
            System.out.println(d);
            System.out.println(e);
        }
    }

    private void print(){
        innerclass0 i0 = new innerclass0();
        innerclass1 i1 = new innerclass1();
        System.out.println("非静态类：");
        i0.doit();
        System.out.println("静态类:");
        i1.doit();
    }

    public static void main(String args[]){
        Static s0 = new Static();
        s0.print();
    }
}
