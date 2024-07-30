package com.arcilio.henrique.sistema_escolar.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AppInterface extends Application {

    @FXML
    private TextField campoDeMatricula;
    @FXML
    private TextField campoDeSenha;
    @FXML
    private Button buttonEntrar;


    public static void iniciar(String[] args){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load((getClass().getResource("/TelaLogin.fxml")));
            Scene cena = new Scene(root);
            stage.setResizable(false);
            stage.setTitle("Efetuando Login");
            stage.setScene(cena);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }
}
