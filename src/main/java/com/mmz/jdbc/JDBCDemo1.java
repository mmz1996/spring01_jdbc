package com.mmz.jdbc;

import java.sql.*;

/**
 * @Classname JDBCDemo1
 * @Description 程序耦合
 * @Date 2020/5/7 18:56
 * @Created by mmz
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false","root","password");
        //3.获取操作数据的预处理对象
        PreparedStatement preparedStatement =connection.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
