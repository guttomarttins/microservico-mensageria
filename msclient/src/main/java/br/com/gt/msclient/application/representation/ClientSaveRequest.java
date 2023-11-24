package br.com.gt.msclient.application.representation;

import br.com.gt.msclient.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Client toModel(){
        return new Client(cpf, nome, idade);
    }
}
