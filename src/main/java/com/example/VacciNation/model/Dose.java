package com.example.VacciNation.model;

import com.example.VacciNation.Enum.VaccineBrand;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {
    @Id
    private int id;

    private String SerialNumber;

    private VaccineBrand vaccineBrand;


    @CreationTimestamp
    private Date dateOfVaccine;

    @OneToOne
    @JoinColumn
    Patient patient;
}
