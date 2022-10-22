/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package utspbol_2020110077;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author keryn
 */
public class FXMLDocumentController implements Initializable {
 public static DBCust dtcust = new DBCust();
 public static DBBarang dtbarang = new DBBarang();
    @FXML
    private MenuItem displaybarang;
    @FXML
    private MenuItem inputbarang;
    @FXML
    private MenuItem Inputcust;
    @FXML
    private MenuItem displaycust;
    
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void displaybarangklik(ActionEvent event) {
      try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDataBarang.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   e.printStackTrace();   }    
    }
    @FXML
    private void displaycustklik(ActionEvent event) {
            try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDataCust.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void inputbarangklik(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputBarang.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   
            e.printStackTrace();   
        }

    }

    @FXML
    private void Inputcustklik(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputCust.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   
            e.printStackTrace();   
        }
    }
         @FXML
    private void keluarklik(ActionEvent event) {
           System.exit(0);
    }
}

    

