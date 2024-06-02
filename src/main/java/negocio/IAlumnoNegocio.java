/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.AlumnoTablaDTO;
import dtos.EditarAlumnoTablaDTO;
import dtos.InsertarAlumnoTablaDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IAlumnoNegocio {
    public List<AlumnoTablaDTO> buscarAlumnosTabla() throws NegocioException;
    
    public List<AlumnoTablaDTO> buscarAlumnosTablaSig(int i) throws NegocioException;
    
    public List<AlumnoTablaDTO> editarAlumnosTabla(EditarAlumnoTablaDTO alumno) throws NegocioException;
    
    public List<AlumnoTablaDTO> eliminarAlumnosTabla(int val1) throws NegocioException;
    
    public List<AlumnoTablaDTO> insertarAlumnosTabla(InsertarAlumnoTablaDTO guardarAlumno) throws NegocioException;
}
