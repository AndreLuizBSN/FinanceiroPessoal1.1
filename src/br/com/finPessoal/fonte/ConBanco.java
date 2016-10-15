/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.finPessoal.fonte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.NativeDate;

/**
 *
 * @author User
 */
public class ConBanco {
    
    
    private String host, porta, banco, usuario, senha;
    
    //host
    public void setHost(String host){
        this.host = host;
    }
    
    public String getHost(){
        return this.host;
    }
    
    //porta
    public void setPorta(String porta){
        this.porta = porta;
    }
    
    public String getPorta(){
        return this.porta;
    }
    
    //banco
    public void setBanco(String banco){
        this.banco = banco;
    }
    
    public String getBanco(){
        return this.banco;
    }
    
    //Usuário
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    //Senha
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void SetarConfiguracoes(){
        GetConfig gc = new GetConfig();
        setHost(gc.host);
        setPorta(gc.porta);
        setBanco(gc.banco);
        setUsuario(gc.usuario);
        setSenha(gc.senha);
    }
    
    public ConexaoClass IniciarBd(){
        
        SetarConfiguracoes();
        
        Connection con = null;
        String erroStr = "";
        int erro = 0;
        Statement stm = null;
        ConexaoClass cc = new ConexaoClass();
        
        try {
            Class.forName( "org.postgresql.Driver" );
            erro = 0;
            erroStr = "";
        } catch( ClassNotFoundException e ) {
            erroStr = "Erro Driver";
            erro = 1;
        }
        
        String url = "jdbc:postgresql://"+getHost()+":"+String.valueOf(getPorta())+"/"+getBanco();
        String user = getUsuario();
        String pass = getSenha();
        
        if(erro == 0){
            try {
                con = DriverManager.getConnection( url, user, pass );
                erro = 0;
                erroStr = "";
                stm = con.createStatement();

            }catch(Exception e){
                erro = 1;
                erroStr = "Erro ao Conectar ao Banco de dados";
            }
        }
        
        cc.con = con;
        cc.erro = erro;
        cc.erroStr = erroStr;
        cc.stm = stm;
        
        return cc;
        
    }

    public String getUsuarioNome(String id){
        
        
        ConBanco cb = new ConBanco();
        ConexaoClass cc = cb.IniciarBd();
        
        
        try{
            ResultSet rsLogin = cc.stm.executeQuery("SELECT * FROM USUARIO WHERE ID = "+id);
            if(rsLogin.next()){
                return rsLogin.getString("NOME");
            }else{
                return "Nenhum registro encontrado!";
            }
        }catch(Exception e){
            return "Erro ao carregar dados de Usuário! "+e.getMessage();
        }
    }
    
    
}
