package lesson06;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 8:50 PM
 */
public class Main {
    public static void main(String args[]){
        Transportation transportation = new Transportation();
        Vehicle_interface vehicle_interface = new Car();
        transportation.TakeVehicle(vehicle_interface);
    }
}
