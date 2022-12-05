/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.service;

import com.projetcpit.javaapicakeking.model.Cliente;
import java.util.List;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ClienteService {

    public Cliente create(List<Cliente> clientes) {
        var cliente = new Cliente();
        
        return cliente;
    }

}
