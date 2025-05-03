package com.example.hospital_vm.controller;

import com.example.hospital_vm.model.Paciente;
import com.example.hospital_vm.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/pacientes")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String  inicio() {
        return "Hola Mundo";
    }
    
    @GetMapping("/listar-pacientes")
    public ResponseEntity<List<Paciente>> listar() {
        List <Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }
    
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
        Paciente pacienteNuevo = pacienteService.save(paciente);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNuevo);
    }
    

     // @GetMapping("/{id}")
    // public ResponseEntity<?> getPacientePorId(@PathVariable Integer id){
    //       Optional<Paciente> paciente = pacienteService.getPacientePorId(id);

    //       if(paciente.isPresent()){
    //         //Respuesta exitosa con cabeceras personalizadas
    //         return ResponseEntity.ok()
    //                 .header("Correcto","Llamada correcto")
    //                 .body(paciente.get());
    //       }else{
    //         //Respuesta de error con cuerpo personalizado
    //         Map<String,String> errorBody = new HashMap<>();
    //         errorBody.put("message","No se encontro un paciente con ese ID: " + id);
    //         errorBody.put("status", "404");
    //         errorBody.put("timestamp",LocalDateTime.now().toString());

    //         return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //                     .body(errorBody);
    //       }
    



}
