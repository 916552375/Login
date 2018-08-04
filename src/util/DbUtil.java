package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static  String dbUrl = "jdbc:mysql://192.168.1.152:3306/db_jsp?useSSL=true";
    private static  String userName="root";
    private static String password = "123456";
    private static String jdbcDriver="com.mysql.jdbc.Driver";
    private static Connection connetion = null;
    public static Connection getConnection(){
        try{

        Class.forName(jdbcDriver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("驱动加载失败！");
        }
        try{

        connetion = DriverManager.getConnection(dbUrl,userName,password);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
        System.out.println("数据库连接成功！");
        return connetion;
    }
    public static void closeConnection(Connection connection){
        if(null !=connection){

            try {
                connection.close();
                System.out.println("数据库断开连接成功！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("数据库并未连接，所以不必执行断开操作！");
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        connection =DbUtil.getConnection();
        DbUtil.closeConnection(connection);

    }
}