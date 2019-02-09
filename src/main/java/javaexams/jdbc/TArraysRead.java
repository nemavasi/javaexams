package javaexams.jdbc;

import java.sql.*;
import java.util.Arrays;

public class TArraysRead {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("org.postgresql.Driver"); // not need in jdbc 4
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/testing_db","nemavasi", "0");


        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select country, cities from country_city");
        rs.next();
        String country = rs.getString(1 );
        String[] cities = (String[]) rs.getArray(2).getArray();

        System.out.println(country);
        System.out.println(Arrays.toString(cities));

        connection.close();

//        CREATE TABLE public.country_city
//                (
//                        country text,
//                        cities text[]
//                 )

    }
}

