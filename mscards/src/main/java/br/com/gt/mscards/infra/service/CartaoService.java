package br.com.gt.mscards.infra.service;

import br.com.gt.mscards.domain.Cartao;
import br.com.gt.mscards.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    public Cartao save(Cartao obj){
        return repository.save(obj);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
