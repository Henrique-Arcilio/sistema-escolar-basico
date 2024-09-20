package com.arcilio.henrique.sistema_escolar.controller;

import com.arcilio.henrique.sistema_escolar.dao.DaoAlunos;
import com.arcilio.henrique.sistema_escolar.dao.DaoDocentes;
import com.arcilio.henrique.sistema_escolar.dao.Utilitario;
import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;
import com.arcilio.henrique.sistema_escolar.model.categorias.Disciplina;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Aluno;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Diretor;
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
    private Label cabecalho;
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


    public void cadastrar(ActionEvent event) {

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
            Usuario usuario;
            BigDecimal salario = new BigDecimal("0");

            if (Utilitario.contarRegistros("docentes") == 0){
                salario = new BigDecimal("3540");
                usuario = new Diretor(Cargo.DIRETOR, nome, senha, dataNascimento, salario);
                DaoDocentes.cadastrar(usuario);
            }
            if(optionDocente.isSelected() && !optionDocente.isDisabled()){
                usuario = new Professor(Cargo.PROFESSOR, nome, senha, dataNascimento, salario, Disciplina.SEM_DISCIPLINA);
                DaoDocentes.cadastrar(usuario);
            }else{
                usuario = new Aluno(Cargo.ALUNO, nome, senha, dataNascimento, null);
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

    public Label getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(Label cabecalho) {
        cabecalho = cabecalho;
    }
}
