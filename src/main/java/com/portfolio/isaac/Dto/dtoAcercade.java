
package com.portfolio.isaac.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcercade {
    
    @NotBlank
    private String descripcionE;
    

    public dtoAcercade() {
    }

    public dtoAcercade(String descripcionE) {
        this.descripcionE = descripcionE;
        
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    
}
