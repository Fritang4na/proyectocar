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

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/tipovehiculo")
public class TipoVehiculoController {
    
    @GetMapping()
    public List<TipoVehiculoModel> list() {
        return TipoVehiculoModel.tiposv;
    }
    
    @GetMapping("/{id}")
    public TipoVehiculoModel get(@PathVariable String id) {
        TipoVehiculoModel tipov = new TipoVehiculoModel();
        
        return tipov.buscaTipoV(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVEditar) {
        TipoVehiculoModel tipov = new TipoVehiculoModel();
        
        
        
        return new ResponseEntity<>(tipov.editarTipoV(Integer.parseInt(id), tipoVEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoV) {
        TipoVehiculoModel tipov = new TipoVehiculoModel();
        
        if (tipov.nuevoTipoV(nuevoTipoV)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoVehiculoModel tipov = new TipoVehiculoModel();
        
        if (tipov.eliminarTipoV(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
