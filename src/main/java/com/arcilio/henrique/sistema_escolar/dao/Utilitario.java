package com.arcilio.henrique.sistema_escolar.dao;

import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Usuario;

import java.sql.*;

public class Utilitario {
    public boolean verificarExistenciaDiretor(){
        int quantiDeUsuarios = contarRegistros("docentes");
        return quantiDeUsuarios != 0;
    }
    public static String gerarMatricula(Usuario usuario){
        String cargo = null;
        switch (usuario.getFuncao()){
            case Cargo.ALUNO:
                cargo = "A" + "2024" + (contarRegistros("alunos") + 1);
            case Cargo.DIRETOR:
                cargo = "D" + "2024" + (contarRegistros("docentes") + 1);
            case Cargo.PROFESSOR:
                cargo = "P" + "2024" + (contarRegistros("docentes") + 1);
        }
        return cargo;
    }
    public static int contarRegistros(String tabelaInformada) {
        int contador = 0;
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_escolar", "root", "root");
            String sql =  "select * from " + tabelaInformada;
            PreparedStatement comandoPredefinido = conexao.prepareStatement(sql);
            ResultSet registros = comandoPredefinido.executeQuery();
            while (registros.next()){
                contador += 1;
            }
            registros.close();
            conexao.close();
        }
       catch(Exception e){
            System.out.println(e.getMessage());
       }
        return contador;
    }
}
