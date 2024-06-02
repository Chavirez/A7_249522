/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import dtos.EditarAlumnoTablaDTO;
import dtos.InsertarAlumnoTablaDTO;
import entidad.AlumnoEntidad;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IAlumnoDAO {
    
     public List<AlumnoEntidad> buscarAlumnosTabla() throws PersistenciaException;
     
     public List<AlumnoEntidad> buscarAlumnosTablaSig(int i) throws PersistenciaException;
             
     public List<AlumnoEntidad> editarAlumnosTabla(EditarAlumnoTablaDTO alumno) throws PersistenciaException;
     
     public List<AlumnoEntidad> insertarAlumnosTabla(InsertarAlumnoTablaDTO guardarAlumno) throws PersistenciaException;
     
     public List<AlumnoEntidad> eliminarAlumnosTabla(int val1) throws PersistenciaException;
     
}
