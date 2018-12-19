package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:26 PM
 */
public abstract class Vehicle implements Vehicle_interface,Takepassenger{
    private int Passenger;
    Vehicle() {
        this.Passenger = 0;
    }
    Vehicle(int Passenger) {
        this.Passenger = Passenger;
    }
    public abstract void feature();
    public void takepassenger() {
        System.out.println("载客量:"+Passenger);
    }
}