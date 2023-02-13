
package com.portfolio.dg.Controller;

import com.portfolio.dg.Dto.dtoPresentacion;
import com.portfolio.dg.Entity.Presentacion;
import com.portfolio.dg.Security.Controller.Mensaje;
import com.portfolio.dg.Service.SPresentacion;
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
@RequestMapping("/presentacion")
@CrossOrigin(origins = "https://portfoliodg.web.app")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class CPresentacion {
    
    @Autowired
    SPresentacion sPresentacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Presentacion>> list(){
        List<Presentacion> list = sPresentacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Presentacion> getById(@PathVariable("id")int id){
        if(!sPresentacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = sPresentacion.getOne(id).get();
        return new ResponseEntity(presentacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPresentacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sPresentacion.delete(id);
        return new ResponseEntity(new Mensaje("Presentacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPresentacion dtopresentacion){
        if(StringUtils.isBlank(dtopresentacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sPresentacion.existsByNombreE(dtopresentacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = new Presentacion(
                dtopresentacion.getNombreE(), dtopresentacion.getDescripcionE(), dtopresentacion.getUbicacionE(), dtopresentacion.getTelefonoE(), dtopresentacion.getEmailE()
            );
        sPresentacion.save(presentacion);
        return new ResponseEntity(new Mensaje("Presentacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPresentacion dtopresentacion){
        if(!sPresentacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sPresentacion.existsByNombreE(dtopresentacion.getNombreE()) && sPresentacion.getByNmbreE(dtopresentacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopresentacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = sPresentacion.getOne(id).get();
        
        presentacion.setNombreE(dtopresentacion.getNombreE());
        presentacion.setDescripcionE(dtopresentacion.getDescripcionE());
        presentacion.setUbicacionE(dtopresentacion.getUbicacionE());
        presentacion.setTelefonoE(dtopresentacion.getTelefonoE());
        presentacion.setEmailE(dtopresentacion.getEmailE());
        
        sPresentacion.save(presentacion);
        
        return new ResponseEntity(new Mensaje("Presentacion actualizada"), HttpStatus.OK);
    }
    
}
