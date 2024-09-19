package com.arcilio.henrique.sistema_escolar.controller;

import com.arcilio.henrique.sistema_escolar.dao.DaoAlunos;
import com.arcilio.henrique.sistema_escolar.dao.DaoDocentes;
import com.arcilio.henrique.sistema_escolar.model.categorias.Funcao;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Aluno;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Professor;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ControllerCadastro {
    @FXML
    TextField campoNome;
    @FXML
    RadioButton optionDocente, optionDiscente;
    @FXML
    DatePicker nascimento;
    @FXML
    PasswordField campoSenha;
    @FXML
    PasswordField campoConfirmacaoSenha;


    public void cadastrar(ActionEvent event){

        if(!validarSenha()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro de senha");
            alerta.setHeaderText(null);
            alerta.setContentText("As senhas não coincidem! tente novamente");
            alerta.showAndWait();
        }else{
            String nome = campoNome.getText();
            LocalDate dataNascimento = nascimento.getValue();
            BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
            String senha = encriptador.encode(campoSenha.getText());
            String confirmacao = encriptador.encode(campoConfirmacaoSenha.getText());
            Usuario usuario = null;

            if(optionDocente.isSelected()){
                BigDecimal salario = new BigDecimal("0");
                usuario = new Professor(Funcao.PROFESSOR, nome, senha, dataNascimento, salario, null);
                DaoDocentes.cadastrar(usuario);
            }else{
                usuario = new Aluno(Funcao.ALUNO, nome, senha, dataNascimento, null);
                DaoAlunos.cadastrar(usuario);
            }
            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            janelaAtual.close();
        }
    }
    public void cancelar(ActionEvent event){
        Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janelaAtual.close();
    }

    public boolean validarSenha(){
       return campoSenha.getText().equals(campoConfirmacaoSenha.getText());
    }

}
