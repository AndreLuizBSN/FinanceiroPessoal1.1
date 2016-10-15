
package br.com.finPessoal.fonte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;

public class GeralClass {

    public void setCarregaComboMes(JComboBox combo){
        
        combo.addItem("Janeiro");
        combo.addItem("Fevereiro");
        combo.addItem("Março");
        combo.addItem("Abril");
        combo.addItem("Maio");
        combo.addItem("Junho");
        combo.addItem("Julho");
        combo.addItem("Agosto");
        combo.addItem("Setembro");
        combo.addItem("Outubro");
        combo.addItem("Novembro");
        combo.addItem("Dezembro");
        
        //combo.setSelectedItem(getMesAtualExt());
        
    }
    
    public String getMesNumerico(String nome){
        
        switch (nome) {
            case "Janeiro":
                return "01";
            case "Fevereiro":
                return "02";
            case "Março":
                return "03";
            case "Abril":
                return "04";
            case "Maio":
                return "05";
            case "Junho":
                return "06";
            case "Julho":
                return "07";
            case "Agosto":
                return "08";
            case "Setembro":
                return "09";
            case "Outubro":
                return "10";
            case "Novembro":
                return "11";
            case "Dezembro":
                return "12";
            default:
                return "";
        }
    }
    
    public String getMesAtual(){
         
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM");
        
       return df.format(date);
        
    }
    
    
    public String getAnoAtual(){
         
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        
       return df.format(date);
        
    }

    public String getMesAtualExt() {
        
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM");
        
        String dateStr = df.format(date);
        
        if(dateStr.equals("01")){
            return "Janeiro";
        }else if(dateStr.equals("02")){
            return "Fevereiro";    
        }else if(dateStr.equals("03")){
            return "Março";    
        }else if(dateStr.equals("04")){
            return "Abril";    
        }else if(dateStr.equals("05")){
            return "Maio";    
        }else if(dateStr.equals("06")){
            return "Junho";    
        }else if(dateStr.equals("07")){
            return "Julho";    
        }else if(dateStr.equals("08")){
            return "Agosto";    
        }else if(dateStr.equals("09")){
            return "Setembro";    
        }else if(dateStr.equals("10")){
            return "Outubro";    
        }else if(dateStr.equals("11")){
            return "Novembro";    
        }else{
            return "Dezembro";    
        }
    }
    
    
}
