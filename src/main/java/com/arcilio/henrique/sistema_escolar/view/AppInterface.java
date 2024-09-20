package com.arcilio.henrique.sistema_escolar.view;

import com.arcilio.henrique.sistema_escolar.controller.ControllerCadastro;
import com.arcilio.henrique.sistema_escolar.dao.Utilitario;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AppInterface extends Application {
    @FXML
    Label cabecalho;

    public static void iniciar(String[] args){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage){
        try {

            String fxmlDaJanela = "/TelaLogin.fxml";
            String titulo = "Efetuando login";

            boolean requerCadastro = Utilitario.contarRegistros("docentes") == 0;
            //Caso o programa esteja abrindo a primeira vez

            if(requerCadastro){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Sistema iniciado a primeira vez. Necessário cadastrar um diretor");
                alerta.setTitle("Sistema sem administrador");
                alerta.setHeaderText(null);
                alerta.showAndWait();
                fxmlDaJanela = "/CadastroUsuario.fxml";
                titulo = "Cadastrando Usuário";
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDaJanela));
            Parent root = loader.load();
            Scene cena = new Scene(root);
            stage.setResizable(false);
            stage.setTitle(titulo);
            stage.setScene(cena);
            //Pegando o controlador e mudando titulo do cabeçalho
            if(requerCadastro){
                ControllerCadastro controlador = loader.getController();
                controlador.getCabecalho().setText("Cadastro do Diretor");
            }
            stage.show();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
