package br.com.jlgregorio.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_name", length = 50, nullable = false)
    private String modelName;
    @Column(length = 50, nullable = false)
    private String assembler;
    @Column(name = "manufacture_year", nullable = false)
    private int manufactureYear;
    @Column(name = "model_year", nullable = false)
    private int modelYear;

}


