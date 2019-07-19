package com.spring.jdbc;

import com.mysql.cj.jdbc.Driver;


import java.sql.*;

import static java.sql.DriverManager.getConnection;
/*
 *程序的耦合：程序的依赖关系
 *
 */

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, SQLException, ClassNotFoundException {
        //1.注册驱动
        // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = getConnection("jdbc:mysql://localhost:3306/account?rewriteBatchedStatements=true&serverTimezone=Asia/Shanghai&characterEncoding=GBK",
                "root","153410");
        //3.获取操作数据库的预处理对象
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs= preparedStatement.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        conn.close();
        preparedStatement.close();

    }
}