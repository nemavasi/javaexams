package javaexams.jdbc;

import java.sql.*;

/**
 * Created by dshalygin on 2/7/19.
 */
public class ConnPostgres {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/testing_db","nemavasi", "0");

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select 42");
        rs.next();
        int v = rs.getInt(1);
        System.out.println(v);

        connection.close();

    }
}
