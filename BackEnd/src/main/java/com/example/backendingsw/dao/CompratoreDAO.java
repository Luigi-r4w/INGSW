package com.example.backendingsw.dao;

import com.example.backendingsw.dto.Compratore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompratoreDAO {
    public ResultSet InserisciUtente(Compratore utente) throws Exception {
        Connection con = null;
        String sql = "Insert into compratore(nome, email, password) VALUES(?,?,?,)";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getNome());
        p1.setString(2, utente.getEmail());
        p1.setString(3, utente.getPassword());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ResultSet AggiungiLink(Compratore utente) throws Exception {
        Connection con = null;
        String sql = "Update compratore set link=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getNome());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ResultSet AggiungiBio(Compratore utente) throws Exception {
        Connection con = null;
        String sql = "Update compratore set link=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getDescrizione());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ResultSet AggiungiPosizione(Compratore utente) throws Exception {
        Connection con = null;
        String sql = "Update compratore set posizione=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getPosizione());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public Compratore AutentificazioneVenditore(String email, String pass) throws Exception {
        Connection con = null;
        String sql = "select * from compratore where email = ? AND password = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email.trim());
        p1.setString(2, pass.trim());
        ResultSet rs = p1.executeQuery();
        rs.beforeFirst();
        con.close();
        Compratore compratore = null;
        while (rs.next()){
            compratore = new Compratore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return compratore;
    }
}
