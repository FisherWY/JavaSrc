package lesson12;

import java.sql.Connection;

/**
 * @Author Fisher
 * @Date 2018/12/14 20:32
 **/
public class TestPool {
    public static void main(String args[]){
        DbUtil db = new DbUtil();
        try {
            Connection connection = db.getConnection();
            System.out.println("oooooo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
