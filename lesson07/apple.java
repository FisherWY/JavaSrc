package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 11:40 AM
 */
public class apple extends Food implements showcooking, eat {
    apple(){
        super("000","苹果","水果");
    }

    public void eat(){
        System.out.println(getName() + "生吃");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：生吃");
    }
}
