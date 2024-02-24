/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  apioriente
 * Created: 10-feb-2024
 */

CREATE DATABASE UMG;

CREATE TABLE PACIENTES(
  id integer AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(100) not null,
  direccion varchar(100) not null,
  telefono varchar(30)
);



