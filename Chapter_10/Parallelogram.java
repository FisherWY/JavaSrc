package Chapter_10;

/**
 * @Author: Fisher
 * @Date: 2018/9/12 上午11:13
 */
class Quadrangle {
    public static void draw(Quadrangle q){
        System.out.println("Function draw in Qualrangle");
    }
}

class Square extends Quadrangle{
    //doSomething
}

class Anything{
    //doSomething
}

public class Parallelogram extends Quadrangle{
    public static void main(String args[]){
        Quadrangle q = new Quadrangle();       //实例化父类对象
        //判断父类对象是否为 Parallelogram子类的一个实例
        if (q instanceof Parallelogram){
            Parallelogram p = (Parallelogram)q;     //向下转型操作
        }
        //判断父类对象是否为Square子类的一个实例
        if (q instanceof Square){
            Square s = (Square)q;
        }
        //由于q对象不为Anything类的对象，所以这条语句是错的
        //System.out.println(q instanceof Anything);
    }
}
