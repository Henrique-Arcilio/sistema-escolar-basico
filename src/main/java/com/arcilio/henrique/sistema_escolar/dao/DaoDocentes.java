package com.arcilio.henrique.sistema_escolar.dao;

import com.arcilio.henrique.sistema_escolar.model.categorias.Disciplina;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DaoDocentes {
    public static void cadastrar(Usuario usuario) {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_escolar", "root", "root");
            String sql = "insert into docentes(nome, senha, nascimento, matricula, cargo) values(?,?,?,?,?)";
            PreparedStatement comandoPredefinido = conexao.prepareStatement(sql);
            comandoPredefinido.setString(1, usuario.getNome());
            comandoPredefinido.setString(2, usuario.getSenha());
            comandoPredefinido.setString(3, usuario.getNascimento().toString());
            comandoPredefinido.setString(4, Utilitario.gerarMatricula(usuario));
            comandoPredefinido.setString(5, usuario.getFuncao().getNome());

            comandoPredefinido.execute();
            comandoPredefinido.close();
            conexao.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void deletar(Usuario usuario){

    }
}
