package br.com.gt.msclient.infra.service;

import br.com.gt.msclient.domain.Client;
import br.com.gt.msclient.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client obj){
        return repository.save(obj);
    }

    public Optional<Client> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }
}
