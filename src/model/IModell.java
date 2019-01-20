/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author monika.lohr
 */
public interface IModell {
    void addSzemely(Szemely szemely) throws SQLException;
    void updateSzemely(Szemely szemely) throws SQLException;
    void removeSzemely(Szemely szemely) throws SQLException;
    List <Szemely>getSzemelyek() throws SQLException;
    Szemely getSzemely(String nev) throws SQLException;
    void addRendeles (Rendeles rendeles) throws SQLException;
    void updateRendeles (Rendeles rendeles) throws SQLException;
    void removeRendeles (Rendeles rendeles) throws SQLException;
    List <Rendeles> getRendelesek()throws SQLException;
    List <Rendeles> getRendelesek(Szemely szemely)throws SQLException;
    
    void exportCSVbe(File mentesiFile) throws IOException;
    
}
