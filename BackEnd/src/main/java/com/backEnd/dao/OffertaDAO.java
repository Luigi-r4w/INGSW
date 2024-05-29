package com.backEnd.dao;

import com.backEnd.dto.Offerta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OffertaDAO {

    public Boolean InserisciOfferta(Offerta offerta) {
        
        try{
            Connection con = null;
            String sql = "Insert into offerta VALUES(?,?,?,?)";
            con = dbConnection.getConnection();
            PreparedStatement p1 = con.prepareStatement(sql);
            p1.setInt(1, offerta.getId());
            p1.setString(2, offerta.getUtente());
            p1.setInt(3, offerta.getAsta());
            p1.setInt(4,offerta.getOfferta());
            p1.executeQuery();
            sql = "Update astainglese set ultimaofferta=? where id=? ";
            p1 = con.prepareStatement(sql);
            p1.setInt(2, offerta.getId());
            p1.setInt(1, offerta.getAsta());
            p1.executeQuery();
            con.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Offerta MostraOffera(Integer id) throws Exception{
        Connection con = null;
        String sql = "select * from offerta where id = ?";
        con = dbConnection.getConnection();
        PreparedStatement p1 = con.prepareStatement(sql);
        p1.setInt(1, id);
        ResultSet rs = p1.executeQuery();
        rs.next();
        Offerta  offerta = new Offerta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        con.close();
        rs.close();
        return offerta;
    }
}
