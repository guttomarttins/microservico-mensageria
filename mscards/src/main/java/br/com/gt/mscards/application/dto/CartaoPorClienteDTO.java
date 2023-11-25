package br.com.gt.mscards.application.dto;

import br.com.gt.mscards.domain.Cartao;
import br.com.gt.mscards.domain.ClienteCartao;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartaoPorClienteDTO {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartaoPorClienteDTO fromModel(ClienteCartao model){
        return new CartaoPorClienteDTO(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }
}
