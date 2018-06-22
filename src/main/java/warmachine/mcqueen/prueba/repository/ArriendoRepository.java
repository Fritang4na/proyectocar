/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmachine.mcqueen.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import warmachine.mcqueen.prueba.model.ArriendoModel;

/**
 *
 * @author Fritang4
 */
public interface ArriendoRepository extends CrudRepository<ArriendoModel, Integer> {
    
}
