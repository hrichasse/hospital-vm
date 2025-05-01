package com.example.hospital_vm.controller;

import com.example.hospital_vm.model.Paciente;
import com.example.hospital_vm.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/pacientes")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String saludo() {
        return "Hola Mundo";
    }
    
    @GetMapping("/listar")
    public List <Paciente> () {
        return new String();
    }
    



    @GetMapping("/{id}")
    public ResponseEntity <?> getPatientById (@PathVariable Integer id) {
       
        Optional <Paciente> paciente = PacienteService.getPatientById(id);
                    String headerName;
                    return ResponseEntity.ok()
                    .header (headerName: "mi-encabezado", "valor")
                    .body (paciente.get())

    }
    



}
