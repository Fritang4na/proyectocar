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
import warmachine.mcqueen.prueba.model.CombustibleModel;
import warmachine.mcqueen.prueba.repository.CombustibleRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/combustible")
public class CombustibleController {

    @Autowired
    private CombustibleRepository combustibleRepository;
    
    @GetMapping()
    public Iterable<CombustibleModel> list() {
        
        return combustibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> get(@PathVariable String id) {
        
        Optional<CombustibleModel> cOptional = combustibleRepository.findById(Integer.parseInt(id));
        if(cOptional.isPresent()){
            CombustibleModel cEncontrado = cOptional.get();
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> put(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {
        
        Optional<CombustibleModel> cOptional = combustibleRepository.findById(Integer.parseInt(id));
        if(cOptional.isPresent()){
            CombustibleModel cEncontrado = cOptional.get();
            combustibleEditar.setIdCombustible(cEncontrado.getIdCombustible());
            combustibleRepository.save(combustibleEditar);
            return new ResponseEntity<>(combustibleEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
        
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CombustibleModel nuevoCombustible) {
        
        nuevoCombustible = combustibleRepository.save(nuevoCombustible);
        
        Optional<CombustibleModel> cOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());
        if(cOptional.isPresent()){
            CombustibleModel cEncontrado = cOptional.get();
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CombustibleModel> cOptional = combustibleRepository.findById(Integer.parseInt(id));
        if(cOptional.isPresent()){
            CombustibleModel cEncontrado = cOptional.get();
            combustibleRepository.deleteById(cEncontrado.getIdCombustible());
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
        
    }

}
