package com.example.VacciNation.controller;


import com.example.VacciNation.Enum.VaccineBrand;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.service.DoctorService;
import com.example.VacciNation.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;
    @PostMapping("/vaccinated")
    public Dose addDose(@RequestParam int patientId, @RequestParam("brand")VaccineBrand vaccineBrand){
        return doseService.addDose(patientId,vaccineBrand);
    }
}
