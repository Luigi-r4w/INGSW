package com.example.backendingsw.dao;

import com.example.backendingsw.dto.AstaInglese;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AstaIngleseDAO {

    public ResultSet InserisciAsta(AstaInglese asta) throws Exception {
        Connection con = null;
        String sql = "Insert into astainglese(nome, descrizione, foto, utente, categoria, offertaminima, intervalloditempo, sogliadirialzo) VALUES(?,?,?,?,?,?,?,?)";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, asta.getNome());
        p1.setString(2, asta.getDescrizione());
        p1.setString(3, asta.getFoto());
        p1.setString(4, asta.getUtente());
        p1.setString(5, asta.getCategoria());
        p1.setInt(6, asta.getOffertaMinima());
        p1.setInt(7, asta.getIntervalloDiTempo());
        p1.setInt(8, asta.getSogliaDiRialzo());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ArrayList<AstaInglese> listaAste() throws Exception{
        Connection con = null;
        String sql = "select * from astainglese";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        ResultSet rs = p1.executeQuery();
        con.close();
        rs.close();
        ArrayList<AstaInglese> aste = new ArrayList<>();
        while (rs.next()){
            aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
        }
        return aste;
    }

    public ArrayList<AstaInglese> listaAsteRicercaAvanzata(String categria, String parola) throws Exception{
        Connection con = null;
        con = dbConnection.getConnection();
        ArrayList<AstaInglese> aste = new ArrayList<>();
        if(parola==null ){
            String sql = "select * from astainglese where categoria = ?";
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, categria);
            ResultSet rs = p1.executeQuery();
            con.close();
            rs.close();
            while (rs.next()){
                aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
        } else if (categria==null) {
            String sql = "select * from astainglese where nome like ?";
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, categria);
            ResultSet rs = p1.executeQuery();
            con.close();
            rs.close();
            while (rs.next()){
                aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
        } else {
            String sql = "select * from astainglese where categoria = ? and nome like ?";
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setString(1, categria);
            p1.setString(2,parola);
            ResultSet rs = p1.executeQuery();
            con.close();
            rs.close();
            while (rs.next()){
                aste.add(new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
        }
        return aste;
    }

    public AstaInglese MostraAsta(Integer id) throws Exception{
        Connection con = null;
        String sql = "select * from astainglese where id = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setInt(1, id);
        ResultSet rs = p1.executeQuery();
        con.close();
        rs.close();
        AstaInglese asta = new AstaInglese(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
        return asta;
    }
}
