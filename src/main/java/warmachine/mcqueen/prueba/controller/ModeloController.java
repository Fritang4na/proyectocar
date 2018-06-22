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
import warmachine.mcqueen.prueba.model.ModeloModel;
import warmachine.mcqueen.prueba.model.MarcaModel;
import warmachine.mcqueen.prueba.repository.ModeloRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    @GetMapping()
    public Iterable<ModeloModel> list() {
        return modeloRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ModeloModel> get(@PathVariable String id) {
        Optional<ModeloModel> mOptional = modeloRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            ModeloModel mEncontrado = mOptional.get();
            
            return new ResponseEntity<>(mEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> put(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
        Optional<ModeloModel> mOptional = modeloRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            ModeloModel mEncontrado = mOptional.get();
            modeloEditar.setIdModelo(mEncontrado.getIdModelo());
            modeloRepository.save(modeloEditar);
            return new ResponseEntity<>(modeloEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ModeloModel nuevoModelo) {
        nuevoModelo = modeloRepository.save(nuevoModelo);
        
        Optional<ModeloModel> mOptional = modeloRepository.findById(nuevoModelo.getIdModelo());
        if(mOptional.isPresent()){
            ModeloModel mEncontrado = mOptional.get();
            
            return new ResponseEntity<>(mEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<ModeloModel> mOptional = modeloRepository.findById(Integer.parseInt(id));
        if(mOptional.isPresent()){
            ModeloModel mEncontrado = mOptional.get();
            modeloRepository.deleteById(mEncontrado.getIdModelo());
            return new ResponseEntity<>(mEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
