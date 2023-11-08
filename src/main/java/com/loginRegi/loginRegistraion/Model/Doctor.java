package com.loginRegi.loginRegistraion.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String degree;
    private int experience;

    private String research_journal;
    private String citations;
    private String contact;

    @Column(unique = true)
    private String email;
    private String password;

//    @Lob
//    @Column(name = "image", columnDefinition = "BLOB")
//    private byte[] image;
}