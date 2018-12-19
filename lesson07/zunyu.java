package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 2:33 PM
 */
public class zunyu extends Food implements showcooking,eat,bbq,fired {
    zunyu(){
        super("005","鳟鱼","鱼类");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：生吃，烤，煎");
    }

    public void eat(){
        System.out.println(getName() + "生吃");
    }

    public void bbq(){
        System.out.println(getName() + "BBQ");
    }

    public void fired(){
        System.out.println(getName() + "煎着吃");
    }
}
