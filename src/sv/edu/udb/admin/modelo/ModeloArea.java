/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.admin.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Ricardo
 */
public class ModeloArea {
    org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(ModeloArea.class);
    private String sql;
    public ArrayList<BeansArea> mostrarAreas(){
        try{
            Conexion con=new Conexion();
            sql="SELECT * FROM areas";
            con.setRs(sql);
            ResultSet rs=con.getRs();
            ArrayList<BeansArea> arreglo= new ArrayList();
            while(rs.next()){
                BeansArea data=new BeansArea();
                data.setId(rs.getString(1));
                data.setArea(rs.getString(2));
                arreglo.add(data);
            }
            con.cerrarConexion();
            return arreglo;
        } catch (SQLException ex) {
            log.fatal("Error al mostrar las Areas: "+ex);
            return null;
        }
    }
    public boolean ingresarArea(String nombreArea){
        try{
            Conexion con=new Conexion();
            sql="INSERT INTO areas(nombreArea) values(\""+nombreArea+"\")";
            con.setQuery(sql);
            return true;
        } catch (SQLException ex) {
            log.fatal("Error al Insertar las Areas: "+ex);
            return false;
        }
    }
}
