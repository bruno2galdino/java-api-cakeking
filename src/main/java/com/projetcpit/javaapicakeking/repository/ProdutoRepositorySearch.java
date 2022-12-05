/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.repository;

import com.projetcpit.javaapicakeking.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface ProdutoRepositorySearch extends JpaRepository<Produto, Long>{
    List<Produto> findByDescricaoContainingIgnoreCase(String descricao);
    
    @Query("SELECT p FROM produto p WHERE p.descricao LIKE %:descricao%")
    List<Produto> findByDescricaoLike(@Param("descricao") String descricao);
}
