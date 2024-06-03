package com.example.VacciNation.service;


import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public String addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "doctor saved successfully";
    }



    public Optional<Doctor> getDoctor(int id){
        return doctorRepository.findById(id);
    }


    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "doctor has been deleted";
    }
}
