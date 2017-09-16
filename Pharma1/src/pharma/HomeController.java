/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Angelis
 */
public class HomeController  extends LoginController implements Initializable {
    
    @FXML private Pane container;
    @FXML private MenuItem close;
    @FXML public Label userLabel;
    @FXML public TextField infoTx;
    @FXML private Label dateTimeLb;
    @FXML private Button stockBtn;
    @FXML private Button salesBtn;
    @FXML private Button clientBtn;
    @FXML private Button companyBtn;
    @FXML private Button manageUsersBtn;
    @FXML private Button reportBtn;
    
    
    
    @FXML private Pane paneItems;
   
    public void setName(String text){
        userLabel.setText(text);
    }
    
    public Label getLabel(String text ){
        userLabel.textProperty().get();
        return userLabel;
    }
    
            // to create a file. but i didn't use it
    public void createParsedFile(String dFilePath){
        Formatter creator;
        try {
            creator = new Formatter(dFilePath);
            creator.flush();
            creator.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
            // To open the that was created
     public void openParsedFile(String dFilePath){
        try {
            
            Scanner reader = new Scanner(new File(dFilePath));
           while(reader.hasNext()){
               String msg = reader.next();
               System.out.printf("%s ", msg);
              
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    System.err.println(ex);
                }
               
               userLabel.setText(msg);
           }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } 
    }
    
                // Display date and time
     public void displayDateTime(){
         Task task = new Task(){
             @Override
             protected Object call() throws Exception {
                 while(true){
                     Date theDate = new Date();
                     updateMessage(theDate.toString());
                 }
             }
         };
     dateTimeLb.textProperty().bind(task.messageProperty());
     task.setOnSucceeded((e)->{dateTimeLb.textProperty().unbind();});
     Thread t = new Thread(task);
     t.setDaemon(true);
     t.start();
     }
    
                // To get all the controlls and Navigation methods
     public void toHome(ActionEvent event) throws Exception{
         container.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Home.fxml"));
         paneItems = loader.load();
         container.getChildren().addAll(paneItems);
     }
     
     public void toStock()throws Exception{
         container.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Stock.fxml"));
         paneItems = loader.load();
         container.getChildren().addAll(paneItems);
     }
     
     public void toSales()throws Exception{
     
         container.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Sales.fxml"));
         paneItems = loader.load();
         container.getChildren().addAll(paneItems);
     }
    
     public void toCompany()throws Exception{
         container.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(HomeController.class.getResource("Company.fxml"));
         paneItems = loader.load();
         container.getChildren().addAll(paneItems);
     }
    
     public void toClient()throws Exception{
     
         container.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Client.fxml"));
         paneItems = loader.load();
         container.getChildren().addAll(paneItems);
     }
    
    public void toReport()throws Exception{
        container.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Report.fxml"));
        paneItems = loader.load();
        container.getChildren().addAll(paneItems);
    }
    
    public void toUser()throws Exception{
    
        container.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("User.fxml"));
        paneItems = loader.load();
        container.getChildren().addAll(paneItems);
    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // To close the programme
        close.setOnAction((evt)->{System.exit(0);});
        
                    //Displays date and Time
        displayDateTime();
        
       stockBtn.setOnAction((evt)->{try {
           toStock();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });

       clientBtn.setOnAction((evt)->{try {
           toClient();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
       
       companyBtn.setOnAction((evt)->{try {
           toCompany();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
       
       salesBtn.setOnAction((evt)->{try {
           toSales();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
       
       manageUsersBtn.setOnAction((evt)->{try {
           toUser();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
       
       reportBtn.setOnAction((evt)->{try {
           toReport();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }     
}
