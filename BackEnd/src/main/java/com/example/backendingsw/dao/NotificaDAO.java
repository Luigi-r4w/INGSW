package com.example.backendingsw.dao;

import com.example.backendingsw.dto.Notifica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NotificaDAO {
    public ResultSet InserisciNotifica(Notifica notifica) throws Exception {
        Connection con = null;
        String sql = "Insert into notifiche VALUES(?,?,?,)";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, notifica.getVenditore());
        p1.setString(2, notifica.getCompratore());
        p1.setInt(3, notifica.getAsta());
        ResultSet rs1 = p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public ArrayList<Notifica> VenditoreNotifiche(String email) throws Exception {
        Connection con = null;
        String sql = "select * from notifiche where venditore = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email);
        ResultSet rs = p1.executeQuery();
        con.close();
        rs.close();
        ArrayList<Notifica> notifiche = new ArrayList<>();
        while (rs.next()){
            notifiche.add(new Notifica(rs.getString(1),rs.getString(2),rs.getInt(3)));
        }
        return notifiche;
    }

    public ArrayList<Notifica> CompratoreNotifiche(String email) throws Exception {
        Connection con = null;
        String sql = "select * from notifiche where compratore = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setString(1, email);
        ResultSet rs = p1.executeQuery();
        con.close();
        rs.close();
        ArrayList<Notifica> notifiche = new ArrayList<>();
        while (rs.next()){
            notifiche.add(new Notifica(rs.getString(1),rs.getString(2),rs.getInt(3)));
        }
        return notifiche;
    }
}
