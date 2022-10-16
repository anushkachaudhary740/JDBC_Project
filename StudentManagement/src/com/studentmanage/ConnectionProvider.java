package com.studentmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
   static Connection con;
    public static Connection createConnection(){
        try {
            //load the Driver
            Class.forName("com.mysql.jdbc.Driver");
            //create the connection
            String user = "root";
            String password = "Password123#@!";
            String url = "jdbc:mysql://localhost:3306/student_manage";
            con = DriverManager.getConnection(url, user, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;

    }
}
