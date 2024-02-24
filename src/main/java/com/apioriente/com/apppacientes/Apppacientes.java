/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.apioriente.com.apppacientes;

import com.apioriente.com.apppacientes.modelo.Conexion;
import com.apioriente.com.apppacientes.vista.Pacientes_Form;
import java.sql.SQLException;

/**
 *
 * @author apioriente
 */
public class Apppacientes {

    public static void main(String[] args) throws SQLException {
          Pacientes_Form paciente = new Pacientes_Form();
          paciente.setBounds(100,50,500,500);
          paciente.setVisible(true);
          
            
    
    }
}
