
package com.MiPortfolio.Oscar.Controller;


import com.MiPortfolio.Oscar.Dto.dtoEstudios;
import com.MiPortfolio.Oscar.Entity.Estudios;
import com.MiPortfolio.Oscar.Security.Controller.Mensaje;
import com.MiPortfolio.Oscar.Service.Sestudios;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://CarpetaFrontend.web.app")
public class CEstudios {
    @Autowired
    Sestudios sEstudios;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list(){
         List<Estudios> list = sEstudios.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios>getById(@PathVariable("id")int id){
       if(!sEstudios.existsById(id)){
           return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
       } 
       Estudios estudios = sEstudios.getOne(id).get();
    return new ResponseEntity(estudios, HttpStatus.OK);
    }
    
            
            
            
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sEstudios.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);            
        }
        sEstudios.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
        
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudios dtoestudios){
        if(StringUtils.isBlank(dtoestudios.getNombreE())){
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    } 
        
        if(sEstudios.existsByNombreE(dtoestudios.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
         Estudios estudios = new Estudios(dtoestudios.getNombreE(), dtoestudios.getDescripcionE());
         sEstudios.save(estudios);
         return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoEstudios dtoestudios){
        if(!sEstudios.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEstudios.existsByNombreE(dtoestudios.getNombreE())&& sEstudios.getByNombreE(dtoestudios.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            }
        if(StringUtils.isBlank(dtoestudios.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }     
        if(StringUtils.isBlank(dtoestudios.getDescripcionE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }      
        
    Estudios estudios = sEstudios.getOne(id).get();
    estudios.setNombreE(dtoestudios.getNombreE());
    estudios.setDescripcionE(dtoestudios.getDescripcionE());
    sEstudios.save(estudios);
    return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
}
}

