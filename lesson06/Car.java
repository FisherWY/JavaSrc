package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:31 PM
 */
public class Car extends Vehicle implements Run{
    Car() {
        super(55);
    }
    public void feature() {
        System.out.println("汽车支持：跑，载客功能");
    }
    public void run() {
        System.out.println("汽车的跑功能");
    }
}