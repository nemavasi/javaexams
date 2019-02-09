package javaexams.jdbc;

import java.sql.*;

public class TCallable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("org.postgresql.Driver"); // not need in jdbc 4
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/testing_db","nemavasi", "0");

        CallableStatement stmt = connection.prepareCall("{call fn_sqltestout(?,?)}");
        stmt.setInt(1, 7);
        stmt.registerOutParameter(2, Types.VARCHAR);
        stmt.execute();
        System.out.println(stmt.getString(2));

        connection.close();

    }
}


//    CREATE OR REPLACE FUNCTION fn_sqltestout(p_id int,
//                                             OUT p_out text)
//    AS
//            $$
// begin
//         p_out := substring('qwerqtwerqtertfdgsfhnjglsdkfjhgskfn;bvndvczxcv', 1, p_id);
//         end;
//         $$
//         LANGUAGE 'plpgsql' VOLATILE;