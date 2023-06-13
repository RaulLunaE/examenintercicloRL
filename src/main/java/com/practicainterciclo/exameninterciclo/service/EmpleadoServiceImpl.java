/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practicainterciclo.exameninterciclo.service;

import com.practicainterciclo.exameninterciclo.model.Empleado;
import com.practicainterciclo.exameninterciclo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Raul
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado, Integer>{

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoRepository;
    }
    
}
