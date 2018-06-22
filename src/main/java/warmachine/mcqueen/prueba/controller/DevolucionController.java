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
import warmachine.mcqueen.prueba.model.ArriendoModel;
import warmachine.mcqueen.prueba.model.DevolucionModel;
import warmachine.mcqueen.prueba.repository.DevolucionRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @Autowired
    private DevolucionRepository devolucionRepository;
    
    @GetMapping()
    public Iterable<DevolucionModel> list() {
        return devolucionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DevolucionModel> get(@PathVariable String id) {
        Optional<DevolucionModel> dOptional = devolucionRepository.findById(Integer.parseInt(id));
        if(dOptional.isPresent()){
            DevolucionModel dEncontrado = dOptional.get();
            
            return new ResponseEntity<>(dEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> put(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
        Optional<DevolucionModel> dOptional = devolucionRepository.findById(Integer.parseInt(id));
        if(dOptional.isPresent()){
            DevolucionModel dEncontrado = dOptional.get();
            devolucionEditar.setIdDevolucion(dEncontrado.getIdDevolucion());
            devolucionRepository.save(devolucionEditar);
            return new ResponseEntity<>(devolucionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody DevolucionModel nuevaDevolucion) {
        nuevaDevolucion = devolucionRepository.save(nuevaDevolucion);
        
        Optional<DevolucionModel> dOptional = devolucionRepository.findById(nuevaDevolucion.getIdDevolucion());
        if(dOptional.isPresent()){
            DevolucionModel dEncontrado = dOptional.get();
            
            return new ResponseEntity<>(dEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<DevolucionModel> dOptional = devolucionRepository.findById(Integer.parseInt(id));
        if(dOptional.isPresent()){
            DevolucionModel dEncontrado = dOptional.get();
            devolucionRepository.deleteById(dEncontrado.getIdDevolucion());
            return new ResponseEntity<>(dEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
