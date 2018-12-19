package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 2:36 PM
 */
public class tomato extends Food implements showcooking, eat, fry, soup {
    tomato() {
        super("006", "西红柿", "蔬菜");
    }

    public void showcooking() {
        System.out.println(getNo() + getName() + getType() + " => 可以：生吃，炒，汤");
    }

    public void eat() {
        System.out.println(getName() + "生吃真香");
    }

    public void fry() {
        System.out.println(getName() + "炒的真香");
    }

    public void soup() {
        System.out.println(getName() + "煲汤好喝");
    }
}
