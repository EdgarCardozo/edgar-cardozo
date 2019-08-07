package com.bootcamp.shopping.connection;

import java.sql.*;

public class MySQLConnection {
    private String url, host, port, db, user, pass;
    private static MySQLConnection mysqlConnection;
    public static MySQLConnection getInstance(String host,String port,String user, String pass){
        if(mysqlConnection==null){
            mysqlConnection= new MySQLConnection(host,port,user,pass);
        }
        return mysqlConnection;
    }   
    private MySQLConnection(String host,String port,String user, String pass){
        this.url = "jdbc:mysql://"+host+":"+port+"/shopping";
        this.user=user;
        this.pass=pass;
    }
    public void Connect(){
        try {
            System.out.println("Connecting to database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/highschool", "root", "1234");
            System.out.println("Connected Successfully!");
            Statement statement = connection.createStatement();
            /*String teacherID = "1167";
            ResultSet resultSet = statement
                    .executeQuery("SELECT t.first_name , t.last_name , c.schedule_time , c.start_time , c.finish_time, c.course_name\n" +
                            "FROM courses AS c INNER JOIN teachers AS t ON c.id_teacher=t.id_teacher\n" +
                            "WHERE t.id_teacher=" + teacherID + ";");
            resultSet.next();
            System.out.println("Teacher:" + resultSet.getString("last_name") + "," + resultSet.getString("first_name"));
            System.out.println("Schedule:");
            System.out.println(resultSet.getString("schedule_time") + ": " + resultSet.getTime("start_time") + "hs-" + resultSet.getTime("finish_time") + "hs " + resultSet.getString("course_name"));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("schedule_time") + ": " + resultSet.getTime("start_time") + "hs-" + resultSet.getTime("finish_time") + "hs " + resultSet.getString("course_name"));
            }*/
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}