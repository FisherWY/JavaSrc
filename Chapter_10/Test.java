package Chapter_10;

/**
 * @Author: Fisher
 * @Date: 2018/9/10 上午11:08
 */
class Test1 {
    public Test1() {      //构造方法
        System.out.println("Constructor of Test");
    }

    protected void doSomething() {       //成员方法
        System.out.println("Protected Funtion doSomething of Test");
    }

    protected Test1 doIt() {      //方法返回值类型为Test类型
        return new Test1();
    }
}

class Test2 extends Test1 {       //继承父类
    public Test2() {             //构造方法
        super();                //调用父类构造方法
        super.doSomething();    //调用父类成员方法
    }

    public void doSomethingnew() {       //新增方法
        System.out.println("Public Function doSomethingnew of Test2");
    }

    public void doSomething() {          //重写父类方法
        System.out.println("Override Function doSomething");
    }

    protected Test2 doIt() {             //重写父类方法
        return new Test2();
    }
}

class Test {
    public static void main(String args[]) {
        Test1 t1 = new Test1();
        t1.doSomething();
        t1.doIt();
        Test2 t2 = new Test2();
        t2.doSomething();
        t2.doIt();
        t2.doSomethingnew();
    }
}