package mengxin;

/**
 *
 * @ Editor: Fisher
 * @ Date: 2018/9/4 下午8:41
 * @ Param: 
 * @ Return: 
 *
**/
public class StaticTest {
    static double PI = 3.1415;
    static int id;

    public static void method1(){
        System.out.println("Method 1");
    }

    public void method2(){
        System.out.println(StaticTest.PI);
        System.out.println(StaticTest.id);
        StaticTest.method1();
    }
/*
    public static mengxin.StaticTest method3(){
        method1();
    }*/
}
