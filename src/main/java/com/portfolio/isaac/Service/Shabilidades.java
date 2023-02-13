
package com.portfolio.isaac.Service;

import com.portfolio.isaac.Entity.Habilidades;
import com.portfolio.isaac.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Shabilidades {
    @Autowired
    RHabilidades rHabilidades;
    
    public List<Habilidades> list(){
        return rHabilidades.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return rHabilidades.findById(id);
    }
    
    public Optional<Habilidades> getByNmbreE(String nombreE){
        return rHabilidades.findByNombreE(nombreE);
    }
    
    public void save(Habilidades habilidades){
        rHabilidades.save(habilidades);
    }
    
    public void delete(int id){
        rHabilidades.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabilidades.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rHabilidades.existsByNombreE(nombreE);
    }
}
