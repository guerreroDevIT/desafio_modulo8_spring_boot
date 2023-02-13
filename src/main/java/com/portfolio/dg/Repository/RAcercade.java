/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.dg.Repository;

import com.portfolio.dg.Entity.Acercade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercade extends JpaRepository<Acercade, Integer>{
    public Optional<Acercade> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
