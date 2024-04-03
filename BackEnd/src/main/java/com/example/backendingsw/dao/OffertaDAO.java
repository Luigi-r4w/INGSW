package com.example.backendingsw.dao;

import com.example.backendingsw.dto.Offerta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OffertaDAO {

    public ResultSet InserisciOfferta(Offerta offerta) throws Exception {
        Connection con = null;
        String sql = "Insert into offerta VALUES(?,?,?,?)";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setInt(1, offerta.getId());
        p1.setString(2, offerta.getUtente());
        p1.setInt(3, offerta.getOfferta());
        p1.setInt(4,offerta.getOfferta());
        ResultSet rs1 = p1.executeQuery();
        String sql2 = "Update astainglese set ultimaoffera=? where id=? ";
        PreparedStatement p2 = con.prepareStatement(sql);
        p1.setInt(1, offerta.getId());
        p1.setInt(2, offerta.getAsta());
        p1.executeQuery();
        con.close();
        rs1.close();
        return rs1;
    }

    public Offerta MostraOffera(Integer id) throws Exception{
        Connection con = null;
        String sql = "select * from offerta where id = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setInt(1, id);
        ResultSet rs = p1.executeQuery();
        con.close();
        rs.close();
        Offerta offerta = new Offerta(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));
        return offerta;
    }
}
