package com.example.hospital_vm.repository;


import com.example.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente,Integer> {







}
