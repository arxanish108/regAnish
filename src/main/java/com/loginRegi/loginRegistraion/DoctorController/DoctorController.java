package com.loginRegi.loginRegistraion.DoctorController;

import com.loginRegi.loginRegistraion.Dto.LogInDto;
import com.loginRegi.loginRegistraion.Model.Doctor;
import com.loginRegi.loginRegistraion.Service.DoctorService;
import com.loginRegi.loginRegistraion.Dto.DoctorDto;
import com.loginRegi.loginRegistraion.payloadResponse.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctorCnt")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/save")
    //@CrossOrigin(origins = "http://localhost:63342")
    public String saveEmployee(@RequestBody DoctorDto doctorDto) {
        System.out.print("hello");
        String id = doctorService.addDoctor(doctorDto);
        return id;
    }

    @PostMapping("/logIn")
    public ResponseEntity<?> logInDoctor(@RequestBody LogInDto logInDto){
        LoginMessage message = doctorService.logInDoctor(logInDto);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getDoc")
    public ResponseEntity<Doctor> gatCategoryById(@RequestParam String email){
        Optional<Doctor> category1 = doctorService.findByMail(email);

        if(category1.isPresent()){
            return new ResponseEntity<>(category1.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }







}


