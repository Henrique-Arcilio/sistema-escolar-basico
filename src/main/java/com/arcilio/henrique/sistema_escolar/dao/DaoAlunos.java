package com.arcilio.henrique.sistema_escolar.dao;

import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoAlunos {
    public static void cadastrar(Usuario usuario) {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_escolar", "root", "root");
            String sql = "insert into alunos(nome, senha, nascimento, matricula) values(?,?,?,?)";
            PreparedStatement comandoPredefinido = conexao.prepareStatement(sql);
            comandoPredefinido.setString(1, usuario.getNome());
            comandoPredefinido.setString(2, usuario.getSenha());
            comandoPredefinido.setString(3, usuario.getNascimento().toString());
            comandoPredefinido.setString(4, Utilitario.gerarMatricula(usuario));

            comandoPredefinido.execute();
            comandoPredefinido.close();
            conexao.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
