/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.admin.modelo;

import java.sql.*;
import java.util.*;
import org.apache.log4j.Logger;
import sv.edu.udb.util.*;

/**
 *
 * @author usuario
 */
public class ModeloUsuario {
    Logger log=Logger.getLogger(ModeloUsuario.class);
    public ArrayList<TipoUsuarioBeans> mostrarTipo(){
        try{
            Conexion con=new Conexion();
            ArrayList<TipoUsuarioBeans> datos=new ArrayList();
            String sql="SELECT * FROM tipoUsuario";
            
            con.setRs(sql);
            ResultSet rs=con.getRs();
            while(rs.next()){
                TipoUsuarioBeans data=new TipoUsuarioBeans();
                data.setId(rs.getString(1));
                data.setTipo(rs.getString(2));
                datos.add(data);
            }
            con.cerrarConexion();
            return datos;
        } catch (SQLException ex) {
            log.fatal("Error al mostrar tipo de usuario: "+ex);
        }
        return null;
    }
}
