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
import warmachine.mcqueen.prueba.model.TipoVehiculoModel;
import warmachine.mcqueen.prueba.model.VehiculoModel;
import warmachine.mcqueen.prueba.model.VersionModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @GetMapping()
    public List<VehiculoModel> list() {
        return null;
        
    }
    
    @GetMapping("/{id}")
    public VehiculoModel get(@PathVariable String id) {
        return null;
    
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> put(@PathVariable String id, @RequestBody VehiculoModel vehiculoEditar) {
        return null;
   
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VehiculoModel nuevoVehiculo) {
        return null;
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
   
    }
    
}
