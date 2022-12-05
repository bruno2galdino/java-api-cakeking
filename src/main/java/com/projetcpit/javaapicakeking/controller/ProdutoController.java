/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projetcpit.javaapicakeking.model.Produto;
import com.projetcpit.javaapicakeking.repository.ProdutoRepository;
import com.projetcpit.javaapicakeking.repository.ProdutoRepositorySearch;
import com.projetcpit.javaapicakeking.serialize.ProdutoSerializer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoRepositorySearch produtoRepositorySearch;
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, ProdutoRepositorySearch produtoRepositorySearch){
        this.produtoRepository = produtoRepository;
        this.produtoRepositorySearch = produtoRepositorySearch;
    }
    

    
    @GetMapping
    public ResponseEntity<?> listar(Pageable pageable) {
        Page<Produto> page = produtoRepository.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable("id") Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Produto> getProdutoByName(@RequestParam(name = "descricao", required = true) String descricao){
        List<Produto> list = produtoRepositorySearch.findByDescricaoContainingIgnoreCase(descricao);        
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
