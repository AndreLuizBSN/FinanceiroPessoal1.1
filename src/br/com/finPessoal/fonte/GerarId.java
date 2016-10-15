/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.finPessoal.fonte;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class GerarId {
    
    private String nomeTabela;
    
    public GerarId(String NomeTabela){
        this.nomeTabela = NomeTabela;
    }
    
    public String getProximoId(){
        ConBanco cb = new ConBanco();
        ConexaoClass cc = cb.IniciarBd();
        String id;
        try{
            ResultSet rsConFin = cc.stm.executeQuery("select * from gerar_id where nome_tabela = '"+this.nomeTabela+"'");
            
            if(rsConFin.next()){
                id = rsConFin.getString("ID");

                int idInt = Integer.parseInt(id);
                idInt ++;
                String sql = "UPDATE GERAR_ID SET ID = '"+String.valueOf(idInt)+"' WHERE NOME_TABELA = '"+this.nomeTabela+"'";

                cc.stm.executeUpdate(sql);

                return id;
            }else{
                return "-1";
            }
            
        }catch(SQLException e){
            return e.getMessage();
            
        }
        
    }
    
}
