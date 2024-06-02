package com.example.VacciNation.service;

import com.example.VacciNation.Enum.AppointmentStatus;
import com.example.VacciNation.exception.DoctorNotFoundException;
import com.example.VacciNation.exception.PatientNotFoundException;
import com.example.VacciNation.model.Appointment;
import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.AppointmentRepository;
import com.example.VacciNation.repository.DoctorRepository;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

     @Autowired
    PatientRepository patientRepository;
     @Autowired
     DoctorRepository doctorRepository;
     @Autowired
     AppointmentRepository appointmentRepository;
    public Appointment bookAppointment(int patientId, int doctorId) {
        Optional<Patient> patientOptional=patientRepository.findById(patientId);
        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patient id");
        }

        Optional<Doctor> doctorOptional=doctorRepository.findById(doctorId);
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid doctor id");
        }

        Patient patient=patientOptional.get();
        Doctor doctor=doctorOptional.get();
        Appointment appointment=new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);

    }
}
