/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apioriente.com.apppacientes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Conexion {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    Connection con;
    Statement stmt = null;
    String Base = "umg";
    String DB_URL = "jdbc:mysql://localhost:3306/" + Base + "?useSSL=false&serverTimezone=UTC";
    static final String user = "root";
    static final String pass = "1234";

    public Conexion() throws SQLException {
        try {
            con = DriverManager.getConnection(DB_URL, user, pass);
            System.out.println("Conectado a la base de datos");

        } catch (Exception ex) {
            System.out.println("Error al conectame por" + ex.getMessage());
        }

    }

    public void guardarPacientes(Pacientes paciente) {
       
        try {

            if (con != null) {  //preparar la sentencia sql para insertar
                
                PreparedStatement st = con.prepareStatement("insert into pacientes(nombre,direccion,telefono) values (?,?,?)");
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());

                st.execute();

            } else {
                System.out.println("No fue posible guardar el paciente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el paciente" + ex.getMessage());

        }

    }

    public boolean actualizarPaciente(Pacientes paciente, int id_paciente) {
        boolean res = false;

        try {
            if (con != null) {
                PreparedStatement st = con.prepareStatement("update pacientes set nombre=?, direccion=?,telefono=? where id=" + id_paciente);
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());

                st.executeUpdate();
                res = true;
            } else {
                res = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el paciente" + ex.getMessage());

        }
        return res;

    }

    public boolean Eliminar(int id_paciente) {
        boolean resultado = true;
        try {
            if (con != null) {
                throw new Exception("Error de conexion a la base de datos");
            } else {
                PreparedStatement st = con.prepareStatement("delete from pacientes where id=" + id_paciente + "");
                st.execute();
                st.close();

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al eliminar el paciente" + ex.getMessage());
            resultado = false;

        }
        return resultado;

    }

    public void Consultar(DefaultTableModel tablemodel) throws SQLException {
        int numeroColumna = 0;
        ResultSet resultado = null;
        tablemodel.setRowCount(0);
        tablemodel.setColumnCount(0);
        PreparedStatement st = con.prepareStatement("select * from pacientes");
        try {
            resultado = st.executeQuery();
            numeroColumna = resultado.getMetaData().getColumnCount();

            //llenamos los encabezados de las columnas;
            for (int j = 1; j <= numeroColumna; j++) {
                tablemodel.addColumn(resultado.getMetaData().getColumnName(j));
            }
            //llenamos el cuerpo de la tabla

            while (resultado.next()) {
                String[] datos = new String[numeroColumna];

                for (int i = 1; i <= numeroColumna; i++) {
                    datos[i - 1] = (String) resultado.getString(i);
                }

                tablemodel.addRow(datos);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al consultar los pacientes" + ex.getMessage());
        }

    }


}
