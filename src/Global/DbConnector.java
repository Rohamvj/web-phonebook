package Global;

import java.sql.*;

public class DbConnector {

    Statement stmt;

    public DbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook2?useUnicode=true&characterEncoding=utf-8", "root", "");
            stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet querySelect(String query) {

        ResultSet rset = null;

        try {
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rset;

    }

    public void queryUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryInsert(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int queryInsert(String query, boolean withId) {
        int temp = 0;
        try {
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet r = stmt.getGeneratedKeys();
            r.first();
            temp = r.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }


}
