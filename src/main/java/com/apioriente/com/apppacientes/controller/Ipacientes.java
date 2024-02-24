/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apioriente.com.apppacientes.controller;

import com.apioriente.com.apppacientes.modelo.Pacientes;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apioriente
 */
public interface Ipacientes {

    public boolean Guardar(Pacientes paciente);

    public boolean Actualizar(Pacientes paciente, int id_paciente);

    public boolean Eliminar(int id_paciente);

    public void Consultar(DefaultTableModel modelo);

}
