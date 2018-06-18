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
        return ModeloModel.modelos;
    }
    
    @GetMapping("/{id}")
    public ModeloModel get(@PathVariable String id) {
        ModeloModel modelo = new ModeloModel();
        
        return modelo.buscaModelo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> put(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
        ModeloModel modelo = new ModeloModel();
        
        
        
        return new ResponseEntity<>(modelo.editarModelo(Integer.parseInt(id), modeloEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ModeloModel nuevoModelo) {
        ModeloModel modelo = new ModeloModel();
        
        MarcaModel m = new MarcaModel();
        
        nuevoModelo.setMarca(m.buscaMarca(nuevoModelo.getMarca().getIdMarca()));
        
        
        if (modelo.nuevoModelo(nuevoModelo)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ModeloModel modelo = new ModeloModel();
        
        if (modelo.eliminarModelo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
