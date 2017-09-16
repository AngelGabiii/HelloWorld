/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Angelis
 */
public class Pharma extends Application {
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bound = screen.getVisualBounds();
    
    
     BorderPane borderPane;
     Pane pane;
     FXMLLoader loader = new FXMLLoader();
     
    @Override
    public void start(Stage stage) throws Exception {
       
            stage.setX(bound.getMinX());
            stage.setY(bound.getMinY());
            stage.setWidth(bound.getWidth());
            stage.setHeight(bound.getHeight());
            
            loader.setLocation(getClass().getResource("Login.fxml"));
            pane = loader.load();
            Scene scene = new Scene(pane);
         
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(" Welcome | Login ");
            stage.setScene(scene);
       
            stage.show();
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
