package com.arcilio.henrique.sistema_escolar.view;

import com.arcilio.henrique.sistema_escolar.dao.Utilitario;
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
            String fxmlDaJanela = "/TelaLogin.fxml";
            String titulo = "Efetuando login";
            if(Utilitario.contarRegistros("docentes") == 0){
                fxmlDaJanela = "/CadastroUsuario.fxml";
                titulo = "Cadastrando Usuário";
            }
            Parent root = FXMLLoader.load((getClass().getResource(fxmlDaJanela)));
            Scene cena = new Scene(root);
            stage.setResizable(false);
            stage.setTitle(titulo);
            stage.setScene(cena);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
