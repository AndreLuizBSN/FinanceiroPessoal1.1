/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.finPessoal.fonte;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class GetConfig {
   
  
    private static Properties config = new Properties();  
    private static String arquivo = "C:/FinPes/conf/config.ini";  
    
    public String host, porta, banco, usuario, senha, erroStr, iconeCaminho;
    public int erro;
    
    public GetConfig(){
        try {  

            config.load(new FileInputStream(arquivo));  

            host = config.getProperty("HOST");
            porta = config.getProperty("PORTA");
            banco = config.getProperty("BANCO");
            usuario = config.getProperty("USUARIO");
            senha = config.getProperty("SENHA");
            iconeCaminho = config.getProperty("ICONE");
            
            
            
            erro = 0;
            erroStr = "";

        } catch (IOException ex) {  
            erro = 1;
            erroStr = "Problemas ao ler arquivo INI";
        } 
    }
    
    public Image getIco(){
        //setar Icone novo para programa
        ImageIcon icon2 = new ImageIcon(iconeCaminho);
        return icon2.getImage();
    }
    
}

