package com.example.demo.Contry;

import com.example.demo.State.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="country")
@Data
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @JsonIgnore
    @OneToMany(mappedBy = "country" )
    private List<State> states;





}
