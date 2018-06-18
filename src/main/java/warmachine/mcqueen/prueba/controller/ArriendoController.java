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
import warmachine.mcqueen.prueba.model.MedioPagoModel;
import warmachine.mcqueen.prueba.model.PersonaModel;
import warmachine.mcqueen.prueba.model.VehiculoModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    @GetMapping()
    public List<ArriendoModel> list() {
        return ArriendoModel.arriendos;
    }
    
    @GetMapping("/{id}")
    public ArriendoModel get(@PathVariable String id) {
       ArriendoModel arriendo = new ArriendoModel();
        
        return arriendo.buscaArriendo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ArriendoModel> put(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
        ArriendoModel arriendo = new ArriendoModel();
        
        
        
        return new ResponseEntity<>(arriendo.editarArriendo(Integer.parseInt(id), arriendoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ArriendoModel nuevoArriendo) {
        
        ArriendoModel arriendo = new ArriendoModel();
        
        PersonaModel cliente = new PersonaModel();
        
        nuevoArriendo.setCliente(cliente.buscaPersona(nuevoArriendo.getCliente().getIdPersona()));
        
        PersonaModel vendedor = new PersonaModel();
        
        nuevoArriendo.setVendedor(vendedor.buscaPersona(nuevoArriendo.getVendedor().getIdPersona()));
        
        VehiculoModel v = new VehiculoModel();
        
        nuevoArriendo.setVehiculo(v.buscaVehiculo(nuevoArriendo.getVehiculo().getIdVehiculo()));
        
        MedioPagoModel m = new MedioPagoModel();
        
        nuevoArriendo.setMedioPago(m.buscaMedio(nuevoArriendo.getMedioPago().getIdMedioPago()));
        
        if (arriendo.nuevoArriendo(nuevoArriendo)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ArriendoModel arriendo = new ArriendoModel();
        
        if (arriendo.eliminarArriendo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
