package Chapter_10;

import lesson01.FibonacciNum;

/**
 * @Author: Fisher
 * @Date: 2018/10/17 10:34 AM
 */
public class InterfaceDemo {
    //定义接口
    interface drawTest{
        //定义方法
        public void draw();
        public void test();
    }
    //四边形类
    public static class QuadrangleUseInterface {
        public void doAnything(){
            System.out.println("父类doAnything");
        }
    }
    //定义平行四边形类，该类继承了四边形类，并实现了drawTest接口
    static class Parallelogramgle extends QuadrangleUseInterface implements drawTest{
        public void draw(){
            System.out.println("平行四边形draw()");
        }
        public void test(){
            System.out.println("平行四边形test()");
        }
        public void doAnything(){
            System.out.println("平行四边形doAnything");
        }
    }
    static class Square extends QuadrangleUseInterface implements drawTest{
        public void draw(){
            System.out.println("正方形draw()");
        }
        public void doAnything(){
            System.out.println("正方形doAnything");
        }
        public void test(){
            System.out.println("正方形test()");
        }
    }

    public static void main(String args[]){
        drawTest[] d = { new Square(), new Parallelogramgle() };
        for (int i=0; i<d.length; i++){
            d[i].draw();
            d[i].test();
        }
        int a = FibonacciNum.Fibonacci(10);
        System.out.println(a);
    }
}
