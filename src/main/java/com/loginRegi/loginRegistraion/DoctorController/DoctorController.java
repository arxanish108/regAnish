package com.loginRegi.loginRegistraion.DoctorController;

import com.loginRegi.loginRegistraion.Service.DoctorService;
import com.loginRegi.loginRegistraion.Dto.DoctorDto;
import com.loginRegi.loginRegistraion.payloadResponse.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/doctorCnt")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:63342")
    public String saveEmployee(@RequestBody DoctorDto doctorDto)
    {
        System.out.print("hello");
        String id = doctorService.addDoctor(doctorDto);
        return id;
    }


    @PostMapping("/logIn")
    public ResponseEntity<?> logInDoctor(@RequestBody DoctorDto doctorDto){
        LoginMessage message = doctorService.logInDoctor(doctorDto);
        return ResponseEntity.ok(message);
    }





}


