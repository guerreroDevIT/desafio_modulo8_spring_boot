
package com.portfolio.isaac.Repository;

import com.portfolio.isaac.Entity.Curriculum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCurriculum extends JpaRepository<Curriculum, Integer> {
    public Optional<Curriculum> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
