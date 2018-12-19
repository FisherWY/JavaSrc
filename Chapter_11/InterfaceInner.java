package Chapter_11;

/**
 * @Author: Fisher
 * @Date: 2018/10/26 8:27 PM
 */

//内部类向上转型为接口
interface OutInterface {
    public void f();
}

class OutClass2 {
    //定义一个内部类实现OutInterface接口
    private class InnerClass implements OutInterface {
        //内部构造类
        InnerClass(String s) {
            System.out.println(s);
        }
        //实现接口中f()方法
        public void f() {
            System.out.println("内部类中的f()方法");
        }
    }

    //定义一个方法，返回值类型为OutInterface接口
    public OutInterface doit() {
        return new InnerClass("访问内部类构造方法");
    }
}


//匿名内部类
interface OutInterface2 {

}

class OutClass4 {
    public OutInterface2 doit() {
        return new OutInterface2() {
            private String i = "12345678";
            public String getValue() {
                return i;
            }
        };
    }
}

public class InterfaceInner {
    public static void main(String args[]){
        //实例化一个OuterClass对象
        OutClass2 out = new OutClass2();
        //调用doit()方法，返回一个OutInterface接口
        OutInterface outinter = out.doit();
        outinter.f();

        //实例化一个OutClass4对象
        OutClass4 out4 = new OutClass4();
        //调用doit()方法，返回一个OutInterface2接口
        OutInterface2 outinter2 = out4.doit();
        //outinter2.getValue();
    }
}
