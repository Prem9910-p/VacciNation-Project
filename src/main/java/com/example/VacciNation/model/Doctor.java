package com.example.VacciNation.model;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.Enum.Specialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {
    @Id
    private int id;

    private String name;

    private int age;

    private Gender gender;

    private Specialization specialization;
}
