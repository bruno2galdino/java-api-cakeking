/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetcpit.javaapicakeking.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.projetcpit.javaapicakeking.model.Produto;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

/**
 *
 * @author User
 */
@JsonComponent
public class ProdutoSerializer extends JsonSerializer<Produto>{

    @Override
    public void serialize(Produto produto, JsonGenerator jsonGerator, SerializerProvider serialProvider) throws IOException {
        jsonGerator.writeStartObject();        
        jsonGerator.writeNumberField("idproduto", produto.getIdproduto());
        jsonGerator.writeStringField("descricao", produto.getDescricao());
        jsonGerator.writeNumberField("qtdEstoque", produto.getQtdEstoque());
        jsonGerator.writeStringField("detalhe", produto.getDetalhe());
        jsonGerator.writeBooleanField("status", produto.getStatus());
        jsonGerator.writeStringField("imgProduto", produto.getImgProduto());
        jsonGerator.writeNumberField("pvenda", produto.getPVenda());
        jsonGerator.writeEndObject();
    }
    
}
