package br.com.gt.mscards.infra.service;

import br.com.gt.mscards.domain.Cartao;
import br.com.gt.mscards.domain.ClienteCartao;
import br.com.gt.mscards.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesPorCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
