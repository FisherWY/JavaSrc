package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 12:17 PM
 */
public class beef extends Food implements showcooking,bbq,fry,stew {
    beef(){
        super("002","牛肉","肉类");
    }

    public void bbq(){
        System.out.println(getName() + "烤着吃");
    }

    public void fry(){
        System.out.println(getName() + "炒着吃");
    }

    public void stew(){
        System.out.println(getName() + "炖着吃");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：烤，炒，炖");
    }
}
