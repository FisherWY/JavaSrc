package mengxin;

/**
 *
 * @ Editor: Fisher
 * @ Date: 2018/9/4 下午8:41
 * @ Param: 
 * @ Return: 
 *
**/
public class TransferProperty {
    int i = 47;
    public void call(){
        System.out.println("调用call()方法");
        for (i=0;i<3;i++){
            System.out.println(i + " ");
            if (i == 2){
                System.out.println("\n");
            }
        }
    }
    public TransferProperty(){

    }
    public static void main(String args[]){
        TransferProperty t1 = new TransferProperty();
        TransferProperty t2 = new TransferProperty();
        t2.i = 60;
        //使用第一个对象调用类成员变量
        System.out.println("第一个实例对象调用变量i的结果：" + t1.i++);
        t1.call();      //使用第一个对象调用类成员方法
        //使用第二个对象调用类成员变量
        System.out.println("第二个实例对象调用变量i的结果：" + t2.i);
        t2.call();      //使用第二个对象调用类方法
    }
}
