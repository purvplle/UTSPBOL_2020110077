/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utspbol_2020110077;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author keryn
 */
public class Koneksi {
    public Connection dbKoneksi;
    public Statement statement;
    public PreparedStatement preparedStatement;
    
    public Koneksi() {        
        this.dbKoneksi = null;    
    }
    public void bukaKoneksi() {
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            dbKoneksi = DriverManager.getConnection("jdbc:derby://localhost:1527/db_pbol");
        } catch (Exception e) {
            e.printStackTrace();        
        }    
    }
    public void tutupKoneksi() {
        try { 
            if (statement != null) {    
                statement.close();           
            }
            if (preparedStatement != null) {     
                preparedStatement.close();            
            }
            if (dbKoneksi != null) {            
                dbKoneksi.close();            
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());        
        }    
    }
}
