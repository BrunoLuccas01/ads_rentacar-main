package br.com.jlgregorio.rentacar.vehicledto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {

    private int id;
    private String modelName;
    private String assembler;
    private Integer manufactureYear;

    public String modelYear() {
        return this.modelName + "" + this.assembler;
    }

}
