package lesson12;

import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author Fisher
 * @Date 2018/12/12 20:50
 **/
public class DbUtil {
//    private Connection connection;
//    private PreparedStatement preparedStatement;
    private String user = "fisher";
    private String psw = "12345678";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2b8";

    private int initalConnections = 10; //连接池初始大小
    private int incrementalConnections = 5; //连接池自动增量
    private int maxConnections = 50; //连接池最大大小
    private Vector connections = null;  //存放连接池中数据库连接的向量

    public int getInitalConnections() {
        return initalConnections;
    }

    public void setInitalConnections(int initalConnections) {
        this.initalConnections = initalConnections;
    }

    public int getIncrementalConnections() {
        return incrementalConnections;
    }

    public void setIncrementalConnections(int incrementalConnections) {
        this.incrementalConnections = incrementalConnections;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public synchronized void createPool() throws Exception {
        if (connections != null) {
            return;
        }
        //实例化JDBC Driver中指定的驱动类实例
        Driver driver = (Driver) (Class.forName(this.driver)).newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        //创建保存连接的向量，初始时有0个元素
        connections = new Vector<>();
        //开始创建连接
        createConnections(this.initalConnections);
    }

    private void createConnections(int incrementalConnections) throws SQLException {
        for (int i=0; i<incrementalConnections; i++) {
            //连接池数量是否达到了最大，或者maxConnections<0
            if (this.maxConnections <= 0 && this.connections.size() >= this.maxConnections) {
                break;
            }
            try {
                connections.addElement(new PooledConnection(newConnection()));
            } catch (SQLException e) {
                System.out.println("创建数据库连接失败");
                e.printStackTrace();
                throw new SQLException();
            }
        }
    }

    private Connection newConnection() throws SQLException {
        //创建一个数据库连接
        Connection connection = DriverManager.getConnection(url, user, psw);
        if (connections.size() == 0) {
            DatabaseMetaData metaData = connection.getMetaData();
            int driverMaxConnections = metaData.getMaxConnections();
            // 数据库返回的 driverMaxConnections 若为 0 ，表示此数据库没有最大
            // 连接限制，或数据库的最大连接限制不知道
            // driverMaxConnections 为返回的一个整数，表示此数据库允许客户连接的数目
            // 如果连接池中设置的最大连接数量大于数据库允许的连接数目 , 则置连接池的最大
            // 连接数目为数据库允许的最大数目
            if (driverMaxConnections > 0 && this.maxConnections > driverMaxConnections) {
                this.maxConnections = driverMaxConnections;
            }
        }
        return connection;
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connections == null) {
            return null; //连接池没有创建，返回null
        }
        Connection connection = getFreeConnection();
        while (connection == null) {
            wait(250);
            connection = getFreeConnection();
        }
        return connection;
    }

    private Connection getFreeConnection() throws SQLException {
        Connection connection = findFreeConnection();
        if (connection == null) {
            createConnections(incrementalConnections);
            connection = findFreeConnection();
            if (connection == null) {
                return null;
            }
        }
        return connection;
    }

    private Connection findFreeConnection() throws SQLException {
        Connection connection = null;
        PooledConnection pooledConnection = null;

        Enumeration enumeration = connections.elements();
        while (enumeration.hasMoreElements()) {
            pooledConnection = (PooledConnection)enumeration.nextElement();
            if (!pooledConnection.isBusy()) {
                connection = pooledConnection.getConnection();
                pooledConnection.setBusy(true);
                if (!testConnection(connection)) {
                    try {
                        connection = newConnection();
                    } catch (SQLException e) {
                        System.out.println("创建数据库连接失败！" + e.getMessage());
                        return null;
                    }
                    pooledConnection.setConnection(connection);
                }
                break;
            }
        }
        return connection;
    }

    private boolean testConnection(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("select count(*) from test");
        } catch (SQLException e) {
            closeConnection(connection);
            return false;
        }
        return true;
    }

    public void returnConnection(Connection connection) {
        if (connections == null) {
            System.out.println("连接池不存在，无法返回此连接到数据池中");
            return;
        }
        PooledConnection pooledConnection = null;
        Enumeration enumeration = connections.elements();
        while (enumeration.hasMoreElements()) {
            pooledConnection = (PooledConnection)enumeration.nextElement();
            if (connection == pooledConnection.getConnection()) {
                pooledConnection.setBusy(false);
                break;
            }
        }
    }

    public synchronized void refreshConnections() throws SQLException {
        if (connections == null) {
            System.out.println("连接不存在，无法刷新！");
            return;
        }
        ConnectionPool.PooledConnection pooledConnection = null;
        Enumeration enumeration = connections.elements();
        while (enumeration.hasMoreElements()) {
            pooledConnection = (ConnectionPool.PooledConnection)enumeration.nextElement();
            if (pooledConnection.isBusy()) {
                try {
                    wait(5000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            closeConnection(pooledConnection.getConnection());
            pooledConnection.setConnection(newConnection());
            pooledConnection.setBusy(false);
        }
    }

    public synchronized void  closeConnectionPool() throws SQLException {
        if (connections == null) {
            System.out.println("连接池不存在，无法关闭");
            return;
        }
        ConnectionPool.PooledConnection pooledConnection = null;
        Enumeration enumeration = connections.elements();
        while (enumeration.hasMoreElements()) {
            pooledConnection = (ConnectionPool.PooledConnection)enumeration.nextElement();
            if (pooledConnection.isBusy()) {
                try {
                    wait(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            closeConnection(pooledConnection.getConnection());
            connections.removeElement(pooledConnection);
        }
        connections = null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void wait(int mSeconds) {
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class PooledConnection {
        Connection connection = null;
        boolean busy = false;

        // 构造函数，根据一个 Connection 构告一个 PooledConnection 对象
        public PooledConnection(Connection connection) {
            this.connection = connection;
        }

        // 返回此对象中的连接
        public Connection getConnection() {
            return connection;
        }

        // 设置此对象的，连接
        public void setConnection(Connection connection) {
            this.connection = connection;
        }

        // 获得对象连接是否忙
        public boolean isBusy() {
            return busy;
        }

        // 设置对象的连接正在忙
        public void setBusy(boolean busy) {
            this.busy = busy;
        }
    }
}
