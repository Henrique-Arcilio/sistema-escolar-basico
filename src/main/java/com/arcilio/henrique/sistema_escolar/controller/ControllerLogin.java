package com.arcilio.henrique.sistema_escolar.controller;

import com.arcilio.henrique.sistema_escolar.dao.DaoDocentes;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Diretor;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Professor;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ControllerLogin {
    Stage janelaAtual;
    @FXML
    TextField campoMatricula;
    @FXML
    PasswordField campoSenha;

    public void efetuarLogin(ActionEvent event) {
        BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
        String matricula = campoMatricula.getText();
        String senhaDigitada = campoSenha.getText();
        Usuario usuario = DaoDocentes.buscar(matricula, "docentes");
        if (BCrypt.checkpw(senhaDigitada, usuario.getSenha())) {

            janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (usuario instanceof Diretor) {
                mudarTela("/TelaDoDiretor.fxml", "Área do Diretor");
            } else if (usuario instanceof Professor) {
                mudarTela("/TelaDoProfessor.fxml", "Área do Professor");
            } else {
                mudarTela("/TelaDoAluno.fxml", "Área do Aluno");
            }
        }
    }

    public void cancelar(javafx.event.ActionEvent event){
        janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janelaAtual.close();
    }

    public void mudarTela(String diretórioDoFxml,String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(diretórioDoFxml));
            Scene cena = new Scene(root);
            janelaAtual.setResizable(false);
            janelaAtual.setTitle(titulo);
            janelaAtual.setScene(cena);
            janelaAtual.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
