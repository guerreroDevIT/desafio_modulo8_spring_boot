
package com.portfolio.isaac.Service;

import com.portfolio.isaac.Entity.Acercade;
import com.portfolio.isaac.Repository.RAcercade;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class Sacercade {
    
    @Autowired
     RAcercade rAcercade;
     
     public List<Acercade> list(){
         return rAcercade.findAll();
     }
     
     public Optional<Acercade> getOne(int id){
         return rAcercade.findById(id);
     }
     
     public Optional<Acercade> getByDescripcionE(String descripcionE){
         return rAcercade.findByDescripcionE( descripcionE);
     }
     
     public void save(Acercade acer){
         rAcercade.save(acer);
     }
     
     public void delete(int id){
         rAcercade.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rAcercade.existsById(id);
     }
     
     public boolean existsByDescripcionE(String descripcionE){
         return rAcercade.existsByDescripcionE(descripcionE);
     }
    
}
