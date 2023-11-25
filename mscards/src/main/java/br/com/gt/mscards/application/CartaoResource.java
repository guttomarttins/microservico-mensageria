package br.com.gt.mscards.application;

import br.com.gt.mscards.application.dto.CartaoPorClienteDTO;
import br.com.gt.mscards.application.dto.CartaoSaveDTO;
import br.com.gt.mscards.domain.Cartao;
import br.com.gt.mscards.domain.ClienteCartao;
import br.com.gt.mscards.infra.service.CartaoService;
import br.com.gt.mscards.infra.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CartaoResource {

    private final CartaoService service;

    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveDTO dto){
        Cartao obj = dto.toModel();
        service.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity getCartoesRendaAteh(@RequestParam("renda") Long renda){
        return ResponseEntity.ok(service.getCartoesRendaMenorIgual(renda));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoPorClienteDTO>> getCartoesNyCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = clienteCartaoService.listCartoesPorCpf(cpf);
        List<CartaoPorClienteDTO> resultList = list.stream()
                .map(CartaoPorClienteDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
