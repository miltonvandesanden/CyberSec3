/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybersec3_bufferoverflow;

import java.nio.BufferOverflowException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;

/**
 *
 * @author milton
 */
public class CyberSec3_BufferOverflow extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        TextField textField = new TextField();
        textField.setMaxWidth(200);
                
        Button btn = new Button();
        btn.setText("go!");
        btn.setTranslateY(40);
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String output = logic(textField.getText());
                textField.setText(output);
            }
        });
                
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(textField);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public String logic(String input)
    {
        if (input.length() > 9.001)
        {
            throw new BufferOverflowException();
        }
        
        return "IT'S OVER 9000!!!";
    }
}
