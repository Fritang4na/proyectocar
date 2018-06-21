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
import warmachine.mcqueen.prueba.model.TipoPersonaModel;
import warmachine.mcqueen.prueba.repository.TipoPersonaRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository tipoPRepository;
    
    @GetMapping()
    public Iterable<TipoPersonaModel> list() {
        return tipoPRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> get(@PathVariable String id) {
        Optional<TipoPersonaModel> tpOptional = tipoPRepository.findById(Integer.parseInt(id));
        if(tpOptional.isPresent()){
            TipoPersonaModel tpEncontrado = tpOptional.get();
            
            return new ResponseEntity<>(tpEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> put(@PathVariable String id, @RequestBody TipoPersonaModel tipoPEditar) {
        Optional<TipoPersonaModel> tpOptional = tipoPRepository.findById(Integer.parseInt(id));
        if(tpOptional.isPresent()){
            TipoPersonaModel tpEncontrado = tpOptional.get();
            tipoPEditar.setIdTipoPersona(tpEncontrado.getIdTipoPersona());
            tipoPRepository.save(tipoPEditar);
            return new ResponseEntity<>(tipoPEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersonaModel nuevoTipoP) {
        nuevoTipoP = tipoPRepository.save(nuevoTipoP);
        
        Optional<TipoPersonaModel> tpOptional = tipoPRepository.findById(nuevoTipoP.getIdTipoPersona());
        if(tpOptional.isPresent()){
            TipoPersonaModel tpEncontrado = tpOptional.get();
            
            return new ResponseEntity<>(tpEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoPersonaModel> tpOptional = tipoPRepository.findById(Integer.parseInt(id));
        if(tpOptional.isPresent()){
            TipoPersonaModel tpEncontrado = tpOptional.get();
            tipoPRepository.deleteById(tpEncontrado.getIdTipoPersona());
            return new ResponseEntity<>(tpEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
