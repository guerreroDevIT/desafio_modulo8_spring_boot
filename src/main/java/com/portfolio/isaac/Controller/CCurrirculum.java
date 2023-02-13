
package com.portfolio.isaac.Controller;

import com.portfolio.isaac.Dto.dtoCurriculum;
import com.portfolio.isaac.Entity.Curriculum;
import com.portfolio.isaac.Security.Controller.Mensaje;
import com.portfolio.isaac.Service.Scurriculum;
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
@RequestMapping("/curriculum")
@CrossOrigin(origins = "https://portfoliodg.web.app")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class CCurrirculum {
    @Autowired
    Scurriculum sCurriculum;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Curriculum>> list(){
        List<Curriculum> list = sCurriculum.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Curriculum> getById(@PathVariable("id")int id){
        if(!sCurriculum.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Curriculum curriculum = sCurriculum.getOne(id).get();
        return new ResponseEntity(curriculum, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sCurriculum.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sCurriculum.delete(id);
        return new ResponseEntity(new Mensaje("Foto eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCurriculum dtocurriculum){
        if(StringUtils.isBlank(dtocurriculum.getNombreE())){
            return new ResponseEntity(new Mensaje("La foto es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(sCurriculum.existsByNombreE(dtocurriculum.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Curriculum curriculum = new Curriculum(
                dtocurriculum.getNombreE()
            );
        sCurriculum.save(curriculum);
        return new ResponseEntity(new Mensaje("Foto creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCurriculum dtocurriculum){
        if(!sCurriculum.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sCurriculum.existsByNombreE(dtocurriculum.getNombreE()) && sCurriculum.getByNmbreE(dtocurriculum.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocurriculum.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Curriculum curriculum = sCurriculum.getOne(id).get();
        
        curriculum.setNombreE(dtocurriculum.getNombreE());
        
        sCurriculum.save(curriculum);
        
        return new ResponseEntity(new Mensaje("Foto actualizada"), HttpStatus.OK);
    }
    
}
