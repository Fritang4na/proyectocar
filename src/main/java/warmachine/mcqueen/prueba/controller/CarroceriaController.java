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
import warmachine.mcqueen.prueba.model.CarroceriaModel;
import warmachine.mcqueen.prueba.repository.CarroceriaRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
    @Autowired
    private CarroceriaRepository carroceriaRepository;
    
    @GetMapping()
    public Iterable<CarroceriaModel> list() {
        return carroceriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaModel> get(@PathVariable String id) {
        Optional<CarroceriaModel> caOptional = carroceriaRepository.findById(Integer.parseInt(id));
        if(caOptional.isPresent()){
            CarroceriaModel cEncontrado = caOptional.get();
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> put(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        
        Optional<CarroceriaModel> caOptional = carroceriaRepository.findById(Integer.parseInt(id));
        if(caOptional.isPresent()){
            CarroceriaModel caEncontrado = caOptional.get();
            carroceriaEditar.setIdCarroceria(caEncontrado.getIdCarroceria());
            carroceriaRepository.save(carroceriaEditar);
            return new ResponseEntity<>(carroceriaEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CarroceriaModel nuevaCarroceria) {
        
        nuevaCarroceria = carroceriaRepository.save(nuevaCarroceria);
        
        Optional<CarroceriaModel> caOptional = carroceriaRepository.findById(nuevaCarroceria.getIdCarroceria());
        if(caOptional.isPresent()){
            CarroceriaModel caEncontrado = caOptional.get();
            
            return new ResponseEntity<>(caEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CarroceriaModel> caOptional = carroceriaRepository.findById(Integer.parseInt(id));
        if(caOptional.isPresent()){
            CarroceriaModel caEncontrado = caOptional.get();
            carroceriaRepository.deleteById(caEncontrado.getIdCarroceria());
            return new ResponseEntity<>(caEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
