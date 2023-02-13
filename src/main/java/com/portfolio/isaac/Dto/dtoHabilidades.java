
package com.portfolio.isaac.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidades {
    @NotBlank
    private String nombreE;
    

    public dtoHabilidades() {
    }
    
    

    public dtoHabilidades(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    

    
}
