/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.isaac.Repository;

import com.portfolio.isaac.Entity.Acercade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RAcercade extends JpaRepository<Acercade, Integer> {
    public Optional<Acercade> findByDescripcionE(String descripcionE);
    public boolean existsByDescripcionE(String descripcionE);
    
}
