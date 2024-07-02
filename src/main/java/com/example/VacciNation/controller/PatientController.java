package com.example.VacciNation.controller;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


        @GetMapping("/get/{gender}")
        public List<Patient> getAllByGender(@PathVariable("gender") Gender gender){
        return patientService.getAllByGender(gender);
        }

//        @GetMapping("/get/{vaccinated}")
//        public List<Patient> getAllVaccinatedPatients(@RequestParam(required = false) Boolean vaccinated){
//        if(vaccinated!=null) {
//            return patientService.getAllVaccinatedPatients(vaccinated);
//        }else {
//            return patientService.getAllVaccinatedPatients(null);
//        }
//        }

}
