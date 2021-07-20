/*
 * To change this license header, choose License Headers in Project Proestties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kri5ho
 */
public class EstudianteDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Estudiante e = new Estudiante();

    @Override
    public List listar() {
        ArrayList<Estudiante> list = new ArrayList<>();
        String sql = "select * from estudiantes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setId(rs.getInt("Id"));
                est.setDni(rs.getString("DNI"));
                est.setNom(rs.getString("Nombres"));
                est.setApe(rs.getString("Apellidos"));
                est.setFac(rs.getString("Facultad"));
                est.setEsc(rs.getString("Escuela"));
                est.setCic(rs.getString("Ciclo"));
                est.setCur(rs.getString("Curso"));
                est.setNot(rs.getString("Nota"));
                est.setPag(rs.getString("Pago"));
                list.add(est);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Estudiante list(int id) {
        String sql = "select * from estudiantes where Id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt("Id"));
                e.setDni(rs.getString("DNI"));
                e.setNom(rs.getString("Nombres"));
                e.setApe(rs.getString("Apellidos"));
                e.setFac(rs.getString("Facultad"));
                e.setEsc(rs.getString("Escuela"));
                e.setCic(rs.getString("Ciclo"));
                e.setCur(rs.getString("Curso"));
                e.setNot(rs.getString("Nota"));
                e.setPag(rs.getString("Pago"));

            }
        } catch (Exception e) {
        }
        return e;
    }

    @Override
    public boolean add(Estudiante est) {
        String sql = "insert into estudiantes(DNI, Nombres, Apellidos, Facultad, Escuela, Ciclo, Curso, nota, Pago)values('" + est.getDni() + "','" + est.getNom() + "','" + est.getApe() +  "','" + est.getFac() + "','" + est.getEsc() +  "','" + est.getCic() + "','" + est.getCur() +  "','" + est.getNot() + "','" + est.getPag() +"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Estudiante est) {
        String sql = "update estudiantes set DNI='" + est.getDni() + "',Nombres='" + est.getNom() + "',Apellidos='" + est.getApe() + "',Facultad='" + est.getFac() + "',Escuela='" + est.getEsc() + "',Ciclo='" + est.getCic() + "',Curso='" + est.getCur() + "',Nota='" + est.getNot() + "',Pago='" + est.getPag() +"'where Id=" + est.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from estudiantes where Id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
