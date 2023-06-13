/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practicainterciclo.exameninterciclo.controller;

import com.practicainterciclo.exameninterciclo.model.Empleado;
import com.practicainterciclo.exameninterciclo.service.EmpleadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raul
 */
@RestController
@RequestMapping("/apiempleado")
public class EmpleadoController {
    
    @Autowired
    EmpleadoServiceImpl empladoservice;

    @Operation(summary = "Debe enviar los campos del empleado para crearlo")
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado emp) {
        
        
        return new ResponseEntity<>(empladoservice.save(emp), HttpStatus.CREATED);
    }
    
    @Operation(summary = "Se obtiene la lista de empleados")
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaEmpleados() {
        return new ResponseEntity<>(empladoservice.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe seleccionar el id para eliminar el empleado")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Integer id) {
        empladoservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Operation(summary = "Debe actualizar o modificar los campos del empleado")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado emp) {
        Empleado empleadocontrol = empladoservice.findById(id);
        if (empleadocontrol != null) {
                empleadocontrol.setNombre(emp.getNombre());
                empleadocontrol.setApellido(emp.getApellido());             
                empleadocontrol.setTelefono(emp.getTelefono());
                empleadocontrol.setDireccion(emp.getDireccion());
                empleadocontrol.setFechanacimiento(emp.getFechanacimiento());
                empleadocontrol.setObservacion(emp.getObservacion());
                empleadocontrol.setDiastrabajo(emp.getDiastrabajo());
                empleadocontrol.setSueldo(emp.getSueldo());
            try { 
                return new ResponseEntity<>(empladoservice.save(empleadocontrol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }
}
