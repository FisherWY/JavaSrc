package Chapter_10;

/**
 * @Author: Fisher
 * @Date: 2018/9/12 上午10:35
 */
public class ObjectInstance {
    public String toString() {
        return "在" + getClass().getName() + "类中重写toString()方法";
    }

    public static void main(String args[]) {
        System.out.println(new ObjectInstance());
    }
}
