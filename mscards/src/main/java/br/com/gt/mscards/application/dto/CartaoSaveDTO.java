package br.com.gt.mscards.application.dto;

import br.com.gt.mscards.domain.BandeiraCartao;
import br.com.gt.mscards.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveDTO {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
