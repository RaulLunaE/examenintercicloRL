/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practicainterciclo.exameninterciclo.repository;

import com.practicainterciclo.exameninterciclo.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raul
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    @Query(value = "Select * from empleado e where e.id_empleado = :id_empleado", nativeQuery = true)
    public Empleado buscarEmpleado(int id_empleado);
}
