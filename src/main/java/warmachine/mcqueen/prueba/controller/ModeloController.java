/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmachine.mcqueen.prueba.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @GetMapping()
    public List<ModeloModel> list() {
        return null;
        
    }
    
    @GetMapping("/{id}")
    public ModeloModel get(@PathVariable String id) {
        return null;
     
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> put(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
        return null;
  
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ModeloModel nuevoModelo) {
        return null;
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
   
    }
    
}
