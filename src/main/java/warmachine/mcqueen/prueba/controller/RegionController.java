/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmachine.mcqueen.prueba.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import warmachine.mcqueen.prueba.model.RegionModel;
import warmachine.mcqueen.prueba.repository.RegionRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
    @Autowired
    private RegionRepository regionRepository;
    
    @GetMapping()
    public Iterable<RegionModel> list() {
        return regionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> get(@PathVariable String id) {
        Optional<RegionModel> rOptional = regionRepository.findById(Integer.parseInt(id));
        if(rOptional.isPresent()){
            RegionModel rEncontrado = rOptional.get();
            
            return new ResponseEntity<>(rEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> put(@PathVariable String id, @RequestBody RegionModel regionEditar) {
        
        Optional<RegionModel> rOptional = regionRepository.findById(Integer.parseInt(id));
        if(rOptional.isPresent()){
            RegionModel rEncontrado = rOptional.get();
            regionEditar.setIdRegion(rEncontrado.getIdRegion());
            regionRepository.save(regionEditar);
            return new ResponseEntity<>(regionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody RegionModel nuevaRegion) {
        
        nuevaRegion = regionRepository.save(nuevaRegion);
        
        Optional<RegionModel> rOptional = regionRepository.findById(nuevaRegion.getIdRegion());
        if(rOptional.isPresent()){
            RegionModel rEncontrado = rOptional.get();
            
            return new ResponseEntity<>(rEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<RegionModel> rOptional = regionRepository.findById(Integer.parseInt(id));
        if(rOptional.isPresent()){
            RegionModel rEncontrado = rOptional.get();
            regionRepository.deleteById(rEncontrado.getIdRegion());
            return new ResponseEntity<>(rEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
