
package com.portfolio.isaac.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String periodoE;
    @NotBlank
    private String tituloE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String periodoE, String tituloE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.periodoE = periodoE;
        this.tituloE = tituloE;
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

    public String getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(String periodoE) {
        this.periodoE = periodoE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }
    
    
}
