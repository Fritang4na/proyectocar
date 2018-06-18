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
import warmachine.mcqueen.prueba.model.ArriendoModel;
import warmachine.mcqueen.prueba.model.DevolucionModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @GetMapping()
    public List<DevolucionModel> list() {
        return DevolucionModel.devoluciones;
    }
    
    @GetMapping("/{id}")
    public DevolucionModel get(@PathVariable String id) {
        DevolucionModel devolucion = new DevolucionModel();
        
        return devolucion.buscaDevolucion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> put(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
        DevolucionModel devolucion = new DevolucionModel();
        
        
        
        return new ResponseEntity<>(devolucion.editarDevolucion(Integer.parseInt(id), devolucionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody DevolucionModel nuevaDevolucion) {
        DevolucionModel devolucion = new DevolucionModel();
        
        ArriendoModel a = new ArriendoModel();
        
        nuevaDevolucion.setArriendo(a.buscaArriendo(nuevaDevolucion.getArriendo().getIdArriendo()));
        
        if (devolucion.nuevaDevolucion(nuevaDevolucion)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        DevolucionModel devolucion = new DevolucionModel();
        
        if (devolucion.eliminarDevolucion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
