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
import warmachine.mcqueen.prueba.model.MedioPagoModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {
    
    @GetMapping()
    public List<MedioPagoModel> list() {
        return MedioPagoModel.medios;
    }
    
    @GetMapping("/{id}")
    public MedioPagoModel get(@PathVariable String id) {
        MedioPagoModel medio = new MedioPagoModel();
        
        return medio.buscaMedio(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel medioEditar) {
        MedioPagoModel medio = new MedioPagoModel();
        
        
        
        return new ResponseEntity<>(medio.editarMedio(Integer.parseInt(id), medioEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoMedio) {
        MedioPagoModel medio = new MedioPagoModel();
        
        if (medio.nuevoMedio(nuevoMedio)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MedioPagoModel medio = new MedioPagoModel();
        
        if (medio.eliminarMedio(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
