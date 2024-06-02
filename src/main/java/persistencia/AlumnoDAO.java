/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dtos.AlumnoTablaDTO;
import dtos.EditarAlumnoTablaDTO;
import dtos.InsertarAlumnoTablaDTO;
import entidad.AlumnoEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AlumnoDAO implements  IAlumnoDAO{
    
    private IConexionBD conexionBD;

    public AlumnoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<AlumnoEntidad> buscarAlumnosTabla() throws PersistenciaException {
        try {
            List<AlumnoEntidad> alumnosLista = null;

            Connection conexion = this.conexionBD.crearConexion();
            String codigoSQL = "SELECT idAlumno, nombres, apellidoPaterno, apellidoMaterno, eliminado, activo FROM alumnos limit 5 offset 0";
            Statement comandoSQL = conexion.createStatement();
            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);
            while (resultado.next()) {
                if (alumnosLista == null) {
                    alumnosLista = new ArrayList<>();
                }
                AlumnoEntidad alumno = this.convertirAEntidad(resultado);
                alumnosLista.add(alumno);
            }
            conexion.close();
            return alumnosLista;
        } catch (SQLException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
    
        @Override
        public List<AlumnoEntidad> buscarAlumnosTablaSig(int i) throws PersistenciaException {
        try {
            List<AlumnoEntidad> alumnosLista = null;

            Connection conexion = this.conexionBD.crearConexion();
            String codigoSQL = "SELECT idAlumno, nombres, apellidoPaterno, apellidoMaterno, eliminado, activo FROM alumnos limit 5 offset ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(1, i);
            ResultSet resultado = preparedStatement.executeQuery();
            while (resultado.next()) {
                if (alumnosLista == null) {
                    alumnosLista = new ArrayList<>();
                }
                AlumnoEntidad alumno = this.convertirAEntidad(resultado);
                alumnosLista.add(alumno);
            }
            conexion.close();
            return alumnosLista;
        } catch (SQLException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    private AlumnoEntidad convertirAEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idAlumno");
        String nombre = resultado.getString("nombres");
        String paterno = resultado.getString("apellidoPaterno");
        String materno = resultado.getString("apellidoMaterno");
        boolean eliminado = resultado.getBoolean("eliminado");
        boolean activo = resultado.getBoolean("activo");
        return new AlumnoEntidad(id, nombre, paterno, materno, eliminado, activo);
    }
    
    @Override
    public List<AlumnoEntidad> insertarAlumnosTabla(InsertarAlumnoTablaDTO guardarAlumno) throws PersistenciaException {
        try{
                        
            Connection conexion = this.conexionBD.crearConexion();
            String codigoSQL = "insert into alumnos (nombres,apellidoPaterno,apellidoMaterno, eliminado, activo) values (?,?,?,?,?);";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, guardarAlumno.getNombres());
            preparedStatement.setString(2, guardarAlumno.getApellidoPaterno());
            preparedStatement.setString(3, guardarAlumno.getApellidoMaterno());
            preparedStatement.setInt(4, guardarAlumno.getEliminado());
            preparedStatement.setInt(5, guardarAlumno.getActivo());
            preparedStatement.execute();
            conexion.close();
            return buscarAlumnosTabla();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al Insertar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        }
    }
    
    @Override
    public List<AlumnoEntidad> editarAlumnosTabla(EditarAlumnoTablaDTO alumno) throws PersistenciaException {
        try{
            
            
            Connection conexion = this.conexionBD.crearConexion();
            String codigoSQL = "update alumnos set nombres = ?, apellidoPaterno = ?, apellidoMaterno = ?, eliminado = ?, activo = ? where idAlumno = ?;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(6, alumno.getIdAlumno()); 
            preparedStatement.setString(1, alumno.getNombres());
            preparedStatement.setString(2, alumno.getApellidoPaterno());
            preparedStatement.setString(3, alumno.getApellidoMaterno());
            preparedStatement.setInt(4, alumno.getEliminado());
            preparedStatement.setInt(5, alumno.getActivo());
            preparedStatement.execute();
            conexion.close();
            return buscarAlumnosTabla();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al editar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        }
    }
    
    @Override
    public List<AlumnoEntidad> eliminarAlumnosTabla(int val1) throws PersistenciaException {
        try{
            
            
            Connection conexion = this.conexionBD.crearConexion();
            String codigoSQL = "delete from alumnos where idAlumno = ?;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(1, val1); 
            preparedStatement.execute();
            conexion.close();
            return buscarAlumnosTabla();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al eliminar  el dato de la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        }
    }
        
    
}
