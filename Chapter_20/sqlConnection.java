package Chapter_20;

import java.sql.*;

/**
 * @Author Fisher
 * @Date 2018/12/7 21:25
 **/
public class sqlConnection {
    static Connection connection;
    static Statement sql;
    static ResultSet res;

    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8";
    final static String user = "fisher";
    final static String psw = "12345678";

    public Connection getConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, psw);
            System.out.println("successfully connected to Mysql server");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void sqlSelect() {
        try {
            //实例化statement对象
            sql = connection.createStatement();
            //执行sql语句，返回结果集
            res = sql.executeQuery("select * from table1");
            while (res.next()) {
                //获取列名是ID的字段值
                String ID = res.getString("ID");
                //获取列名是event的字段值
                String Event = res.getString("Event");
                //输出
                System.out.println("ID: " + ID);
                System.out.println("Event: " + Event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlInsert() {
        try {
            sql = connection.prepareStatement("insert into table1(Event) values (?)");
//            ((PreparedStatement) sql).setString(1, "4");
            ((PreparedStatement) sql).setString(1,"fffff");
            ((PreparedStatement) sql).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlUpdate() {
        try {
            sql = connection.prepareStatement("update table1 set Event = ? where id = ?");
            ((PreparedStatement) sql).setInt(1,1);
            ((PreparedStatement) sql).setString(2,"qwert");
            ((PreparedStatement) sql).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlDelete() {
        try {
            sql = connection.prepareStatement("delete from table1 where id = ?");
            ((PreparedStatement) sql).setInt(1,3);
            ((PreparedStatement) sql).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        sqlConnection c = new sqlConnection();
        c.getConnection();

        System.out.println("data before insert: ");
        c.sqlSelect();

        System.out.println("start to insert");
        c.sqlInsert();

        System.out.println("start to update");
        c.sqlUpdate();

        System.out.println("start to delete");
        c.sqlDelete();

        System.out.println("after operation: ");
        c.sqlSelect();
    }
}
