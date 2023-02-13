package com.portfolio.isaac.Controller;


import com.portfolio.isaac.Dto.dtoAcercade;
import com.portfolio.isaac.Entity.Acercade;
import com.portfolio.isaac.Security.Controller.Mensaje;
import com.portfolio.isaac.Service.Sacercade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "https://portfoliodg.web.app")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class CAcercade {
    
    @Autowired
    Sacercade sAcercade;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = sAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acercade> getById(@PathVariable("id")int id){
        if(!sAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Acercade acercade = sAcercade.getOne(id).get();
        return new ResponseEntity(acercade, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercade.delete(id);
        return new ResponseEntity(new Mensaje("Acercade eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoacercade){
        if(StringUtils.isBlank(dtoacercade.getDescripcionE())){
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(sAcercade.existsByDescripcionE(dtoacercade.getDescripcionE())){
            return new ResponseEntity(new Mensaje("Esa descripcion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Acercade acercade = new Acercade(
                dtoacercade.getDescripcionE()
            );
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Acercade creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoacercade){
        if(!sAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sAcercade.existsByDescripcionE(dtoacercade.getDescripcionE()) && sAcercade.getByDescripcionE(dtoacercade.getDescripcionE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoacercade.getDescripcionE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Acercade acercade = sAcercade.getOne(id).get();
        
        acercade.setDescripcionE(dtoacercade.getDescripcionE());
        
        sAcercade.save(acercade);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
}
