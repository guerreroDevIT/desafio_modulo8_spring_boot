
package com.portfolio.dg.Service;

import com.portfolio.dg.Entity.Presentacion;
import com.portfolio.dg.Repository.RPresentacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPresentacion {
    
    @Autowired
    RPresentacion rPresentacion;
    
    public List<Presentacion> list(){
        return rPresentacion.findAll();
    }
    
    public Optional<Presentacion> getOne(int id){
        return rPresentacion.findById(id);
    }
    
    public Optional<Presentacion> getByNmbreE(String nombreE){
        return rPresentacion.findByNombreE(nombreE);
    }
    
    public void save(Presentacion presentacion){
        rPresentacion.save(presentacion);
    }
    
    public void delete(int id){
        rPresentacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPresentacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rPresentacion.existsByNombreE(nombreE);
    }
    
}
