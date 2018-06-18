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
import warmachine.mcqueen.prueba.model.CiudadModel;
import warmachine.mcqueen.prueba.model.PersonaModel;
import warmachine.mcqueen.prueba.model.TipoPersonaModel;

/**
 *
 * @author Fritang4
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @GetMapping()
    public List<PersonaModel> list() {
        return PersonaModel.personas;
    }
    
    @GetMapping("/{id}")
    public PersonaModel get(@PathVariable String id) {
        PersonaModel persona = new PersonaModel();
        
        return persona.buscaPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        PersonaModel persona = new PersonaModel();
        
        
        
        return new ResponseEntity<>(persona.editarPersona(Integer.parseInt(id), personaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
        PersonaModel persona = new PersonaModel();
        
        CiudadModel c = new CiudadModel();
        
        nuevaPersona.setCiudad(c.buscaCiudad(nuevaPersona.getCiudad().getIdCiudad()));
        
        TipoPersonaModel t = new TipoPersonaModel();
        
        nuevaPersona.setTipoPersona(t.buscaTipoP(nuevaPersona.getTipoPersona().getIdTipoPersona()));
        
        if (persona.nuevaPersona(nuevaPersona)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        PersonaModel persona = new PersonaModel();
        
        if (persona.eliminarPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
