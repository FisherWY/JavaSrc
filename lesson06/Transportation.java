package lesson06;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/10/24 10:30 AM
 */
public class Transportation {
    private Vehicle vehicle;
    private Car car;
    public void TakeVehicle (Vehicle_interface v) {
        this.car = (Car)v;
        car.feature();
        car.run();
    }
}
