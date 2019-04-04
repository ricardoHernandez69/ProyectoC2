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
    public ArrayList<BeansTipoUsuario> mostrarTipo(){
        try{
            Conexion con=new Conexion();
            ArrayList<BeansTipoUsuario> datos=new ArrayList();
            String sql="SELECT * FROM tipoUsuario";
            
            con.setRs(sql);
            ResultSet rs=con.getRs();
            while(rs.next()){
                BeansTipoUsuario data=new BeansTipoUsuario();
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
    public boolean ingresarAdmin(String nombre,String apellido, String dui,String fecha, String usuario, String password, String tipo){
        try{
            Conexion con=new Conexion();
            String sql="INSERT INTO usuarios values(null,\""+usuario+"\",SHA2(\""+password+"\",256),"+tipo+")";
            
            con.setQuery(sql);
            sql="INSERT INTO empleados values(null,\""+nombre+"\",\""+apellido+"\",\""+dui+"\",\""+fecha+
                    "\",(SELECT idUsuario FROM usuarios Where nombreUsuario=\""+usuario+"\"),12,6)";
            System.out.println(sql);
            con.setQuery(sql);
           
            con.cerrarConexion();
            return true;
        }catch(SQLException ex){
            log.fatal("Error al insertar admin: "+ex);
            return false;
        }
    }
    public boolean ingresarJefe(String nombre,String apellido, String dui,String fecha, String usuario, String password, String tipo,String area,String idArea){
        try{
            Conexion con=new Conexion();
            switch (tipo) {
                case "2":
                {
                    String sql="INSERT INTO usuarios values(null,\""+usuario+"\",SHA2(\""+password+"\",256),"+tipo+")";
                    
                    con.setQuery(sql);
                    String cargo="Jefe de Desarrollo del "+area;
                    sql="INSERT INTO cargos values(null,\""+cargo+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO empleados values(null,\""+nombre+"\",\""+apellido+"\",\""+dui+"\",\""+fecha+
                            "\",(SELECT idUsuario FROM usuarios Where nombreUsuario=\""+usuario+"\"),"+
                            "(SELECT idCargo FROM cargos WHERE nombreCargo=\""+cargo+"\"),\""+idArea+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO jefesDesarrollo values(null,"+
                            "(SELECT e.idEmpleado FROM empleados e INNER JOIN usuarios u ON "+
                            "e.usuarioEmpleado=u.idUsuario WHERE u.nombreUsuario=\""+usuario+"\"),"+idArea+")";
                    con.setQuery(sql);
                    con.cerrarConexion();
                    return true;
                }
                case "3":
                {
                    String sql="INSERT INTO usuarios values(null,\""+usuario+"\",SHA2(\""+password+"\",256),"+tipo+")";
                    
                    con.setQuery(sql);
                    String cargo="Jefe del "+area;
                    sql="INSERT INTO cargos values(null,\""+cargo+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO empleados values(null,\""+nombre+"\",\""+apellido+"\",\""+dui+"\",\""+fecha+
                            "\",(SELECT idUsuario FROM usuarios Where nombreUsuario=\""+usuario+"\"),"+
                            "(SELECT idCargo FROM cargos WHERE nombreCargo=\""+cargo+"\"),\""+idArea+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO jefesArea values(null,"+
                            "(SELECT e.idEmpleado FROM empleados e INNER JOIN usuarios u ON "+
                            "e.usuarioEmpleado=u.idUsuario WHERE u.nombreUsuario=\""+usuario+"\"))";
                    con.setQuery(sql); 
                    con.cerrarConexion();
                    return true;
                }
                default:
                    return false;
            }
        }catch(SQLException ex){
            log.fatal("Error al insertar jefe: "+ex);
            return false;
        }
    }
    public boolean ingresarEmpleado(String nombre,String apellido, String dui,String fecha, String usuario, String password, String tipo,String area,String idArea, String cargo, String idCargo){
        try{
            Conexion con=new Conexion();
            switch (tipo) {
                case "4":
                {
                    String sql="INSERT INTO usuarios values(null,\""+usuario+"\",SHA2(\""+password+"\",256),"+tipo+")";
                    con.setQuery(sql);
                    sql="INSERT INTO empleados values(null,\""+nombre+"\",\""+apellido+"\",\""+dui+"\",\""+fecha+
                            "\",(SELECT idUsuario FROM usuarios Where nombreUsuario=\""+usuario+"\"),"+
                            "\""+idCargo+"\",\""+idArea+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO programadores VALUES(null,(SELECT e.idEmpleado FROM empleados e INNER JOIN usuarios u ON "+
                            "e.usuarioEmpleado=u.idUsuario WHERE u.nombreUsuario=\""+usuario+"\"),"+
                            "(SELECT jd.idJefeDesarrollo FROM jefesDesarrollo jd INNER JOIN areas a on"+
                            " jd.idAreaDesarrollo=a.idArea WHERE a.idArea="+idArea+"))";
                    con.setQuery(sql);
                    return true;
                }
                case "5":
                {
                    String sql="INSERT INTO usuarios values(null,\""+usuario+"\",SHA2(\""+password+"\",256),"+tipo+")";
                    con.setQuery(sql);
                    sql="INSERT INTO empleados values(null,\""+nombre+"\",\""+apellido+"\",\""+dui+"\",\""+fecha+
                            "\",(SELECT idUsuario FROM usuarios Where nombreUsuario=\""+usuario+"\"),"+
                            "\""+idCargo+"\",\""+idArea+"\")";
                    con.setQuery(sql);
                    sql="INSERT INTO empleadosDeArea VALUES(null,(SELECT e.idEmpleado FROM empleados e INNER JOIN usuarios u ON "+
                            "e.usuarioEmpleado=u.idUsuario WHERE u.nombreUsuario=\""+usuario+"\"),"+
                            "(SELECT ja.idJefeArea FROM jefesArea ja INNER JOIN empleados e on"+
                            " ja.idEmpleado=e.idEmpleado WHERE e.areaEmpleado="+idArea+"))";
                    con.setQuery(sql);
                    return true;
                }
                default:
                    return false;
            }
        }catch(SQLException ex){
            log.fatal("Error al insertar Empleado: "+ex);
            return false;
        }
        
    }
    public ArrayList<BeansDatosEmpleados> mostrarEmpleados(){
        try {
            Conexion con=new Conexion();
            String sql="SELECT e.idEmpleado,e.nombresEmpleado,e.apellidosEmpleado,"+
                    "e.duiEmpleado,e.fechaNacimientoEmpleado,u.nombreUsuario,t.nombreTipoUsuario,a.nombreArea,"+
                    "c.nombreCargo FROM empleados e INNER JOIN usuarios u on e.usuarioEmpleado=u.idUsuario INNER"+
                    " JOIN tipoUsuario t on u.tipoUsuario=t.idTipoUsuario INNER JOIN areas a on e.areaEmpleado=a.idArea"+
                    " INNER JOIN cargos c on c.idCargo=e.cargoEmpleado ORDER BY t.idTipoUsuario";
            con.setRs(sql);
            ResultSet rs=con.getRs();
            ArrayList<BeansDatosEmpleados> arreglo=new ArrayList();
            while(rs.next()){
                BeansDatosEmpleados data=new BeansDatosEmpleados();
                data.setIdEmpleado(rs.getString(1));
                data.setNombre(rs.getString(2));
                data.setApellido(rs.getString(3));
                data.setDui(rs.getString(4));
                data.setFecha(rs.getString(5));
                data.setUsuario(rs.getString(6));
                data.setTipo(rs.getString(7));
                data.setArea(rs.getString(8));
                data.setCargo(rs.getString(9));
                arreglo.add(data);
            }
            return arreglo;
        } catch (SQLException ex) {
            log.fatal("Error al verificar si existe el usuario: "+ex);
            return null;
        }
    }
    public boolean updateUsuario(int id,String nombre,String apellido, String dui, String fecha){
        try {
            Conexion con=new Conexion();
            String sql="UPDATE empleados set nombresEmpleado=\""+nombre+"\",apellidosEmpleado=\""+apellido+
                    "\",duiEmpleado=\""+dui+"\",fechaNacimientoEmpleado=\""+fecha+"\" WHERE idEmpleado="+id;
            con.setQuery(sql);
            con.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            log.fatal("Error al Actualizar los datos del empleado: "+ex);
            return false;
        }
    }
    public boolean existeUsuario(String usuario){
        try {
            Conexion con=new Conexion();
            String sql="SELECT * FROM usuarios WHERE nombreUsuario=\""+usuario+"\"";
            return con.existeDato(sql);
        } catch (SQLException ex) {
            log.fatal("Error al verificar si existe el usuario: "+ex);
            return true;
        }
    }
}
