package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 11:45 AM
 */
public class orange extends Food implements showcooking,eat{
    orange(){
        super("001","橙子","水果");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：生吃");
    }

    public void eat(){
        System.out.println(getName() + "生吃");
    }
}
