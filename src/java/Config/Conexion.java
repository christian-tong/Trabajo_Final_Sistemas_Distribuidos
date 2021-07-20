/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.*;

/**
 *
 * @author Kri5ho
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes_trabajo_final_sd", "root", "root");
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }

    /*
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("SELECT * FROM estudiantes");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("dni") + " " + rs.getString("nombres") + " " + rs.getString("facultad") + " " + rs.getString("escuela") + " " + rs.getString("ciclo") + " " + rs.getString("curso") + " " + rs.getString("nota") + " " + rs.getString("pago"));
            }
            cn.con.close();
        } catch (Exception e) {
        }

    }
     */
}
