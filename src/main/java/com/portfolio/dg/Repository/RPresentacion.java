
package com.portfolio.dg.Repository;

import com.portfolio.dg.Entity.Presentacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPresentacion extends JpaRepository<Presentacion, Integer>{
    public Optional<Presentacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
