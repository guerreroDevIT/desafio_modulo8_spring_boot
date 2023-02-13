
package com.portfolio.isaac.Service;

import com.portfolio.isaac.Entity.Curriculum;
import com.portfolio.isaac.Repository.RCurriculum;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Scurriculum {
    
    
    @Autowired
    RCurriculum rCurriculum;
    
    public List<Curriculum> list(){
        return rCurriculum.findAll();
    }
    
    public Optional<Curriculum> getOne(int id){
        return rCurriculum.findById(id);
    }
    
    public Optional<Curriculum> getByNmbreE(String nombreE){
        return rCurriculum.findByNombreE(nombreE);
    }
    
    public void save(Curriculum curriculum){
        rCurriculum.save(curriculum);
    }
    
    public void delete(int id){
        rCurriculum.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCurriculum.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rCurriculum.existsByNombreE(nombreE);
    }
    
    
}
