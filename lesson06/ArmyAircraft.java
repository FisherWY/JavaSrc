package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:35 PM
 */
public class ArmyAircraft extends Vehicle implements Run,Fly{
    ArmyAircraft() {
        super(100);
    }
    public void feature() {
        System.out.println("陆航飞机支持：跑，飞，载客");
    }
    public void run() {
        System.out.println("陆航飞机的跑功能");
    }
    public void fly() {
        System.out.println("陆航飞机的飞功能");
    }
}
