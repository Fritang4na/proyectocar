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
import warmachine.mcqueen.prueba.model.MarcaModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @GetMapping()
    public List<MarcaModel> list() {
        return MarcaModel.marcas;
    }
    
    @GetMapping("/{id}")
    public MarcaModel get(@PathVariable String id) {
        MarcaModel marca = new MarcaModel();
        
        return marca.buscaMarca(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> put(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        MarcaModel marca = new MarcaModel();
        
        
        
        return new ResponseEntity<>(marca.editarMarca(Integer.parseInt(id), marcaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MarcaModel nuevaMarca) {
        MarcaModel marca = new MarcaModel();
        
        if (marca.nuevaMarca(nuevaMarca)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MarcaModel marca = new MarcaModel();
        
        if (marca.eliminarMarca(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
