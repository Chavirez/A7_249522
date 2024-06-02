/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.AlumnoTablaDTO;
import dtos.EditarAlumnoTablaDTO;
import dtos.InsertarAlumnoTablaDTO;
import entidad.AlumnoEntidad;
import java.util.ArrayList;
import java.util.List;
import persistencia.IAlumnoDAO;
import persistencia.PersistenciaException;
/**
 *
 * @author Administrator
 */
public class AlumnoNegocio implements IAlumnoNegocio{
    
private IAlumnoDAO alumnoDAO;

    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    @Override
    public List<AlumnoTablaDTO> buscarAlumnosTabla() throws NegocioException {
        try {
            List<AlumnoEntidad> alumnos = this.alumnoDAO.buscarAlumnosTabla();            
            return this.convertirAlumnoTablaDTO(alumnos);
        } catch (PersistenciaException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }
    
        @Override
    public List<AlumnoTablaDTO> buscarAlumnosTablaSig(int i) throws NegocioException {
        try {
            List<AlumnoEntidad> alumnos = this.alumnoDAO.buscarAlumnosTablaSig(i);            
            return this.convertirAlumnoTablaDTO(alumnos);
        } catch (PersistenciaException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }
    

    @Override
    public List<AlumnoTablaDTO> insertarAlumnosTabla(InsertarAlumnoTablaDTO guardarAlumno) throws NegocioException {
        try {
            
            List<AlumnoEntidad> alumnos = this.alumnoDAO.insertarAlumnosTabla(guardarAlumno);            
            return this.convertirAlumnoTablaDTO(alumnos);
        } catch (PersistenciaException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }
    
    @Override
    public List<AlumnoTablaDTO> editarAlumnosTabla(EditarAlumnoTablaDTO alumno) throws NegocioException {
        try {
            
            List<AlumnoEntidad> alumnos = this.alumnoDAO.editarAlumnosTabla(alumno);            
            return this.convertirAlumnoTablaDTO(alumnos);
        } catch (PersistenciaException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<AlumnoTablaDTO> eliminarAlumnosTabla(int val1) throws NegocioException {
        try {
            
            List<AlumnoEntidad> alumnos = this.alumnoDAO.eliminarAlumnosTabla(val1);            
            return this.convertirAlumnoTablaDTO(alumnos);
        } catch (PersistenciaException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }
        
    private List<AlumnoTablaDTO> convertirAlumnoTablaDTO(List<AlumnoEntidad> alumnos) throws NegocioException {
        if (alumnos == null) {
            throw new NegocioException("No se pudieron obtener los alumnos");
        }

        List<AlumnoTablaDTO> alumnosDTO = new ArrayList<>();
        for (AlumnoEntidad alumno : alumnos) {
            AlumnoTablaDTO dto = new AlumnoTablaDTO();
            dto.setIdAlumno(alumno.getIdAlumno());
            dto.setNombres(alumno.getNombres());
            dto.setApellidoPaterno(alumno.getApellidoPaterno());
            dto.setApellidoMaterno(alumno.getApellidoMaterno());
            dto.setEstatus(alumno.isActivo() == true ? "Activo" : "Inactivo");
            alumnosDTO.add(dto);
        }
        return alumnosDTO;
    }
}
