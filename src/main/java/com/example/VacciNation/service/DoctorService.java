package com.example.VacciNation.service;


import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public String addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "doctor saved successfully";
    }

    public Dose addDose(int patientId, Dose dose) {
        //  1 1st check patient is valid
        return dose;
    }

    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "doctor has been deleted";
    }
}
