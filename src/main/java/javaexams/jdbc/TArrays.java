package javaexams.jdbc;

import java.sql.*;

public class TArrays {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("org.postgresql.Driver"); // not need in jdbc 4
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/testing_db","nemavasi", "0");

        String[] usa = {"New York", "Chicago", "San Francisco"};
        Array arrayUSA = connection.createArrayOf("text", usa); //Convert String[] to java.sql.Array using JDBC API


        PreparedStatement stmt = connection.prepareStatement("insert into country_city(country, cities) values(?,?)");
        stmt.setString(1, "USA");
        stmt.setArray(2, arrayUSA);
        stmt.execute();

        connection.close();

//        CREATE TABLE public.country_city
//                (
//                        country text,
//                        cities text[]
//                 )

    }
}

