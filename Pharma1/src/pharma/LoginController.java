/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelis
 */
public class LoginController  implements Initializable {
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bound = screen.getVisualBounds();

    @FXML public TextField userNameTx;
    @FXML private Label loginNotifier;
    @FXML private PasswordField passwordFieldTx;
    @FXML private Button loginBtn;
    public String loggedInPerson;
    @FXML private Button  closeProgramme;
  
    Connection conn;
    PreparedStatement pst;
    ResultSet  rs;
    

    /**
     * Initializes the controller class.
     */
    
    
       
    // Admin login credentials
    public void adminPriviledge(){
        String user1 = "root";
        String password1 = "rt";
        String user2 = "Hello";
        String password2 = "WhatHaveYouDone";

        if(userNameTx.getText().equals(user1)&& passwordFieldTx.getText().equals(password1) || 
                userNameTx.getText().equals(user2)&& passwordFieldTx.getText().equals(password2)){
            loggedInPerson = userNameTx.getText();
        
                try{
                    Stage stage = new Stage();
                    toHome(stage);
                }catch(Exception ex){System.err.println(ex);}
                    
        }else{
            loginNotifier.setText("Invalid login Credentials");
            userNameTx.clear(); passwordFieldTx.clear();
            try {
                notification0();
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // notifies of you for 10second of invalide credentials when the wrong password is type 
    public void notification0() {
        Task task = new Task(){
            @Override
            protected Object call() throws Exception {
                updateMessage("Invalid Login Credentials");
                Thread.sleep(10000);
                updateMessage(" ");
                 return this;
            }
        }; loginNotifier.textProperty().bind(task.messageProperty());
        task.setOnSucceeded((evt)->{loginNotifier.textProperty().unbind();});
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
    }
    
    //Not working
//    public void displayUserOnScreen() throws Exception{
//        Task task = new Task(){
//        
//           String thePerson = userNameTx.getText();
//            @Override
//            protected Object call() throws Exception {
//         
//            updateMessage(thePerson);
//                return this;
//            }
//        };
//    userLabel.textProperty().bind(task.messageProperty());
//    task.setOnSucceeded((evt)->{userLabel.textProperty().unbind();});
//    Thread t = new Thread(task);
//    t.setDaemon(true);
//    t.start();
//    }
    
     
    public void writeToCreatedFile(String dFile){
    
    }
    
    
    public void toHome(Stage stage) throws Exception{
          loginBtn.getScene().getWindow().hide();
            
            stage.setX(bound.getMinX());
            stage.setY(bound.getMinY());
            stage.setWidth(bound.getWidth());
            stage.setHeight(bound.getHeight());
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Home.fxml"));
            BorderPane borderPane = loader.load();
            HomeController homeController = loader.getController();
            homeController.setName(userNameTx.getText());
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.show();
    }
    
    
    
  
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loginBtn.setOnAction((evt)->{adminPriviledge(); });
        
        // enables login in with the hit of the enter button
        passwordFieldTx.setOnKeyPressed((evt)->{
         if (evt.getCode().equals(KeyCode.ENTER)){adminPriviledge();}
        });

         loggedInPerson = userNameTx.getText();
        System.out.println(loggedInPerson);
        
        closeProgramme.setOnAction((evt)->{System.exit(0);});
        
        
        try {
            TheConnection.establishConnection();
          } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
           
            
        
        



        
        
        
        
    }    
    
}
