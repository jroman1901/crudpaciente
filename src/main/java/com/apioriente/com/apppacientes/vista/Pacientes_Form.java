/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.apioriente.com.apppacientes.vista;

import com.apioriente.com.apppacientes.controller.PacientesController;
import com.apioriente.com.apppacientes.modelo.Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apioriente
 */
public class Pacientes_Form extends javax.swing.JFrame implements ActionListener {

    private int id;
    
    public Pacientes_Form() throws SQLException {
        initComponents();
        btnguardar.addActionListener(this);
        btneditar.addActionListener(this);

        cargarTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pacientes"));
        jPanel1.setLayout(null);

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(47, 46, 50, 16);

        jLabel2.setText("Direccion");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 100, 60, 20);

        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 137, 55, 39);
        jPanel1.add(txtnombre);
        txtnombre.setBounds(180, 50, 178, 24);
        jPanel1.add(txtdireccion);
        txtdireccion.setBounds(184, 95, 178, 24);
        jPanel1.add(txttelefono);
        txttelefono.setBounds(184, 144, 178, 24);

        btnguardar.setText("Guardar");
        jPanel1.add(btnguardar);
        btnguardar.setBounds(50, 190, 79, 32);

        btneditar.setText("Editar");
        jPanel1.add(btneditar);
        btneditar.setBounds(180, 190, 66, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 20, 440, 250);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setFocusable(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 270, 440, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (tabla.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "no hay datos para cargar");

        } else {
            this.id = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            txtnombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtdireccion.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            txttelefono.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());

        }

    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnguardar) {
            Pacientes paciente = new Pacientes();
            PacientesController controlador = new PacientesController();
            paciente.setNombre(txtnombre.getText());
            paciente.setDireccion(txtdireccion.getText());
            paciente.setTelefono(txttelefono.getText());
            controlador.Guardar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente registrado con exito");

        }

        if (e.getSource() == btneditar) {
            Pacientes paciente = new Pacientes();
            try {
                PacientesController controlador = new PacientesController();
                paciente.setNombre(txtnombre.getText());
                paciente.setDireccion(txtdireccion.getText());
                paciente.setTelefono(txttelefono.getText());
                controlador.Actualizar(paciente, id);
                this.cargarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Pacientes_Form.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Paciente editado con exito");
            }

        }

    }

    public void cargarTabla() throws SQLException {
        PacientesController controller = new PacientesController();
        DefaultTableModel model = new DefaultTableModel();
        controller.Consultar(model);
        tabla.setModel(model);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
