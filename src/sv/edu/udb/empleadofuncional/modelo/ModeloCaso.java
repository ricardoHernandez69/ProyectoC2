/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleadofuncional.modelo;

import java.sql.*;
import java.util.ArrayList;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Ricardo
 */
public class ModeloCaso {
     org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(ModeloCaso.class);
    public ArrayList<BeansCaso> mostrarCaso(String idUser){
        try{
            Conexion con=new Conexion();
            String sql="SELECT c.codigoCaso,c.descripcionCaso,c.fechaLimite,"+
                    " e1.nombresEmpleado,es.estadoSolicitud FROM casos c INNER JOIN "+
                    "empleadosDeArea eda ON c.empleadoTester=eda.idEmpleadoDeArea INNER JOIN "+
                    "empleados e on e.idEmpleado=eda.idEmpleado inner JOIN "+
                    "programadores p on p.idProgramador=c.programadorAsignado INNER JOIN "+
                    "empleados e1 on e1.idEmpleado=p.idEmpleadoProg INNER JOIN "+
                    "estadoSolicitudes es on es.idEstadoSolicitud=c.idSolicitudAprobada WHERE e.usuarioEmpleado=\""+idUser+"\"";
            con.setRs(sql);
            ResultSet rs=con.getRs();
            ArrayList<BeansCaso> arreglo=new ArrayList();
            while(rs.next()){
                BeansCaso dato=new BeansCaso();
                dato.setCodigoCaso(rs.getString(1));
                dato.setDescripcionCaso(rs.getString(2));
                dato.setFechaLimite(rs.getString(3));
                dato.setProgramadorAsignado(rs.getString(4));
                dato.setEstadoSolicitud(rs.getString(5));
                arreglo.add(dato);
            }
            con.cerrarConexion();
            return arreglo;
        }catch(SQLException ex){
            log.error("Error al mostrar casos: "+ex);
            return null;
        }
    }
}
