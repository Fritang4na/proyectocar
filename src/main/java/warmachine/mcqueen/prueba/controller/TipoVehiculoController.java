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
import warmachine.mcqueen.prueba.model.TipoVehiculoModel;
import warmachine.mcqueen.prueba.repository.TipoVehiculoRepository;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/tipovehiculo")
public class TipoVehiculoController {
    
    @Autowired
    private TipoVehiculoRepository tipoVRepository;
    
    @GetMapping()
    public Iterable<TipoVehiculoModel> list() {
        return tipoVRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> get(@PathVariable String id) {
        Optional<TipoVehiculoModel> tvOptional = tipoVRepository.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            
            return new ResponseEntity<>(tvEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVEditar) {
        Optional<TipoVehiculoModel> tvOptional = tipoVRepository.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            tipoVEditar.setIdTipoVehiculo(tvEncontrado.getIdTipoVehiculo());
            tipoVRepository.save(tipoVEditar);
            return new ResponseEntity<>(tipoVEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoV) {
        nuevoTipoV = tipoVRepository.save(nuevoTipoV);
        
        Optional<TipoVehiculoModel> tvOptional = tipoVRepository.findById(nuevoTipoV.getIdTipoVehiculo());
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            
            return new ResponseEntity<>(tvEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoVehiculoModel> tvOptional = tipoVRepository.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            tipoVRepository.deleteById(tvEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(tvEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
}
