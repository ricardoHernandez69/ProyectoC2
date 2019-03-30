/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.util;
import java.sql.*;
import org.apache.log4j.Logger;
/**
 *
 * @author Ricardo
 */
public class Conexion {
    private final Logger log=Logger.getLogger(Conexion.class);
    private Connection conexion =null;
    private Statement s =null;
    private ResultSet rs=null;
    public Conexion() throws SQLException{
        try
        {
            String link="jdbc:mysql://db4free.net:3306/java_avanzado?autoReconnect=true&useSSL=false";
            String user="undertaker696";
            String pass="perro123";
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection (link,user,pass);
            // Permite ejecutar sentencias SQL sin parámetros
            s = conexion.createStatement();
            
        }
        catch (ClassNotFoundException e1) {
            //Error si no puedo leer el driver de MySQL
            log.fatal("ERROR:No encuentro el driver de la BD: "+e1.getMessage());
        }
    }
    //Metodo que permite obtener los valores del resulset
    public ResultSet getRs() {
        return rs;
    }
    //Metodo que permite fijar la tabla resultado de la pregunta
    //SQL realizada
    public void setRs(String sql) {
        try {
            this.rs = s.executeQuery(sql);
        } catch (SQLException e2) {
            //Error SQL: login/passwd ó sentencia sql errónea
            
            log.fatal("ERROR:Fallo en SQL: "+e2.getMessage());
        }
    }
    //Metodo que recibe un sql como parametro que sea un update,insert.delete
    public void setQuery(String sql) throws SQLException {
        this.s.executeUpdate(sql);
    }
    public boolean existeDato(String sql) throws SQLException{
        boolean result;
        int i=0; //Bandera, determina si existe o no un dato en la base de datos
        setRs(sql);
        while (rs.next()){
            i++;
        }
        if(i==0){
            result=false;//No existe en la base de datos
        }else{
            result=true;//Si existe;
        }
        return result;
    }
    //Metodo que cierra la conexion
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
