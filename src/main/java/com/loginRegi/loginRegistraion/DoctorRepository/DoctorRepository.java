package com.loginRegi.loginRegistraion.DoctorRepository;

import com.loginRegi.loginRegistraion.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
       Optional<Doctor> findOneByEmailAndPassword(String email, String password);
       //Optional<Doctor> findByEmail(String email);

       Optional<Doctor> findByEmail(String email);
}
