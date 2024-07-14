package com.example.VacciNation.repository;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {



    List<Patient> getAllByGender(Gender gender);


    List<Patient> findByVaccinated(Boolean vaccinated);
}
