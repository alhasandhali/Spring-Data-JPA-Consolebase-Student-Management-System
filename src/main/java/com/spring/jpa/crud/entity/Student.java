package com.spring.jpa.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_jpa")
public class Student {
    @Id
    private String studentID;
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private String program;
    private int batch;
    private String password;
    private String dob;

    @Override
    public String toString() {
        return "Student : {" +
                "studentID = '" + studentID + '\'' +
                ", studentName = '" + studentName + '\'' +
                ", studentEmail = '" + studentEmail + '\'' +
                ", studentPhone = '" + studentPhone + '\'' +
                ", program = '" + program + '\'' +
                ", batch = " + batch +
                ", password = '" + password + '\'' +
                ", dob = '" + dob + '\'' +
                '}';
    }
}
