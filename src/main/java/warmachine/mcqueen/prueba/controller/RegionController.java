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
import warmachine.mcqueen.prueba.model.RegionModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
    @GetMapping()
    public List<RegionModel> list() {
        return RegionModel.regiones;
    }
    
    @GetMapping("/{id}")
    public RegionModel get(@PathVariable String id) {
        RegionModel region = new RegionModel();
        
        return region.buscaRegion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> put(@PathVariable String id, @RequestBody RegionModel regionEditar) {
        RegionModel region = new RegionModel();
        
        
        
        return new ResponseEntity<>(region.editarRegion(Integer.parseInt(id), regionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody RegionModel nuevaRegion) {
        RegionModel region = new RegionModel();
        
        if (region.nuevaRegion(nuevaRegion)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        RegionModel region = new RegionModel();
        
        if (region.eliminarRegion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
