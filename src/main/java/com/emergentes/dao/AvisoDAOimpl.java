package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionDB implements AvisoDAO {

    @Override
    public void insert(Aviso aviso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into avisos (titulo, contenido) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getContenido());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Aviso aviso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE avisos SET titulo=?, contenido=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getContenido());
            ps.setInt(3, aviso.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM avisos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }

        
    }

    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi = new Aviso();
        try {
            this.conectar();
            String sql = "SELECT * FROM avisos WHERE id=? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setTitulo(rs.getString("tiulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return avi;

    }

    @Override
    public List<Aviso> getAll() throws Exception {
        ArrayList<Aviso> lista = new ArrayList<Aviso>();
        try {

            this.conectar();
            String sql = "SELECT * FROM avisos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aviso avi = new Aviso();

                avi.setId(rs.getInt("id"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));

                lista.add(avi);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;
    }

}
