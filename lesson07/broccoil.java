package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 2:39 PM
 */
public class broccoil extends Food implements showcooking,eat,fry {
    broccoil(){
        super("007","西兰花","蔬菜");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：生吃，炒");
    }

    public void eat(){
        System.out.println(getName() + "真的可以生吃");
    }

    public void fry(){
        System.out.println(getName() + "真的可以炒着吃");
    }
}
