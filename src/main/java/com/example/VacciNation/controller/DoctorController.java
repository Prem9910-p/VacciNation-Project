package com.example.VacciNation.controller;

import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
          return doctorService.addDoctor(doctor);
    }

    @GetMapping("/get-doctor")
    public Optional<Doctor> getDoctor(@RequestParam int id){
        return doctorService.getDoctor(id);
    }


    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id){
        return doctorService.deleteDoctor(id);
    }

}
