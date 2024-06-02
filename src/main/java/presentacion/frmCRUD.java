/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dtos.AlumnoTablaDTO;
import dtos.EditarAlumnoTablaDTO;
import dtos.InsertarAlumnoTablaDTO;
import entidad.AlumnoEntidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.IAlumnoNegocio;
import negocio.NegocioException;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
/**
 *
 * @author Administrator
 */
public class frmCRUD extends javax.swing.JFrame {
    
    private int pagina = 1;
    private final int LIMITE = 2;
    private IAlumnoNegocio alumnoNegocio;
    private int i = 0;

    /**
     * Creates new form frmCRUD
     */
    public frmCRUD(IAlumnoNegocio alumnoNegocio) {
        initComponents();
        
        this.cargarConfiguracionInicialPantalla();
        this.alumnoNegocio = alumnoNegocio;
        this.cargarMetodosIniciales();
    }
    
    private void cargarConfiguracionInicialPantalla(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void cargarMetodosIniciales(){
        this.cargarConfiguracionInicialTablaAlumnos();
        this.cargarAlumnosEnTabla();
        
    }
    
    private void cargarMetodosSig(int i){

        this.cargarAlumnosEnTablaSig(i);
    }
    
    private void insertarAlumnosTabla(InsertarAlumnoTablaDTO guardarAlumno){
        try{
        this.alumnoNegocio.insertarAlumnosTabla(guardarAlumno);
        } catch (NegocioException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void editarAlumnosTabla(EditarAlumnoTablaDTO alumno){
        try{
        this.alumnoNegocio.editarAlumnosTabla(alumno);
        } catch (NegocioException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void eliminarAlumnosTabla(int val1){
        try{
        this.alumnoNegocio.eliminarAlumnosTabla(val1);
        } catch (NegocioException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
        
    }    
   
    private void cargarConfiguracionInicialTablaAlumnos() {
        
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                
                editar();
                
            }               
        };
            
        
        int indiceColumnaEditar = 5;
        TableColumnModel modeloColumnas = this.tblAlumnos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar",
                        onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar un alumno
                eliminar();
            }
        };
        int indiceColumnaEliminar = 6;
        modeloColumnas = this.tblAlumnos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));
    }

    private int getIdSeleccionadoTablaAlumnos() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private String getNombreSeleccionadoTablaAlumnos() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 1;
            String nombreSocioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return nombreSocioSeleccionado;
        } else {
            return null;
        }
    }  
    
    private String getAPSeleccionadoTablaAlumnos() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 2;
            String aPSocioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return aPSocioSeleccionado;
        } else {
            return null;
        }
    } 
    
    private String getAMSeleccionadoTablaAlumnos() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 3;
            String aMSocioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return aMSocioSeleccionado;
        } else {
            return null;
        }
    }  
    
        private String getEstatusSeleccionadoTablaAlumnos() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 4;
            String estatusSocioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return estatusSocioSeleccionado;
        } else {
            return null;
    }     
        }
  
    
    private void editar() {
        //Metodo para regresar el alumno seleccionado
        int id = this.getIdSeleccionadoTablaAlumnos();
        String nombre = this.getNombreSeleccionadoTablaAlumnos();
        String aPaterno = this.getAPSeleccionadoTablaAlumnos();
        String aMaterno = this.getAMSeleccionadoTablaAlumnos();
        String estatus = this.getEstatusSeleccionadoTablaAlumnos();
        int eliminado = 0;
        int activo = 0;
        if ("Activo".equals(estatus)){
            activo = 1;
            eliminado = 0;
                }
        else {
            activo = 0;
            eliminado = 1;
        }
        EditarAlumnoTablaDTO alumnos = new EditarAlumnoTablaDTO(id, nombre, aPaterno, aMaterno, eliminado, activo);

        editarAlumnosTabla(alumnos);
        
    }

    private void eliminar() {
        //Metodo para regresar el alumno seleccionado
        int id = this.getIdSeleccionadoTablaAlumnos();
        eliminarAlumnosTabla(id);
        this.i = 0;
        cargarMetodosIniciales();
        
    }

    private void llenarTablaAlumnos(List<AlumnoTablaDTO> alumnosLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAlumnos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (alumnosLista != null) {
            alumnosLista.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getIdAlumno();
                fila[1] = row.getNombres();
                fila[2] = row.getApellidoPaterno();
                fila[3] = row.getApellidoMaterno();
                fila[4] = row.getEstatus();

                modeloTabla.addRow(fila);
            });
        }
    }
     
    private void cargarAlumnosEnTabla() {
        try {
            List<AlumnoTablaDTO> alumnos = this.alumnoNegocio.buscarAlumnosTabla();
            this.llenarTablaAlumnos(alumnos);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        private void cargarAlumnosEnTablaSig(int i) {
        try {
            List<AlumnoTablaDTO> alumnos;
            alumnos = this.alumnoNegocio.buscarAlumnosTablaSig(i);
            this.llenarTablaAlumnos(alumnos);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fldNombres = new javax.swing.JTextField();
        fldAPaterno = new javax.swing.JTextField();
        fldAMaterno = new javax.swing.JTextField();
        checkActivo = new javax.swing.JCheckBox();
        btnNRegistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblNumPagina = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Administración de alumnos");

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        fldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldNombresActionPerformed(evt);
            }
        });

        fldAPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldAPaternoActionPerformed(evt);
            }
        });

        fldAMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldAMaternoActionPerformed(evt);
            }
        });

        checkActivo.setText("Activo");
        checkActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActivoActionPerformed(evt);
            }
        });

        btnNRegistro.setText("Nuevo Registro");
        btnNRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNRegistroActionPerformed(evt);
            }
        });

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "A. Paterno", "A. Materno", "Estatus", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblAlumnos);

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblNumPagina.setText("Pagina 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(fldNombres))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(lblTitulo))))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(110, 110, 110))
                            .addComponent(fldAPaterno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fldAMaterno)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(85, 85, 85)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNRegistro)
                            .addComponent(checkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAtras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumPagina)
                                .addGap(261, 261, 261)
                                .addComponent(btnSiguiente)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkActivo))
                .addGap(18, 18, 18)
                .addComponent(btnNRegistro)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente)
                    .addComponent(lblNumPagina))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldNombresActionPerformed

    private void fldAPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldAPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldAPaternoActionPerformed

    private void fldAMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldAMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldAMaternoActionPerformed

    private void checkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActivoActionPerformed

    private void btnNRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNRegistroActionPerformed
        String val1 = fldNombres.getText();
        String val2 = fldAPaterno.getText();
        String val3 = fldAMaterno.getText();
        int val4 = 0;
        int val5 = 0;
        if (checkActivo.isSelected())
        {
            val4 = 0;
            val5 = 1;}
        else
        {
            val4 = 1;
            val5 = 0;};
        
        InsertarAlumnoTablaDTO alumnos = new InsertarAlumnoTablaDTO(val1, val2, val3, val4, val5);
        
        insertarAlumnosTabla(alumnos);
    }//GEN-LAST:event_btnNRegistroActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.i -= 5;
        cargarMetodosIniciales();
        cargarMetodosSig(i);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        this.i += 5;
        cargarMetodosIniciales();
        cargarMetodosSig(i);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnNRegistro;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JTextField fldAMaterno;
    private javax.swing.JTextField fldAPaterno;
    private javax.swing.JTextField fldNombres;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumPagina;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables
}
