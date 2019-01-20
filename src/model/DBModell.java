/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monika.lohr
 */
public class DBModell implements IModell  {
    
    private  Connection conn;
    private PreparedStatement getSzemelyekstmt;
    private PreparedStatement addSzemelystmt;
    private PreparedStatement getSzemelystmt;
    private PreparedStatement updateSzemelystmt;
    private PreparedStatement removeSzemelystmt;
    
    private PreparedStatement addRendelesStmt;
    private PreparedStatement updateRendelesStmt;
    private PreparedStatement removeRendelesStmt;
    private PreparedStatement getRendelesekStmt;
    private PreparedStatement getRendelesekbyRendeloStmt;

    public DBModell(Connection conn) throws SQLException {
        this.conn = conn;
       getSzemelyekstmt  = conn.prepareStatement("SELECT*FROM szemely ORDER BY nev");
       addSzemelystmt  = conn.prepareStatement("INSERT INTO szemely (nev, email)VALUES(?,?)");
       getSzemelystmt  = conn.prepareStatement("SELECT*FROM szemely WHERE nev=?");
       updateSzemelystmt  = conn.prepareStatement("UPDATE szemely SET nev=?, email=? WHERE id=?");
       removeSzemelystmt  = conn.prepareStatement("DELETE FROM szemely WHERE id=?");
       
       addRendelesStmt  = conn.prepareStatement("INSERT INTO rendeles (rendeloID,osszeg, darabszam, teljesitve,)VALUES(?,?,?,?)");
       updateRendelesStmt  = conn.prepareStatement("UPDATE rendeles SET rendeloID=?, osszeg=?, darabszam=?, teljesitve=? Where id=?");
       removeRendelesStmt = conn.prepareStatement("DELETE from rendeles Where  id=?");
       getRendelesekStmt  = conn.prepareStatement("SELECT*FROM rendeles");
       getRendelesekbyRendeloStmt  = conn.prepareStatement("SELECT*FROM rendeles Where rendeloID=?");
    }
    
    

    @Override
    public void addSzemely(Szemely szemely) throws SQLException {
        addSzemelystmt.setString(1,szemely.getNev() );
        addSzemelystmt.setString(2,szemely.getEmail());
        addSzemelystmt.executeUpdate();
    }

    @Override
    public void updateSzemely(Szemely szemely) throws SQLException {
        updateSzemelystmt.setString(1, szemely.getNev());
        updateSzemelystmt.setString(2, szemely.getEmail());
        updateSzemelystmt.setInt(3, szemely.getId());
        
         updateSzemelystmt.executeUpdate();
       
       
    }

    @Override
    public void removeSzemely(Szemely szemely) throws SQLException {
        removeSzemelystmt.setInt(1, szemely.getId());
       
        
         removeSzemelystmt.executeUpdate();    }

    @Override
    public List<Szemely> getSzemelyek() throws SQLException {
        List<Szemely> szemelyek = new ArrayList<>();

        ResultSet rs= getSzemelyekstmt.executeQuery();
        while(rs.next()){
            Szemely sz = new Szemely(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("email")) ; 
            
            szemelyek.add(sz);
           
        }
        rs.close(); 
        return szemelyek; 
    }
    
        @Override
    public Szemely getSzemely(String nev) throws SQLException {
        
        getSzemelystmt.setString(1, nev);
        ResultSet rs= getSzemelyekstmt.executeQuery();
        Szemely sz = null;
        while(rs.next()){
             sz = new Szemely(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("email")) ; 
           
           
        }
        rs.close(); 
        return sz; 
    }

    @Override
    public void addRendeles(Rendeles rendeles) throws SQLException {
        
        addRendelesStmt.setInt(1, rendeles.getRendeloId());
        addRendelesStmt.setInt(2, rendeles.getOsszeg());
        addRendelesStmt.setInt(3, rendeles.getDarabszam());
        addRendelesStmt.setBoolean(4, rendeles.isTeljesitve());
        
        addRendelesStmt.executeUpdate();
        
    }

    @Override
    public void updateRendeles(Rendeles rendeles) throws SQLException {
        
        updateRendelesStmt.setInt(1, rendeles.getRendeloId());
        updateRendelesStmt.setInt(2, rendeles.getOsszeg());
        updateRendelesStmt.setInt(3, rendeles.getDarabszam());
        updateRendelesStmt.setBoolean(4, rendeles.isTeljesitve());
        updateRendelesStmt.setInt(5, rendeles.getId());
        updateRendelesStmt.executeUpdate();
        
    }

    @Override
    public void removeRendeles(Rendeles rendeles) throws SQLException {
removeRendelesStmt.setInt(1, rendeles.getId());
removeRendelesStmt.executeUpdate();

    }

    @Override
    public List<Rendeles> getRendelesek() throws SQLException {
        
         List<Rendeles> rendelesek = new ArrayList<>();

        ResultSet rs= getRendelesekStmt.executeQuery();
        while(rs.next()){
            Rendeles r = new Rendeles(
                    rs.getInt("id"),
                    rs.getInt("rendeloId"),
                    rs.getInt("darabszam"),
                    rs.getInt("osszeg"),
                    rs.getBoolean("teljesitve"));
                    
            
            rendelesek.add(r);
           
        }
        rs.close(); 
        return rendelesek; 
    
    }

    @Override
    public void exportCSVbe(File mentesiFile) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Rendeles> getRendelesek(Szemely szemely) throws SQLException {
        
         List<Rendeles> rendelesek = new ArrayList<>();
         getRendelesekbyRendeloStmt.setInt(1, szemely.getId());

        ResultSet rs= getRendelesekbyRendeloStmt.executeQuery();
        while(rs.next()){
            Rendeles r = new Rendeles(
                    rs.getInt("id"),
                    rs.getInt("rendeloId"),
                    rs.getInt("darabszam"),
                    rs.getInt("osszeg"),
                    rs.getBoolean("teljesitve"));
                    
            
            rendelesek.add(r);
           
        }
        rs.close(); 
        return rendelesek; 
    
    }
     
} 
