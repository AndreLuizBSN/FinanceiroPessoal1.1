/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.finPessoal.fonte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class LoginValida {
    
    public int idUsuario = 0;
    public String erroValida = "";
    
    public LoginValida(Connection con, Statement stm, String login, String senha){
        try{
            ResultSet rsLogin = stm.executeQuery("SELECT * FROM USUARIO WHERE USUARIO = '"+login+"' AND SENHA = '"+senha+"' AND ATIVO = '1'");
            if(rsLogin.next()){
                idUsuario = Integer.parseInt(rsLogin.getString("ID"));
            }else{
                erroValida = "Nenhum registro encontrado!";
            }
        }catch(Exception e){
            erroValida = "Erro ao carregar dados de Usuário! "+e.getMessage();
        }
    }
    
}
