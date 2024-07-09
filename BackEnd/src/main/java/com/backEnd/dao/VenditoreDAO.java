package com.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.dto.Venditore;

public class VenditoreDAO {

    public Boolean inserisciUtente(Venditore utente) {
        
        try {
            Connection con = null;
            String sql = "Insert into venditore(nome, email, password) VALUES(?,?,?)";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, utente.getNome());
                p1.setString(2, utente.getEmail());
                p1.setString(3, utente.getPassword());
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }


    public Boolean inserisciUtente(String nome, String email, String pass) {
        
        try {
            Connection con = null;
            String sql = "Insert into venditore(nome, email, password) VALUES(?,?,?)";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, nome);
                p1.setString(2, email);
                p1.setString(3, pass);
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    public Boolean aggiungiLink(Venditore utente) {
                
        try {
            Connection con = null;
            String sql = "Update venditore set link=? where email=? ";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, utente.getLink());
                p1.setString(2, utente.getEmail());
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    public Boolean aggiungiLink(String utente, String link) {
                
        try {
            if (utente != null && link != null) {
            Connection con = null;
            String sql = "Update venditore set link=? where email=? ";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, link);
                p1.setString(2, utente);
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        else{
            return false;
        }
        }
        catch (SQLException e){
            return false;
        }
    }

    public Boolean aggiungiBio(Venditore utente) {
        try {
            Connection con = null;
            String sql = "Update venditore set bio=? where email=? ";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(2, utente.getEmail());
                p1.setString(1, utente.getDescrizione());
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    public Boolean aggiungiPosizione(Venditore utente)  {
        try {
            Connection con = null;
            String sql = "Update venditore set posizione=? where email=? ";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, utente.getPosizione());
                p1.setString(2, utente.getEmail());
                p1.executeUpdate();
            }
            con.close();
            return true;
        }
        catch (SQLException e){
            return false;
        }
        
        
    }

    public Boolean aggiungiPosizione(String utente, String posizione)  {
        try {
            if (utente != null && posizione != null) {
                Connection con = null;
                String sql = "Update venditore set posizione=? where email=? ";
                con = dbConnection.getConnection();
                try (PreparedStatement p1 = con.prepareStatement(sql)) {
                    p1.setString(1, posizione);
                    p1.setString(2, utente);
                    p1.executeUpdate();
                }
                con.close();
                return true; 
            }
            else {
                return false;
            }
        }
        catch (SQLException e){
            return false;
        }
        
        
    }

    public Boolean autenticazione(String email, String pass)  {
        
        try {
            Connection con = null;
            String sql = "select * from venditore where email = ? AND password = ?";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, email.trim());
                p1.setString(2, pass.trim());
                ResultSet rs = p1.executeQuery();
                con.close();
                if (!rs.next()){
                    return false;
                }
            }
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }

    public Venditore infoVenditore(String email) {
        try{
        Connection con = null;
        String sql = "select * from venditore where email = ? ";
        con = dbConnection.getConnection();
        try (PreparedStatement p1 = con.prepareStatement(sql)) {
            p1.setString(1, email.trim());
            ResultSet rs = p1.executeQuery();
            rs.next();
            Venditore venditore = new Venditore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            con.close();
            return venditore;
        }
    }
    catch (SQLException e){
        return null;
    }
    }


}
