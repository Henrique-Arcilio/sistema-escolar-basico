package com.arcilio.henrique.sistema_escolar.dao;

import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;
import com.arcilio.henrique.sistema_escolar.model.categorias.Disciplina;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Diretor;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Professor;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DaoDocentes {
    public static void cadastrar(Usuario usuario) {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_escolar", "root", "root");
            String sql = "INSERT INTO docentes(nome, senha, nascimento, matricula, cargo) values(?,?,?,?,?)";
            PreparedStatement comandoPredefinido = conexao.prepareStatement(sql);
            comandoPredefinido.setString(1, usuario.getNome());
            comandoPredefinido.setString(2, usuario.getSenha());
            comandoPredefinido.setDate(3, Date.valueOf(usuario.getNascimento()));
            comandoPredefinido.setString(4, Utilitario.gerarMatricula(usuario));
            comandoPredefinido.setString(5, usuario.getFuncao().toString());

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
    public static Usuario buscar(String matricula, String NomeDoCargo){
        Usuario usuario = null;
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_escolar", "root", "root");
            String sql = "SELECT * FROM " + NomeDoCargo + " WHERE matricula = ? " ;
            PreparedStatement comandoPredefinido = conexao.prepareStatement(sql);
            comandoPredefinido.setString(1, matricula);
            ResultSet registro = comandoPredefinido.executeQuery();

            if(registro.next()){
                String nome = registro.getString("nome");
                String senhaHashNoBanco =  registro.getString("senha");
                LocalDate nascimento = registro.getDate("nascimento").toLocalDate();
                BigDecimal salario = registro.getBigDecimal("salario");
                Disciplina disciplina = Disciplina.valueOf(registro.getString("disciplina"));
                Cargo cargo = Cargo.valueOf(registro.getString("cargo"));
                if(cargo == Cargo.DIRETOR){
                    usuario = new Diretor(cargo, nome, senhaHashNoBanco, nascimento,  salario);
                }else{
                    usuario = new Professor(cargo, nome, senhaHashNoBanco, nascimento,  salario, disciplina);
                }
                System.out.println(nascimento);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return usuario;
    }
}
