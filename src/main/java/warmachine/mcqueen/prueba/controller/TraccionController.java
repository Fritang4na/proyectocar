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
import warmachine.mcqueen.prueba.model.TraccionModel;
import warmachine.mcqueen.prueba.repository.TraccionRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @Autowired
    private TraccionRepository traccionRepository;
    
    @GetMapping()
    public Iterable<TraccionModel> list() {
        return traccionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> get(@PathVariable String id) {
        Optional<TraccionModel> traOptional = traccionRepository.findById(Integer.parseInt(id));
        if(traOptional.isPresent()){
            TraccionModel traEncontrado = traOptional.get();
            
            return new ResponseEntity<>(traEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> put(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
        Optional<TraccionModel> traOptional = traccionRepository.findById(Integer.parseInt(id));
        if(traOptional.isPresent()){
            TraccionModel traEncontrado = traOptional.get();
            traccionEditar.setIdTraccion(traEncontrado.getIdTraccion());
            traccionRepository.save(traccionEditar);
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TraccionModel nuevaTraccion) {
        
        nuevaTraccion = traccionRepository.save(nuevaTraccion);
        
        Optional<TraccionModel >traOptional = traccionRepository.findById(nuevaTraccion.getIdTraccion());
        if(traOptional.isPresent()){
            TraccionModel traEncontrado = traOptional.get();
            
            return new ResponseEntity<>(traEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TraccionModel> traOptional = traccionRepository.findById(Integer.parseInt(id));
        if(traOptional.isPresent()){
            TraccionModel traEncontrado = traOptional.get();
            traccionRepository.deleteById(traEncontrado.getIdTraccion());
            return new ResponseEntity<>(traEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
