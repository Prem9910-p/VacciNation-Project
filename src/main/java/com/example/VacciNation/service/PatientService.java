package com.example.VacciNation.service;

import com.example.VacciNation.exception.PatientNotFoundException;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {
       return patientRepository.save(patient);
    }

    public Patient getPatient(int id)  {
        Optional<Patient>patientOptional=patientRepository.findById(id);

        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }
        Patient patient= patientOptional.get();
        return patient;
    }
}
