/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class Validaciones {
     Pattern letras = Pattern.compile("^[a-zA-Z ]*$");
    Pattern numero = Pattern.compile("[0-9].*");
   public boolean datoVacio(String datoIngresado){
       if(datoIngresado.equals("")){return true;}
       else{return false;}
   }
   public boolean soloLetras(String palabra){
       boolean resultado;
       if(palabra!=null){
           Matcher matcher = letras.matcher(palabra);
           if(matcher.find()){
               resultado=true;
           }else{
               resultado=false;
           }
       }else{
               resultado=false;
       }
       return resultado;
   }
   
   public boolean soloNumeros(String palabra){
       boolean resultado;
       if(palabra!=null){
           Matcher matcher = numero.matcher(palabra);
           if(matcher.find()){
               resultado=true;
           }else{
               resultado=false;
           }
       }else{
               resultado=false;
       }
       return resultado;
   }
   
   public boolean noNulo(String palabra){
       boolean resultado;
       if(palabra!=null){
           resultado=true;
       }else{
           JOptionPane.showMessageDialog(null, "Accion Denegada", "Error", JOptionPane.ERROR_MESSAGE);
           resultado=false;
       }
       return resultado;
   }
    public boolean evaluacionFecha(String fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        int resultado;
        String regex = "^[0-3][0-9]-[0-3][0-9]-(?:[0-9][0-9])?[0-9][0-9]$";//Expresion regular formato dd-mm-yyyy
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);
        if(matcher.find()){//Determina que sea del formato. dd-mm-yy
            try {
                formatoFecha.setLenient(false);//determina que la fecha este dentro de los parametros establecidos
                //ejemplo que no sean mas de 12 meses,
                formatoFecha.parse(fecha);//Si es valido la fecha, deveelve 1                        
                return true;

            } catch (ParseException e) {//Si es falso entonces devuelve cero
                return false;
            }                   
        }
        else{
            return false;
        }
    }
}
