package com.example.lab3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="departments")
public class Department {
    @Id
    @Column(name="department_id",nullable = false)
    private Integer department_id;

    @Column(name="department_name",nullable = false,length = 30)
    private String department_name;
}
