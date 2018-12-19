package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/30 11:24 PM
 */
public class t2 {
    private int a = 1;
    private t1 t = new t1();
    private class t1 {
        t1(){
            System.out.println("内部类t1构造函数");
        }
        public void doit() {
            System.out.println("内部类t1 doit, 访问a:" + a);
        }
    }
    public void doit(){
        System.out.println("类t2 doit：" + a);
    }
    private void my(){
        System.out.println("类t2 my私有方法");
    }
    public void visit(){
        t.doit();
    }
}
