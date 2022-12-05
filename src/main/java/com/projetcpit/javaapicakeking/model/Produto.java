/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projetcpit.javaapicakeking.serialize.ProdutoSerializer;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Bruno Galdino
 */
@Data
@Entity (name = "produto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")

    public class Produto implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduto; 
    
    @Column
    private String descricao;
    @Column
    private int qtdEstoque;
    @Column
    private double pVenda;
    @Column
    private String detalhe;
    @Column
    private Boolean status;
    @Column
    private String imgProduto;

    
}
