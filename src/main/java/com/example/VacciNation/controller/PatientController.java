package com.example.VacciNation.controller;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.dto.request.PatientRequest;
import com.example.VacciNation.dto.response.PatientResponse;
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
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest) {
        try {
           PatientResponse patientResponse= patientService.addPatient(patientRequest);
            return new ResponseEntity(patientResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
        @GetMapping("/get")
         public PatientResponse getPatient(@RequestParam("id") int id){

             PatientResponse patientResponse=patientService.getPatient(id);
             return patientResponse;
        }


        @GetMapping("/get/{gender}")
        public List<PatientResponse> getAllByGender(@PathVariable("gender") Gender gender){
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
