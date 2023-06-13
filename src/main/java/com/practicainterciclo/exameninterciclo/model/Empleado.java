/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practicainterciclo.exameninterciclo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;
    
    @Size(max = 45, message = "El NOMBRE del empleado debe tener maximo 45 caracteres")
    @NotBlank(message = "El NOMBRE del empleado no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 45, message = "El APELLIDO del empleado debe tener maximo 45 caracteres")
    @NotBlank(message = "El APELLIDO del empleado no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;
    
    @Size(max = 15, message = "El TELEFONO del empleado debe tener maximo 15 caracteres")
    @NotBlank(message = "El TELEFONO del empleado no puede estar en blanco")
    @Column(name = "telefono")
    private String telefono;
    
    @Size(max = 45, message = "La DIRECCION del empleado debe tener maximo 45 caracteres")
    @NotBlank(message = "La DIRECCION del empleado no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "fechanacimiento")
    @NotBlank(message = "La FECHA DE NACIMIENTO del empleado no puede estar en blanco")
    private Date fechanacimiento;
    
    @Size(max = 45, message = "La OBSERVACION del empleado debe tener maximo 45 caracteres")
    @NotBlank(message = "La OBSERVACIO del empleado no puede estar en blanco")
    @Column(name = "observacion")
    private String observacion;
    
    @NotBlank(message = "Los DIAS DE TRABAJO del empleado no puede estar en blanco")
    @Column(name = "diastrabajo")
    private int diastrabajo;
    
    @DecimalMin(value = "0.00", inclusive = true, message = "El SUELDO del empleado debe ser no negativo")
    @NotBlank(message = "El SUELDO del empleado no puede estar en blanco")
    @Column(name = "sueldo")
    private Double sueldo;
}
