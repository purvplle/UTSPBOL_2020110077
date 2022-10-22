/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package utspbol_2020110077;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author keryn
 */
public class FXMLInputBarangController implements Initializable {

    boolean editdata=false;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    @FXML
    private TextField txtkodebarang;
    @FXML
    private TextField txtnamabarang;
    private TextField txttarif;
    @FXML
    private TextField txthargabeli;
    @FXML
    private TextField txthargajual;
    @FXML
    private TextField txtstok;
    @FXML
    private TableView<String> tbvBarang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void execute(BarangModel d){
        if(!d.getKodebarang().isEmpty()){
          editdata=true;
          txtkodebarang.setText(d.getKodebarang());
          txtnamabarang.setText(d.getNamabarang());
          txthargabeli.setText(String.valueOf(d.getHargabeli()));    
          txthargajual.setText(String.valueOf(d.getHargajual()));    
          txtstok.setText(String.valueOf(d.getStok()));    
          txtkodebarang.setEditable(false);
          txtnamabarang.requestFocus();         
        }
    }
    
    @FXML
    private void simpanklik(ActionEvent event) {
        BarangModel n=new BarangModel();        
        n.setKodebarang(txtkodebarang.getText());
        n.setNamabarang(txtnamabarang.getText());     
        n.setHargabeli(Double.parseDouble(txthargabeli.getText()));
        n.setHargajual(Double.parseDouble(txthargajual.getText()));
        n.setStok(Double.parseDouble(txtstok.getText()));
                
        
        FXMLDocumentController.dtbarang.setBarangModel(n);
        if(editdata){
            if(FXMLDocumentController.dtbarang.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   
               txtkodebarang.setEditable(true);        
               batalklik(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
                a.showAndWait(); 
            }
            }else if(FXMLDocumentController.dtbarang.validasi(n.getKodebarang())<=0){
            if(FXMLDocumentController.dtbarang.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            
               batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtkodebarang.requestFocus();
        }
    }

    @FXML
    private void batalklik(ActionEvent event) {
        txtkodebarang.setText("");        
        txtnamabarang.setText("");
        txthargabeli.setText("");       
        txthargajual.setText("");
        txtkodebarang.requestFocus();
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }
    
}
