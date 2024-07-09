package com.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.backend.dto.AstaInglese;

public class AstaIngleseDAO {

    String update = "SELECT update_scaduta()";

    public ResultSet inserisciAsta(AstaInglese asta) {
        try {
            Connection con = null;
            String sql = "Insert into astainglese(nome, descrizione, foto, utente, categoria, offertaminima, intervalloditempo, sogliadirialzo) VALUES(?,?,?,?,?,?,?,?)";
            con = dbConnection.getConnection();
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, asta.getNome());
                p1.setString(2, asta.getDescrizione());
                p1.setString(3, asta.getFoto());
                p1.setString(4, asta.getUtente());
                p1.setString(5, asta.getCategoria());
                p1.setInt(6, asta.getOffertaMinima());
                p1.setInt(7, asta.getIntervalloDiTempo());
                p1.setInt(8, asta.getSogliaDiRialzo());
                p1.executeUpdate();
            }
            con.close();
            return null;

        }
        catch (Exception e){
            return null;
        }
    }

    public ArrayList<AstaInglese> listaAste() {
        try {
            Connection con = null;
            con = dbConnection.getConnection();
            try (PreparedStatement p = con.prepareStatement(update)) {
                p.execute();
            }
            String sql = "select * from astainglese where scaduta=0";
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                ResultSet rs = p1.executeQuery();
                ArrayList<AstaInglese> aste = new ArrayList<>();
                while (rs.next()){
                    aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
                }
                con.close();
                rs.close();
                return aste;
            }
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public ArrayList<AstaInglese> listaAsteUtente(String email) {
        try{
            Connection con = null;
            String sql = "select * from astainglese where utente = ?";
            con = dbConnection.getConnection();
            try (PreparedStatement p = con.prepareStatement(update)) {
                p.execute();
            }
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1,email);
                ResultSet rs = p1.executeQuery();
                ArrayList<AstaInglese> aste = new ArrayList<>();
                while (rs.next()){
                    aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
                }
                con.close();
                rs.close();
                return aste;
            }
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public ArrayList<AstaInglese> listaAsteRicercaAvanzata(String categria, String parola) {
        try{
        if (categria.equals("null") && parola.equals("null")){
            return listaAste();
        }
        Connection con = null;
        con = dbConnection.getConnection();
        try (PreparedStatement p = con.prepareStatement(update)) {
            p.execute();
        }
        ArrayList<AstaInglese> aste = new ArrayList<>();
        if(parola.equals("null") ){
            String sql = "select * from astainglese where categoria = ? and scaduta=0";
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, categria);
                ResultSet rs = p1.executeQuery();

                while (rs.next()){
                    aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
                }
            }
        } else if (categria.equals("null")) {
            parola="%"+parola+"%";
            String sql = "select * from astainglese where nome like ? scaduta=0";
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, parola);
                ResultSet rs = p1.executeQuery();
                while (rs.next()){
                    aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
                }
            }
        } else {
            parola="%"+parola+"%";
            String sql = "select * from astainglese where categoria = ? and nome like ? scaduta=0";
            try (PreparedStatement p1 = con.prepareStatement(sql)) {
                p1.setString(1, categria);
                p1.setString(2,parola);
                ResultSet rs = p1.executeQuery();

                while (rs.next()){
                    aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
                }
            }
        }
        con.close();
        return aste;
    }
    catch (Exception e){
        return new ArrayList<>();
    }
    }

    public AstaInglese mostraAsta(Integer id) {
        try{
            Connection con = null;
        String sql = "select * from astainglese where id = ?";
        con = dbConnection.getConnection();
        try (PreparedStatement p1 = con.prepareStatement(sql)) {
            p1.setInt(1, id);
            ResultSet rs = p1.executeQuery();
            rs.next();
            AstaInglese asta = new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
            con.close();
            rs.close();
            return asta;
        }
    }
    catch (Exception e){
        return null;
    }
    }
}
