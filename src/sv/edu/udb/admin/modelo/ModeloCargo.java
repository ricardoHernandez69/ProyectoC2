/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.admin.modelo;

import java.sql.*;
import java.util.ArrayList;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Ricardo
 */
public class ModeloCargo {
    org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(ModeloArea.class);
    private String sql;
    public ArrayList<BeansCargo> mostrarCargos(){
        try{
            Conexion con=new Conexion();
            sql="SELECT * FROM cargos WHERE idCargo NOT IN (SELECT e.cargoEmpleado "+
                    "FROM empleados e INNER JOIN jefesDesarrollo jd on e.idEmpleado=jd.idEmpleado)"+
                    " AND idCargo NOT IN (SELECT e.cargoEmpleado FROM empleados e "+
                    "INNER JOIN jefesArea ja on e.idEmpleado=ja.idEmpleado)";
           
            con.setRs(sql);
            ResultSet rs=con.getRs();
            ArrayList<BeansCargo> arreglo= new ArrayList();
            while(rs.next()){
                BeansCargo data=new BeansCargo();
                data.setId(rs.getString(1));
                data.setCargo(rs.getString(2));
                arreglo.add(data);
            }
            
            return arreglo;
        }catch(SQLException ex){
            log.error("Error al mostrar los cargos: "+ex);
            return null;
        }
    }
    public boolean ingresarCargo(String cargo){
        try{
            Conexion con=new Conexion();
            sql="INSERT INTO cargos VALUES(null,\""+cargo+"\")";
            con.setQuery(sql);
            return true;
        }catch(SQLException ex){
            log.error("Error al ingresar un cargo: "+ex);
            return false;
        }
    }
}
