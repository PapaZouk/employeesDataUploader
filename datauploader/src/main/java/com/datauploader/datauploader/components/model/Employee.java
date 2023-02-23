package com.datauploader.datauploader.components.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Size(min = 2, max = 40)
    private String name;
    @NonNull
    @Size(min = 2, max = 40)
    private String surname;
    private String email;

    private String gender;
    private String departament;

    public Employee(@NonNull String name, @NonNull String surname, String email, String gender, String departament) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.departament = departament;
    }
}
