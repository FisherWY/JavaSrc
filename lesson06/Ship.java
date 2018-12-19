package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:34 PM
 */
public class Ship extends Vehicle implements Swim{
    Ship() {
        super(300);
    }
    public void feature() {
        System.out.println("轮船支持：游，载客功能");
    }
    public void swim() {
        System.out.println("轮船的游功能");
    }
}