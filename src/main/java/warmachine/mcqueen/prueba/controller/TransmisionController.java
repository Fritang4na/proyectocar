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
import warmachine.mcqueen.prueba.model.TransmisionModel;
import warmachine.mcqueen.prueba.repository.TransmisionRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @GetMapping()
    public Iterable<TransmisionModel> list() {
        return transmisionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> get(@PathVariable String id) {
        Optional<TransmisionModel> trOptional = transmisionRepository.findById(Integer.parseInt(id));
        if(trOptional.isPresent()){
            TransmisionModel trEncontrado = trOptional.get();
            
            return new ResponseEntity<>(trEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        
        Optional<TransmisionModel> trOptional = transmisionRepository.findById(Integer.parseInt(id));
        if(trOptional.isPresent()){
            TransmisionModel trEncontrado = trOptional.get();
            transmisionEditar.setIdTransmision(trEncontrado.getIdTransmision());
            transmisionRepository.save(transmisionEditar);
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TransmisionModel nuevaTransmision) {
        
        nuevaTransmision = transmisionRepository.save(nuevaTransmision);
        
        Optional<TransmisionModel> trOptional = transmisionRepository.findById(nuevaTransmision.getIdTransmision());
        if(trOptional.isPresent()){
            TransmisionModel trEncontrado = trOptional.get();
            
            return new ResponseEntity<>(trEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TransmisionModel> trOptional = transmisionRepository.findById(Integer.parseInt(id));
        if(trOptional.isPresent()){
            TransmisionModel trEncontrado = trOptional.get();
            transmisionRepository.deleteById(trEncontrado.getIdTransmision());
            return new ResponseEntity<>(trEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
        
    }
    
}
