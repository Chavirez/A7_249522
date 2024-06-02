package dtos;

public class EditarAlumnoTablaDTO {

    private int idAlumno;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int eliminado;
    private int activo;

    public EditarAlumnoTablaDTO() {
    }

    public EditarAlumnoTablaDTO(int idAlumno, String nombres, String apellidoPaterno, String apellidoMaterno, int eliminado, int activo) {
        this.idAlumno = idAlumno;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.eliminado = eliminado;
        this.activo = activo;
    }    

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "EditarAlumnoTabla{" + "idAlumno=" + idAlumno + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", eliminado=" + eliminado + ", activo=" + activo + '}';
    }
 
    
}