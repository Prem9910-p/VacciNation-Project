package com.example.VacciNation.service;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.dto.request.PatientRequest;
import com.example.VacciNation.dto.response.PatientResponse;
import com.example.VacciNation.exception.PatientNotFoundException;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    public PatientResponse addPatient(PatientRequest patientRequest)
    {
        Patient patient=new Patient();
        patient.setVaccinated(false);
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setEmailId(patientRequest.getEmailId());
        patient.setAge(patientRequest.getAge());
        patientRepository.save(patient);


        PatientResponse patientResponse =new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setVaccinated(patient.isVaccinated());
        patientResponse.setEmailId(patientRequest.getEmailId());
        patientResponse.setAge(patientRequest.getAge());
        return patientResponse;
    }

    public PatientResponse getPatient(int id)  {
        Optional<Patient>patientOptional=patientRepository.findById(id);

        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }
        Patient patient= patientOptional.get();
        PatientResponse patientResponse=new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setVaccinated(patient.isVaccinated());
        patientResponse.setEmailId(patient.getEmailId());
        patientResponse.setAge(patient.getAge());
        return patientResponse;

    }

    public List<PatientResponse> getAllByGender(Gender gender) {
           List<Patient> patients=patientRepository.getAllByGender(gender);
            List<PatientResponse> patientResponses=new ArrayList<>();

            for (Patient patient:patients){
                PatientResponse patientResponse=new PatientResponse();
                patientResponse.setVaccinated(patient.isVaccinated());
                patientResponse.setName(patient.getName());
                patientResponse.setEmailId(patient.getEmailId());
                patientResponse.setAge(patient.getAge());
                patientResponses.add(patientResponse);

            }
            return patientResponses;
    }


    public List<Patient> getAllVaccinatedPatients(Boolean vaccinated) {
        return patientRepository.findByVaccinated(vaccinated);

    }
}
