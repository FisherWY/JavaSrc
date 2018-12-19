package lesson08;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 10:40 AM
 */
public class TestUser_TT {
    public static void main(String args[]){
        TT<Integer> t1 = new TT<Integer>();
        System.out.println("t1: " + t1.getId());
        t1.setId(1);
        System.out.println("new t1: " + t1.getId());
    }
}
