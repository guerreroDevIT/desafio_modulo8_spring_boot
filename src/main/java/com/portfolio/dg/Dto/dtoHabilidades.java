
package com.portfolio.dg.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidades {    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private int porcentaje;

    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombreE, String descripcionE, int porcentaje) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.porcentaje = porcentaje;
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    

    
    
    
}
