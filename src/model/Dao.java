package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    // JDBC 인터페이스, import java.sql
    public Connection conn;

    // 싱글톤
    // private static Dao dao = new Dao();
    // 생성자에서 DB 연동 코드 작성
    public Dao() {

        try {
            // 1.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "1234");
            System.out.println("[BoardDB Connection OK]");

        } catch (ClassNotFoundException e) {
            e.getMessage();
            System.out.println("[BoardDB Connection fail]");


        } catch (SQLException e) {
            e.getMessage();
            System.out.println("[BoardDB Connection fail]");
        }

    }

    // public static Dao getInstance() {
        // return dao;
    // }

}
