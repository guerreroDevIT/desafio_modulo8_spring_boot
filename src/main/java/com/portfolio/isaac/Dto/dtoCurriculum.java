/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.isaac.Dto;

import javax.validation.constraints.NotBlank;

public class dtoCurriculum {
    @NotBlank
    private String nombreE;

    public dtoCurriculum() {
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    

    

   
}
