/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utspbol_2020110077;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author keryn
 */
public class DBBarang {
    private BarangModel dt=new BarangModel();    
    public BarangModel getBarangModel(){ return(dt);}
    public void setBarangModel(BarangModel s){ dt=s;}
    
    public ObservableList<BarangModel>  Load() {
        try {
            ObservableList<BarangModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodebarang, namabarang, hargabeli, hargajual from stok");
            int i = 1;
            while (rs.next()) {
                BarangModel d=new BarangModel();
                d.setKodebarang(rs.getString("kodebarang"));                
                d.setNamabarang(rs.getString("namabarang"));       
                d.setHargabeli(rs.getInt("hargabeli"));    
                d.setHargajual(rs.getInt("hargajual"));  
                d.setStok(rs.getInt("stok"));               
                tableData.add(d);                
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
        }
    }
    
    public int validasi(String nomor) {
        int val = 0;
        try {         
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from barang where kodebarang = '" + nomor + "'");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
    
    public boolean insert() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {       
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into barang (kodebarang,namabarang,hargabeli, hargajual,stok) values (?,?,?)");
            con.preparedStatement.setString(1, getBarangModel().getKodebarang());           
            con.preparedStatement.setString(2, getBarangModel().getNamabarang());  
            con.preparedStatement.setDouble(3, getBarangModel().getHargabeli());
            con.preparedStatement.setDouble(4, getBarangModel().getHargajual());
            con.preparedStatement.setDouble(5, getBarangModel().getStok());        
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        } 
    }
    public boolean delete(String nomor) {
    boolean berhasil = false;        
    Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from barang where kodebarang  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }

    public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update barang set namabarang = ?, stok = ?  where  kodebarang = ? ");
            con.preparedStatement.setString(1, getBarangModel().getKodebarang());           
            con.preparedStatement.setString(2, getBarangModel().getNamabarang());  
            con.preparedStatement.setDouble(3, getBarangModel().getHargabeli());
            con.preparedStatement.setDouble(4, getBarangModel().getHargajual());
            con.preparedStatement.setDouble(5, getBarangModel().getStok());        
            con.preparedStatement.executeUpdate();
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
        }
    
    public ObservableList<BarangModel>  CariBarang(String kode, String nama) {
        try {    
            ObservableList<BarangModel> 	
            tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select kodebrg,namabrg, tarif from barang WHERE kodebrg LIKE '" + kode + "%' OR namabrg LIKE '" + nama + "%'");
        int i = 1;
        while(rs.next()){
            BarangModel d = new BarangModel();
            d.setKodebarang(rs.getString("kodebarang"));                
            d.setNamabarang(rs.getString("namabarang"));       
            d.setHargabeli(rs.getInt("hargabeli"));    
            d.setHargajual(rs.getInt("hargajual"));  
            d.setStok(rs.getInt("stok"));   
                       
            tableData.add(d);
            i++;
        }
        con.tutupKoneksi();
        return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    }      

