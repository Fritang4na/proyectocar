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
import warmachine.mcqueen.prueba.model.MedioPagoModel;
import warmachine.mcqueen.prueba.repository.MedioPagoRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {
    
    @Autowired
    private MedioPagoRepository medioPRepository;
    
    @GetMapping()
    public Iterable<MedioPagoModel> list() {
        return medioPRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> get(@PathVariable String id) {
        Optional<MedioPagoModel> mpOptional = medioPRepository.findById(Integer.parseInt(id));
        if(mpOptional.isPresent()){
            MedioPagoModel mpEncontrado = mpOptional.get();
            
            return new ResponseEntity<>(mpEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel medioEditar) {
        Optional<MedioPagoModel> mpOptional = medioPRepository.findById(Integer.parseInt(id));
        if(mpOptional.isPresent()){
            MedioPagoModel mpEncontrado = mpOptional.get();
            medioEditar.setIdMedioPago(mpEncontrado.getIdMedioPago());
            medioPRepository.save(medioEditar);
            return new ResponseEntity<>(medioEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoMedio) {
        nuevoMedio = medioPRepository.save(nuevoMedio);
        
        Optional<MedioPagoModel> mpOptional = medioPRepository.findById(nuevoMedio.getIdMedioPago());
        if(mpOptional.isPresent()){
            MedioPagoModel mpEncontrado = mpOptional.get();
            
            return new ResponseEntity<>(mpEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<MedioPagoModel> mpOptional = medioPRepository.findById(Integer.parseInt(id));
        if(mpOptional.isPresent()){
            MedioPagoModel mpEncontrado = mpOptional.get();
            medioPRepository.deleteById(mpEncontrado.getIdMedioPago());
            return new ResponseEntity<>(mpEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
