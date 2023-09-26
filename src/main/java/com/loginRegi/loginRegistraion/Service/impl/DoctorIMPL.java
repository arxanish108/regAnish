package com.loginRegi.loginRegistraion.Service.impl;

import com.loginRegi.loginRegistraion.DoctorRepository.DoctorRepository;
import com.loginRegi.loginRegistraion.Service.DoctorService;
import com.loginRegi.loginRegistraion.Dto.DoctorDto;
import com.loginRegi.loginRegistraion.Model.Doctor;
import com.loginRegi.loginRegistraion.payloadResponse.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorIMPL implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor(
                doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getSpecialization(),
                doctorDto.getDegree(),
                doctorDto.getExperience(),
                doctorDto.getResearch_journal(),
                doctorDto.getCitations(),
                doctorDto.getContact(),
                doctorDto.getEmail(),
                doctorDto.getPassword()
        );
        //builder
        doctorRepository.save(doctor);
        //return doctor.getDoctorName();
        return "Doctor registration done";
        //return doctor;
    }
    DoctorDto doctorDto;
    @Override
    public LoginMessage logInDoctor(DoctorDto doctorDto) {
        String msg = "";
        Doctor doctor1 = doctorRepository.findByEmail(doctorDto.getEmail());
        if (doctor1 != null) {
            String password = doctorDto.getPassword();
            String encodedPassword = doctor1.getPassword();
            //Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            Boolean isPwdRight = password.equals(encodedPassword);
            if (isPwdRight) {
                Optional<Doctor> employee = doctorRepository.findOneByEmailAndPassword(doctorDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }

        //return new LoginMessage("Email not exits", false);
    }

}


