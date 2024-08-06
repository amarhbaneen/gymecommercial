package com.example.demo.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface StateRepository extends JpaRepository<State,Integer>{
    List<State> findByCountryCode(String country_code);
}
