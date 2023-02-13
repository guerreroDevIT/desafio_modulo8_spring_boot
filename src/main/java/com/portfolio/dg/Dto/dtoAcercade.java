
package com.portfolio.dg.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcercade {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoAcercade() {
    }

    public dtoAcercade(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    

    

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
}
