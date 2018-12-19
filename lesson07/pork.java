package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 2:27 PM
 */
public class pork extends Food implements showcooking,bbq,fry,stew{
    pork(){
        super("003","猪肉","肉类");
    }

    public void showcooking(){
        System.out.println(getNo() + getName() + getType() + " => 可以：烤，炒，炖");
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
}
