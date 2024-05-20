package br.com.fiapmsentrega.application.entrypoint.rest;

import br.com.fiapmsentrega.application.entrypoint.rest.dto.EntregaRequestDTO;
import br.com.fiapmsentrega.application.entrypoint.rest.dto.EntregaResponseDTO;
import br.com.fiapmsentrega.domain.usecase.CadastrarEntregaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final CadastrarEntregaUseCase cadastrarEntregaUseCase;

    public EntregaController(
            final CadastrarEntregaUseCase cadastrarEntregaUseCase
    ) {
        this.cadastrarEntregaUseCase = cadastrarEntregaUseCase;
    }

    @RequestMapping()
    public ResponseEntity<EntregaResponseDTO> criarEntrega(
            final @RequestBody EntregaRequestDTO entregaRequestDTO
    ) {
        final var entregaDomainRequest = EntregaRequestDTO.paraEntidadeDominio(entregaRequestDTO);
        final var entregaDomainRespone = cadastrarEntregaUseCase.execute(entregaDomainRequest);
        final var responseDTO = EntregaResponseDTO.paraResponseDTO(entregaDomainRespone);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
