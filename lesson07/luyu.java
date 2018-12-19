package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 2:30 PM
 */
public class luyu extends Food implements showcooking, steam, bbq, fired {
    luyu() {
        super("004", "鲈鱼", "鱼类");
    }

    public void showcooking() {
        System.out.println(getNo() + getName() + getType() + " => 可以：蒸，烤，煎");
    }

    public void steam() {
        System.out.println(getName() + "蒸着吃好营养");
    }

    public void bbq() {
        System.out.println(getName() + "BBQ");
    }

    public void fired() {
        System.out.println(getName() + "煎着吃");
    }
}
