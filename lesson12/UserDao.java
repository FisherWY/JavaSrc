package lesson12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Fisher
 * @Date 2018/12/12 12:43
 **/
public class UserDao{
    private Connection connection;
    private Statement sql;
    private ResultSet res;

    UserDao() {
        connection = new DbTool().getConnection();
        try {
            sql = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加user
    public boolean addUser(User u) {
        boolean status = false;
        try {
            sql = connection.prepareStatement("insert into users values(?,?,?,?,?)");
            ((PreparedStatement) sql).setString(1, u.getId());
            ((PreparedStatement) sql).setString(2, u.getName());
            ((PreparedStatement) sql).setString(3, u.getGender());
            ((PreparedStatement) sql).setString(4, u.getAddress());
            ((PreparedStatement) sql).setString(5, u.getAboutme());
            ((PreparedStatement) sql).executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //删除user
    public boolean deleteUser(User u) {
        boolean status = false;
        try {
            sql = connection.prepareStatement("delete from users where id = ?");
            ((PreparedStatement) sql).setString(1, u.getId());
            ((PreparedStatement) sql).executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //更新user
    public boolean updateUser(User u) {
        boolean status = false;
        try {
            sql = connection.prepareStatement("update users set Name = ?, Gender = ?, Address = ?, Aboutme = ? where ID = ?");
            ((PreparedStatement) sql).setString(1, u.getName());
            ((PreparedStatement) sql).setString(2, u.getGender());
            ((PreparedStatement) sql).setString(3, u.getAddress());
            ((PreparedStatement) sql).setString(4, u.getAboutme());
            ((PreparedStatement) sql).setString(5, u.getId());
            ((PreparedStatement) sql).executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //查询user
    public User getUser(String id) {
        User result = new User();
        try {
            String query = "select * from users where ID = '" + id + "'";
//            sql = connection.prepareStatement("select * from users where id = ?");
//            ((PreparedStatement) sql).setString(1, id);
            res = sql.executeQuery(query);
            res.next();
            result.setId(res.getString("ID"));
            result.setName(res.getString("Name"));
            result.setGender(res.getString("Gender"));
            result.setAddress(res.getString("Address"));
            result.setAboutme(res.getString("Aboutme"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取所有的user
    public List<User> getUsers() {
        List<User> list = new LinkedList<>();
        try {
            res = sql.executeQuery("select * from users");
            while (res.next()) {
                User u = new User();
                u.setId(res.getString("ID"));
                u.setName(res.getString("Name"));
                u.setGender(res.getString("Gender"));
                u.setAddress(res.getString("Address"));
                u.setAboutme(res.getString("Aboutme"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
