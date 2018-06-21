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
        return null;
      
    }
    
    @GetMapping("/{id}")
    public PersonaModel get(@PathVariable String id) {
        return null;
      
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        return null;
 
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
        return null;
   
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;

}
}