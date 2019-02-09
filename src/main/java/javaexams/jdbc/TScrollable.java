package javaexams.jdbc;

import java.sql.*;
import java.util.Arrays;

public class TScrollable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("org.postgresql.Driver"); // not need in jdbc 4
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/testing_db","nemavasi", "0");


        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select country, cities from country_city");

        rs.next();
        if ("USA".equals(rs.getString(1))) {
            rs.updateString(1, "Canada");
        } else {
            rs.updateString(1, "USA");
        }
        rs.updateRow();

        connection.close();

//        CREATE TABLE public.country_city
//                (
//                        country text NOT NULL,
//                        cities text[],
//        CONSTRAINT pk PRIMARY KEY (country)
//         )

    }
}

