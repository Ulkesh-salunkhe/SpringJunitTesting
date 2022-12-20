package com.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ulkesh")
public class Employee {


    @Id
    @GeneratedValue
    int empId;

    String empName;

    String empEmail;

    String empAddress;

    String empPass;






}
