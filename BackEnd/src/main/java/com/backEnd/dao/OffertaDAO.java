package com.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.backend.dto.Offerta;

public class OffertaDAO {

    public Boolean inserisciOfferta(Offerta offerta) {
        
        try{
            Connection con = null;
            String sql = "Insert into offerta (utente, asta, offerta) VALUES(?,?,?)";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, offerta.getUtente());
                p1.setInt(2, offerta.getAsta());
                p1.setInt(3,offerta.getValoreOfferta());
                p1.executeUpdate();
            }
            sql = "Select id from offerta where utente = ? and asta = ? and offerta = ?";
            try (PreparedStatement p2 = con.prepareStatement(sql)) {
                p2.setString(1, offerta.getUtente());
                p2.setInt(2, offerta.getAsta());
                p2.setInt(3,offerta.getValoreOfferta());
                ResultSet rs = p2.executeQuery();
                rs.next();
                sql = "Update astainglese set ultimaofferta=? where id=? ";
                try (PreparedStatement p3 = con.prepareStatement(sql)) {
                    p3.setInt(2, offerta.getAsta());
                    p3.setInt(1, rs.getInt(1));
                    p3.executeUpdate();
                }
            }
            con.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Offerta mostraOffera(Integer id) {
        try{
            Connection con = null;
        String sql = "select * from offerta where id = ?";
        con = dbConnection.getConnection();
        try (PreparedStatement p1 = con.prepareStatement(sql)) {
            p1.setInt(1, id);
            ResultSet rs = p1.executeQuery();
            rs.next();
            Offerta  offerta = new Offerta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            con.close();
            rs.close();
            return offerta;
        }
    }
    catch(Exception e){
        return null;
    }
    }

    public Integer valoreOfferta(Integer id){
        try{
        Connection con = null;
        String sql = "select offerta from offerta where id = ?";
        con = dbConnection.getConnection();
        try (PreparedStatement p1 = con.prepareStatement(sql)) {
            p1.setInt(1, id);
            ResultSet rs = p1.executeQuery();
            rs.next();
            Integer res = rs.getInt(1);
            con.close();
            rs.close();
            return res;
        }
    }
    catch(Exception e){
        return null;
    }
    }

    public String compratoreOfferta(Integer id){
        try{
        Connection con = null;
        String sql = "select utente from offerta where id = ?";
        con = dbConnection.getConnection();
        try (PreparedStatement p1 = con.prepareStatement(sql)) {
            p1.setInt(1, id);
            ResultSet rs = p1.executeQuery();
            rs.next();
            String res = rs.getString(1);
            con.close();
            rs.close();
            return res;
        }
    }
    catch(Exception e){
        return null;
    }
    }
}
