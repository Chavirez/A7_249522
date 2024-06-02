/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bda.tc;


import negocio.AlumnoNegocio;
import negocio.IAlumnoNegocio;
import persistencia.AlumnoDAO;
import persistencia.ConexionBD;
import persistencia.IAlumnoDAO;
import persistencia.IConexionBD;
import presentacion.frmCRUD;


/**
 *
 * @author Administrator
 */
public class BDATC {

    public static void main(String[] args) {

        IConexionBD conexionBD = new ConexionBD();
        IAlumnoDAO alumnoDAO =  new AlumnoDAO(conexionBD);
        
        IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
        
        frmCRUD frmcrud = new  frmCRUD (alumnoNegocio);
        frmcrud.show();
        
        System.out.println("Termina la ejecución");
    }
        
}

