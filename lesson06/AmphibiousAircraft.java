package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:36 PM
 */
public class AmphibiousAircraft extends Vehicle implements Run,Swim,Fly{
    AmphibiousAircraft() {
        super(30);
    }
    public void feature() {
        System.out.println("水陆两用飞机支持：跑，游，飞，载客");
    }
    public void run() {
        System.out.println("水陆两用飞机的跑功能");
    }
    public void swim() {
        System.out.println("水陆两用飞机的游功能");
    }
    public void fly() {
        System.out.println("水陆两用飞机的飞功能");
    }
}