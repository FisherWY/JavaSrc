package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:36 PM
 */
public class Seaplane extends Vehicle implements Swim,Fly{
    Seaplane() {
        super(90);
    }
    public void feature() {
        System.out.println("水上飞机支持：游，飞，载客");
    }
    public void swim() {
        System.out.println("水上飞机的游功能");
    }
    public void fly() {
        System.out.println("水上飞机的飞功能");
    }
}