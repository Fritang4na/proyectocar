/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmachine.mcqueen.prueba.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import warmachine.mcqueen.prueba.model.CiudadModel;
import warmachine.mcqueen.prueba.model.RegionModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
    @GetMapping()
    public List<CiudadModel> list() {
        return CiudadModel.ciudades;
    }
    
    @GetMapping("/{id}")
    public CiudadModel get(@PathVariable String id) {
        CiudadModel ciudad = new CiudadModel();
        
        return ciudad.buscaCiudad(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> put(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
        CiudadModel ciudad = new CiudadModel();
        
        
        
        return new ResponseEntity<>(ciudad.editarCiudad(Integer.parseInt(id), ciudadEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CiudadModel nuevaCiudad) {
        CiudadModel ciudad = new CiudadModel();
        
        RegionModel r = new RegionModel();
        
        nuevaCiudad.setRegion(r.buscaRegion(nuevaCiudad.getRegion().getIdRegion()));
        
        if (ciudad.nuevaCiudad(nuevaCiudad)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        CiudadModel ciudad = new CiudadModel();
        
        if (ciudad.eliminarCiudad(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
