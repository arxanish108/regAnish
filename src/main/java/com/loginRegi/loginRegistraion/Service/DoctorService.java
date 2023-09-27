package com.loginRegi.loginRegistraion.Service;

import com.loginRegi.loginRegistraion.Dto.DoctorDto;
import com.loginRegi.loginRegistraion.Model.Doctor;
import com.loginRegi.loginRegistraion.payloadResponse.LoginMessage;

import java.util.Optional;


public interface DoctorService {
    String addDoctor(DoctorDto doctorDto);

    LoginMessage logInDoctor(DoctorDto doctorDto);

    Optional<Doctor> findByMail(String email);
}
