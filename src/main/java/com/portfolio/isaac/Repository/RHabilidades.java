
package com.portfolio.isaac.Repository;

import com.portfolio.isaac.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidades extends JpaRepository<Habilidades, Integer>{
    public Optional<Habilidades> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
