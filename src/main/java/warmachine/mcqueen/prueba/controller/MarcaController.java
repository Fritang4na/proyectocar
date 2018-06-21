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
import warmachine.mcqueen.prueba.model.MarcaModel;
import warmachine.mcqueen.prueba.repository.MarcaRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping()
    public Iterable<MarcaModel> list() {
        return marcaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> get(@PathVariable String id) {
        Optional<MarcaModel> mOptional = marcaRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            MarcaModel mEncontrado = mOptional.get();
            
            return new ResponseEntity<>(mEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> put(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        
        Optional<MarcaModel> mOptional = marcaRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            MarcaModel mEncontrado = mOptional.get();
            marcaEditar.setIdMarca(mEncontrado.getIdMarca());
            marcaRepository.save(marcaEditar);
            return new ResponseEntity<>(marcaEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MarcaModel nuevaMarca) {
        
        nuevaMarca = marcaRepository.save(nuevaMarca);
        
        Optional<MarcaModel> mOptional = marcaRepository.findById(nuevaMarca.getIdMarca());
        if(mOptional.isPresent()){
            MarcaModel mEncontrado = mOptional.get();
            
            return new ResponseEntity<>(mEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MarcaModel> mOptional = marcaRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            MarcaModel mEncontrado = mOptional.get();
            marcaRepository.deleteById(mEncontrado.getIdMarca());
            return new ResponseEntity<>(mEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
