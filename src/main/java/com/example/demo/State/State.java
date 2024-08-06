package com.example.demo.State;

import com.example.demo.Contry.Country;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="state")
@Data
public class State {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
