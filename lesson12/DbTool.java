package lesson12;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author Fisher
 * @Date 2018/12/12 11:20
 **/
public class DbTool {
    private Connection connection;
    //这里使用了mysql8.0版本
    private final String driver = "com.mysql.cj.jdbc.Driver";
    //在mysql8.0中，url需要传时区的参数
    private final String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2b8";
    private final String user = "fisher";
    private final String psw = "12345678";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            System.out.println("successfully loaded driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, psw);
            System.out.println("successfully connected to the server");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
