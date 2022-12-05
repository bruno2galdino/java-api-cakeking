/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Bruno Galdino
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long idCliente;
    private Long idPessoa;
    private String login;
    private String senha;
    private boolean status;
    
}
