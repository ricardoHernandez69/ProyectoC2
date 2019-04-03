/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoc2;

import java.sql.*;
import sv.edu.udb.util.*;

/**
 *
 * @author Ricardo
 */
public class Login {
    org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(Login.class);
    String usuario;
    public boolean loggin(String usuario, String password){
        try{
            Conexion con=new Conexion();
            String sql="SELECT * FROM usuarios WHERE nombreUsuario=\""+usuario+
                    "\" AND passwordUsuario=SHA2(\""+password+"\",256)";
            this.usuario=usuario;
            boolean result=con.existeDato(sql);
            con.cerrarConexion();
            return result;
        }catch(SQLException ex){
            log.error("Error al Loguearse: "+ex);
            return false;
        }
    }
    public Sesion getDato(){
        try{
            Conexion con=new Conexion();
            String sql="SELECT * FROM usuarios WHERE nombreUsuario=\""+this.usuario+"\"";
            con.setRs(sql);
            ResultSet rs=con.getRs();
            rs.next();
            Sesion sesion=new Sesion();
            sesion.setId(rs.getString(1));
            sesion.setUsuario(rs.getString(2));
            sesion.setTipo(rs.getString(4));
            return sesion;
        }catch(SQLException ex){
            log.error("Error al Loguearse: "+ex);
            return null;
        }
    }
}
