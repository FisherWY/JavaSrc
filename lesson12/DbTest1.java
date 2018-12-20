package lesson12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Author Fisher
 * @Date 2018/12/14 21:34
 **/
public class DbTest1 {
    public static void main(String args[]){
        Connection connection = new DbTool().getConnection();
        Statement sql;
        ResultSet res;
        Scanner scanner = new Scanner(System.in);
        int balance = 0;
        int amount = 0;
        String from = "bb";
        String to = "null";

        try {
            sql = connection.createStatement();
            res = sql.executeQuery("select * from bank");

            System.out.println("银行的账号信息:");
            while (res.next()) {
                System.out.println(res.getString("Account") + " " + res.getString("Balance"));
                if (res.getString("Account").equals("bb")) {
                    balance = res.getInt("Balance");
                }
            }

            System.out.println("现在登陆的用户为bb，余额为：" + balance);
            System.out.println("请输入要转账的账户:");
            to = scanner.nextLine();
            System.out.println("请输入转账金额:");
            amount = scanner.nextInt();
            if (amount > balance) {
                System.out.println("余额不足");
            } else {
                sql = connection.prepareStatement("UPDATE bank SET Balance = ? WHERE Account = ?");
                ((PreparedStatement) sql).setInt(1,balance-amount);
                ((PreparedStatement) sql).setString(2,from);
                ((PreparedStatement) sql).executeUpdate();
                res = sql.executeQuery("SELECT Balance FROM bank WHERE Account = '" + to + "'");
                res.next();
                int aa = res.getInt("Balance");
                sql = connection.prepareStatement("UPDATE bank SET Balance = ? WHERE Account = ?");
                ((PreparedStatement) sql).setInt(1,aa + amount);
                ((PreparedStatement) sql).setString(2,to);
                ((PreparedStatement) sql).executeUpdate();
                System.out.println("转账成功");
            }


            res = sql.executeQuery("select * from bank");
            System.out.println("转账之后的余额：");
            while (res.next()) {
                System.out.println(res.getString("Account") + " " + res.getString("Balance"));
                if (res.getString("Account") == "bb") {
                    balance = res.getInt("Balance");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
