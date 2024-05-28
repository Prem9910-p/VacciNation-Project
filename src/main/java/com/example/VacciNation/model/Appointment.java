package com.example.VacciNation.model;

import com.example.VacciNation.Enum.AppointmentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {
    @Id
    private int id;

    private String appointmentId;

    private Date dateOfAppointment;

    private AppointmentStatus status;
}
