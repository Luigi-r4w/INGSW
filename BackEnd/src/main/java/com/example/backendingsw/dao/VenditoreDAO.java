package com.example.backendingsw.dao;

import com.example.backendingsw.dto.Venditore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VenditoreDAO {

    public ResultSet InserisciUtente(Venditore utente) throws Exception {
        Connection con = null;
        String sql = "Insert into venditore(nome, email, password) VALUES(?,?,?,)";
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

    public ResultSet AggiungiLink(Venditore utente) throws Exception {
        Connection con = null;
        String sql = "Update venditore set link=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getNome());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ResultSet AggiungiBio(Venditore utente) throws Exception {
        Connection con = null;
        String sql = "Update venditore set link=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getDescrizione());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ResultSet AggiungiPosizione(Venditore utente) throws Exception {
        Connection con = null;
        String sql = "Update venditore set posizione=? where email=? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, utente.getPosizione());
        p1.setString(2, utente.getEmail());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public Venditore AutentificazioneVenditore(String email, String pass) throws Exception {
        Connection con = null;
        String sql = "select * from venditore where email = ? AND password = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email.trim());
        p1.setString(2, pass.trim());
        ResultSet rs = p1.executeQuery();
        rs.beforeFirst();
        con.close();
        Venditore venditore = null;
        while (rs.next()){
            venditore = new Venditore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return venditore;
    }

    public Venditore InfoVenditore(String email) throws Exception {
        Connection con = null;
        String sql = "select * from venditore where email = ? ";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email.trim());
        ResultSet rs = p1.executeQuery();
        rs.beforeFirst();
        con.close();
        Venditore venditore = null;
        while (rs.next()){
            venditore = new Venditore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return venditore;
    }

}
