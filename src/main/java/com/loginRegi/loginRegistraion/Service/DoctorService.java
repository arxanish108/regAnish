package com.loginRegi.loginRegistraion.Service;

import com.loginRegi.loginRegistraion.Dto.DoctorDto;
import com.loginRegi.loginRegistraion.payloadResponse.LoginMessage;


public interface DoctorService {
    String addDoctor(DoctorDto doctorDto);

    LoginMessage logInDoctor(DoctorDto doctorDto);
}
