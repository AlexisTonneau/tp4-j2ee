package com.blaistonneau.tp4bonus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    private Connection connection;

    public Queries() {
        try {
            Class.forName( "oracle.jdbc.OracleDriver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@localhost:48161:xe";
        String user = "system";
        String pass = "oracle";
        try {
            this.connection = DriverManager.getConnection( url, user, pass );

            Statement statement = connection.createStatement();
            statement.
                    executeQuery( "ALTER SESSION SET CURRENT_SCHEMA=marie " );


        } catch ( SQLException e ) {
            e.printStackTrace();
        }

    }

    public List<List<Object>> displayTable(String tableName) throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet resultat = statement.
                executeQuery( "SELECT * FROM " + tableName );
        ResultSetMetaData rsmd = resultat.getMetaData();

        ArrayList<List<Object>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {

            results.get(0).add(rsmd.getColumnName(i));
        }
        while (resultat.next()) {
            results.add(new ArrayList<>());
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                results.get(results.size() -1).add(resultat.getObject(rsmd.getColumnName(i)));
            }
        }
        return results;
    }

    public List<String> displayDepartment() throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet resultat = statement.
                executeQuery( "SELECT deptno, loc, dname FROM dept" );

        ArrayList<String> results = new ArrayList<>();

        while ( resultat.next() ) {
            int deptno = resultat.getInt( "deptno");
            String dname = resultat.getString( "dname" );
            String loc = resultat.getString("loc");
            results.add("Department " + deptno + " is for "+ dname + " and located in "+ loc);
        }
        resultat.close();
        return results;
    }


}
