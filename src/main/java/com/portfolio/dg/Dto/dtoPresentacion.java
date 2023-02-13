
package com.portfolio.dg.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPresentacion {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String ubicacionE;
    @NotBlank
    private String telefonoE;
    @NotBlank
    private String emailE;

    public dtoPresentacion() {
    }

    public dtoPresentacion(String nombreE, String descripcionE, String ubicacionE, String telefonoE, String emailE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.ubicacionE = ubicacionE;
        this.telefonoE = telefonoE;
        this.emailE = emailE;
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

    public String getUbicacionE() {
        return ubicacionE;
    }

    public void setUbicacionE(String ubicacionE) {
        this.ubicacionE = ubicacionE;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    

    
    
    
}
