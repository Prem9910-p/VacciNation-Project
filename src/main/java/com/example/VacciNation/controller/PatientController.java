package com.example.VacciNation.controller;

import com.example.VacciNation.model.Patient;
import com.example.VacciNation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody Patient patient) {
        try {
            patientService.addPatient(patient);
            return new ResponseEntity("patient has been added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
        @GetMapping("/get")
         public Patient getPatient(@RequestParam("id") int id){
            return patientService.getPatient(id);
        }

}
