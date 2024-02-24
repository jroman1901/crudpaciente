/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apioriente.com.apppacientes.controller;

import com.apioriente.com.apppacientes.modelo.Conexion;
import com.apioriente.com.apppacientes.modelo.Pacientes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apioriente
 */
public class PacientesController implements Ipacientes  {
    
    private Conexion conexion;
    
    public PacientesController() 
    {
        
    }

    @Override
    public boolean Guardar(Pacientes paciente) {
      
        boolean respuesta = false;
        try {
            Conexion conexion = new Conexion();
            conexion.guardarPacientes(paciente);
            respuesta = true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar " + ex.getMessage());
            respuesta = false;

        }

        return respuesta;

    }

    @Override
    public boolean Actualizar(Pacientes paciente, int id_paciente) {
   
        boolean respuesta = false;
        try {
            if (conexion.actualizarPaciente(paciente, id_paciente)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado con exito");
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el paciente");
                respuesta = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + ex.getMessage());
            respuesta = false;
        }
        
        return respuesta;
    }
    
    

    @Override
    public boolean Eliminar(int id_paciente) {
       return true;
    }

    @Override
    public void Consultar(DefaultTableModel modelo) {
        
        try {
            Conexion conexion = new Conexion();
            conexion.Consultar(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
